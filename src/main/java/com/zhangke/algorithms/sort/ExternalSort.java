package com.zhangke.algorithms.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 外部排序
 * <p>
 * Created by ZhangKe on 2019/3/21.
 */
public class ExternalSort {

    /**
     * 模拟内存限制，最大为 1000 个数字
     */
    private final int MAX_MEM_LIMIT = 1000;

    private File tmpDir = new File("./");

    private File targetFile;
    private File resultFile;

    private int sortTmpFileIndex = 0;

    private int sortOutFileIndex = 0;

    private QuickSort quickSort;

    public static void main(String[] args) {
        File targetFile = new File("./target.txt");
//        FileUtil.createRandomIntFile(targetFile, 1000, 100000);


        File resultFile = new File("./result.txt");
        ExternalSort externalSort = new ExternalSort(targetFile, resultFile);
        long start = System.currentTimeMillis();
        externalSort.sort();
        System.out.println("spend:" + (System.currentTimeMillis() - start) + "ms");
    }

    public ExternalSort(File targetFile, File resultFile) {
        quickSort = new QuickSort();
        this.targetFile = targetFile;
        this.resultFile = resultFile;
    }

    public void sort() {
        if (targetFile == null ||
                !targetFile.exists() ||
                targetFile.isDirectory()) {
            return;
        }
        List<File> fileList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(targetFile);
             BufferedReader reader = new BufferedReader(fileReader)) {
            int[] numbers = new int[MAX_MEM_LIMIT];
            int index = 0;
            while (true) {
                String num = reader.readLine();//从原文件中读取一条记录
                if (num == null) {//如果读取完毕后，进行一次排序并保存
                    if (index > 0) {
                        fileList.add(sortAndSave(numbers, index));
                    }
                    break;
                }
                numbers[index] = Integer.valueOf(num);
                index++;
                if (index == MAX_MEM_LIMIT) {//当nums里面读的数字到达长度边界时，排序，存储
                    fileList.add(sortAndSave(numbers, index));//sortAndSave是将nums中前index条记录先快速排序，然后存入文件，最好将文件名返回。
                    index = 0;//重置index
                }
            }
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        mergeSort(fileList);
    }

    /**
     * 使用快速排序将数组的前 size 为排序，然后保存到临时文件
     */
    private File sortAndSave(int[] nums, int size) {
        quickSort.sort(nums, 0, size - 1);
        File file = new File(tmpDir, String.format("sortTmp%s.txt", sortTmpFileIndex++));
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fileWriter)) {
            for (int a : nums) {
                bw.write(a + "\n");
            }
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        return file;
    }

    private void mergeSort(List<File> fileList) {
        List<File> tempFileList = new ArrayList<>();
        for (int i = 0; i < fileList.size(); i++) {
            try {
                File outTmpFile = new File(tmpDir, String.format("sortOutTmp%s.txt", sortOutFileIndex++));
                tempFileList.add(outTmpFile);
                BufferedWriter bw = new BufferedWriter(new FileWriter(outTmpFile));

                File file1 = fileList.get(i++);
                BufferedReader br1 = new BufferedReader(new FileReader(file1));
                if (i < fileList.size()) {
                    File file2 = fileList.get(i);
                    BufferedReader br2 = new BufferedReader(new FileReader(file2));
                    int num1 = 0;
                    int num2 = 0;
                    boolean isFirst = true;
                    boolean firstNext = true;
                    String numVal1 = null, numVal2 = null;
                    for (; ; ) {
                        if (isFirst) {
                            numVal1 = br1.readLine();
                            numVal2 = br2.readLine();
                            num1 = Integer.valueOf(numVal1);
                            num2 = Integer.valueOf(numVal2);
                            isFirst = false;
                        } else if (firstNext) {
                            numVal1 = br1.readLine();
                        } else {
                            numVal2 = br2.readLine();
                        }
                        if (numVal1 != null && numVal2 != null) {
                            if (firstNext) {
                                num1 = Integer.valueOf(numVal1);
                            } else {
                                num2 = Integer.valueOf(numVal2);
                            }
                            if (num1 < num2) {
                                bw.write(num1 + "\n");
                                firstNext = true;
                            } else {
                                bw.write(num2 + "\n");
                                firstNext = false;
                            }
                        } else {
                            if (numVal1 != null) bw.write(numVal1 + "\n");
                            if (numVal2 != null) bw.write(numVal2 + "\n");
                            break;
                        }
                    }
                    while (true) {
                        numVal2 = br2.readLine();
                        if (numVal2 != null) {
                            bw.write(numVal2 + "\n");
                        } else {
                            break;
                        }
                    }
                    br2.close();
                    file2.delete();
                }
                while (true) {
                    String numVal1 = br1.readLine();
                    if (numVal1 != null) {
                        bw.write(numVal1 + "\n");
                    } else break;
                }
                br1.close();
                file1.delete();
                bw.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int size = tempFileList.size();
        if (size > 1) {
            mergeSort(tempFileList);
        } else if (size == 1) {
            File file = tempFileList.get(0);
            if (resultFile.exists()) {
                resultFile.delete();
            }
            file.renameTo(resultFile);
        }
    }
}
