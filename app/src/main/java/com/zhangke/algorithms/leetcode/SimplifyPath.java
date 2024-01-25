package com.zhangke.algorithms.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/simplify-path/description/">71. 简化路径</a>
 */
public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();

        System.out.println(simplifyPath.simplifyPath("/home/"));
        System.out.println(simplifyPath.simplifyPath("/../"));
        System.out.println(simplifyPath.simplifyPath("/home//foo/"));
        System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));
    }

    public String simplifyPath(String path) {
        List<String> dirNameList = new ArrayList<>();
        String[] array = path.split("/");
        for (String name : array) {
            if (name.isEmpty()) continue;
            StringBuilder builder = new StringBuilder();
            for (char c : name.toCharArray()) {
                if (c != '/') {
                    builder.append(c);
                }
            }
            String finalName = builder.toString();
            if (finalName.equals(".")) continue;
            if (finalName.equals("..")) {
                if (!dirNameList.isEmpty()) {
                    dirNameList.remove(dirNameList.size() - 1);
                }
                continue;
            }
            dirNameList.add(finalName);
        }
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append('/');
        for (int i = 0; i < dirNameList.size(); i++) {
            pathBuilder.append(dirNameList.get(i));
            if (i < dirNameList.size() - 1) {
                pathBuilder.append("/");
            }
        }
        return pathBuilder.toString();
    }
}
