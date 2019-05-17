package com.jd;

public class SoulutionTask implements Runnable {
    static int value = 0;

    @Override
    public void run() {
        while (value <= 10) {
            synchronized (SoulutionTask.class) {
                System.out.println(Thread.currentThread().getName() + ":" + value++);
                //notify是唤醒其他等待中线程中的一个和notifyAll是唤醒所有的等待线程
                //但是这个时候执行的线程还持有锁没有释放锁
                SoulutionTask.class.notifyAll();
                try {
                    //wait的时候,原本执行的线程会进入等待,并会释放锁,其他唤醒的线程会竞争获取这个锁
                    SoulutionTask.class.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}