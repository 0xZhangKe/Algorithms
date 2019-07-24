package com.zhangke.algorithms.leetcode;

import java.util.concurrent.CountDownLatch;

/**
 * 按序打印：https://leetcode-cn.com/problems/print-in-order/
 * Created by ZhangKe on 2019/7/24.
 */
public class Foo {

    private CountDownLatch bCountDown;
    private CountDownLatch cCountDown;

    public Foo() {
        bCountDown = new CountDownLatch(1);
        cCountDown = new CountDownLatch(1);
    }

    public void one() {
        print("one");
    }

    public void two() {
        print("two");
    }

    public void three() {
        print("three");
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        bCountDown.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        bCountDown.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        cCountDown.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        cCountDown.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    private void print(String text) {
        System.out.print(text);
    }
}
