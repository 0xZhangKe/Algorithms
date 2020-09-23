package com.zhangke.algorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 * 文件工具类
 * <p>
 * Created by ZhangKe on 2019/3/21.
 */
public class FileUtil {

    /**
     * 创建一个随机数文件
     */
    public static void createRandomIntFile(File file, int maxNumber, int size) {
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        Random random = new Random();
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fileWriter)) {
            for (int i = 0; i < size; i++) {
                bw.write(random.nextInt(maxNumber) + "\n");
            }
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
