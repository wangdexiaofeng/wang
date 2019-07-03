package com.jd;

public class Test {
    public static void main(String[] args) {
        new Thread(new SoulutionTask(),"奇数").start();
        new Thread(new SoulutionTask(),"偶数").start();

    }
}
