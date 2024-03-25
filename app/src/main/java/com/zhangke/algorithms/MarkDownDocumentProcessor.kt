package com.zhangke.algorithms

import java.io.File
import java.net.URLDecoder
import java.net.URLEncoder

fun main() {
    val processor = MarkDownDocumentProcessor()
    val dir =
        File("/Users/zhangke/Downloads/travel-to-japan")
    processor.processImage(dir, "travel-to-japan")
}

class MarkDownDocumentProcessor {

    companion object {

        private val IMG_REGEX = "!\\[(.*?)\\]\\((.*?)\\)".toRegex()
        private const val UNTITLED_IMG_NOT = "Untitled"
        private const val IMG_PATH_PREFIX = "/assets/img/post/"
    }

    /**
     * This function will rename image name,and replace relative path to blog content.
     * The dir of md file and source dir.
     * * @param blogImageDirName Blog Image Dir name, e.g. clean-android
     */
    fun processImage(fileDir: File, blogImageDirName: String) {
        val mdFile = requireMDFile(fileDir)
        val allText = mdFile.readText()
        val allImageExpression = IMG_REGEX.findAll(allText)
        val allContext = parseContext(allImageExpression.map { it.value }.toList(), blogImageDirName)
        val imageDir = fileDir.listFiles()?.firstOrNull { it.isDirectory }
        var fixedContent = allText
        allContext
            .filter { it.fixed }
            .forEach { context ->
                fixedContent = fixedContent.replace(context.expression, context.fixedExpression!!)
                val newFileName = context.fixedImageName
                val oldImageFile = File(imageDir, context.decodedImageName!!)
                if (oldImageFile.exists() && !newFileName.isNullOrEmpty()) {
                    oldImageFile.renameTo(File(imageDir, context.fixedImageName!!))
                }
            }
        mdFile.writeText(fixedContent)
    }

    private fun requireMDFile(dir: File): File {
        return dir.listFiles()?.firstOrNull { it.extension == "md" }
            ?: throw IllegalStateException("Can't find any MD file!")
    }

    private fun parseContext(expressionList: List<String>, blogImageDirName: String): List<ExpressionContext> {
        return expressionList.mapNotNull { expression ->
            val imageName = findFileNameFromExpression(expression)
            if (imageName.isNullOrEmpty()) return@mapNotNull null
            val decodedImageName = URLDecoder.decode(imageName, Charsets.UTF_8.name())
            val fixedName = URLEncoder.encode(fixImageFileName(decodedImageName), Charsets.UTF_8.name())
            var fixedExpression = expression.replace(imageName, fixedName)
            val imageNote = findImageNoteFromExpression(expression)
            if (imageNote.isNullOrEmpty().not()) {
                val fixedNote = fixImageNote(imageNote!!)
                fixedExpression = fixedExpression.replaceFirst(imageNote, fixedNote)
            }
            val imagePath = findImagePath(expression)
            if (imagePath.isNullOrEmpty().not()) {
                fixedExpression = fixedExpression.replace(imagePath!!, "$IMG_PATH_PREFIX$blogImageDirName")
            }
            ExpressionContext(
                expression = expression,
                imageName = imageName,
                decodedImageName = decodedImageName,
                fixedImageName = fixedName,
                fixedExpression = fixedExpression,
            )
        }.toList()
    }

    private fun findFileNameFromExpression(expression: String): String? {
        val maybeName = expression.split('/').last()
        if (!maybeName.contains('.')) return null
        return maybeName.removeSuffix(")")
    }

    private fun findImageNoteFromExpression(expression: String): String? {
        val start = expression.indexOfFirst { it == '[' }
        val end = expression.indexOfFirst { it == ']' }
        if (start < 0 || end < 0) return null
        return expression.substring(start + 1, end)
    }

    private fun fixImageFileName(name: String): String {
        return name.replace(" ", "")
    }

    private fun fixImageNote(note: String): String {
        if (note == UNTITLED_IMG_NOT) return ""
        return note
    }

    private fun findImagePath(expression: String): String? {
        val start = expression.indexOfFirst { it == '(' }
        val end = expression.indexOfFirst { it == '/' }
        if (start < 0 || end < 0) return null
        return expression.substring(start + 1, end)
    }

    data class ExpressionContext(
        val expression: String,
        // encoded
        val imageName: String,
        val decodedImageName: String,
        // encoded
        val fixedImageName: String,
        val fixedExpression: String,
    ) {

        val fixed: Boolean get() = !fixedExpression.isNullOrEmpty() && !fixedImageName.isNullOrEmpty()
    }
}

