package com.zhangke.algorithms;

public class FindMaxNumbers {

    public static void main(String[] args) {
        FindMaxNumbers obj = new FindMaxNumbers();
        int[] numbers = new int[1000];
        for (int i = 0; i < 1000; i++) {
            numbers[i] = 1000 - i;
        }
        int[] result = obj.findMaxNumbers(numbers);
        for (int i : result) {
            System.out.print(i);
            System.out.print(',');
        }
    }

    private int[] findMaxNumbers(int[] numbers) {
        int temp = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] > numbers[i]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        int[] result = new int[10];
        int j = 0;
        for (int i = numbers.length - 10; i < numbers.length; i++) {
            result[j++] = numbers[i];
        }
        return result;
    }
}
