package com.zhangke.algorithms;

public class Main {

    public static void main(String[] args) {
        int chunkLength = 0x89ABCDEF;
        byte[] array = new byte[4];
        convertToByteArray(array, chunkLength);
        for (int a : array){
            System.out.println(Integer.toHexString(a));
        }
    }

    private static void convertToByteArray(byte[] packet, int chunkLength){
        packet[0] = (byte) ((0xFF000000 & chunkLength) >>> 24);
        packet[1] = (byte)((0x00FF0000 & chunkLength) >>> 16);
        packet[2] = (byte)((0x0000FF00 & chunkLength) >>> 8);
        packet[3] = (byte)(0x000000FF & chunkLength);
    }
}