package cn.xfj.producerandconsumer;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Table table = new Table(3);
        Thread thread = new Thread(new Producer(table),"No1 Thread");
        thread.start();
        Thread thread2 = new Thread(new Producer(table),"No2 Thread");
        thread2.start();
        Thread thread3 = new Thread(new Producer(table),"No3 Thread");
        thread3.start();
        Thread thread4 = new Thread(new Consumer(table),"No4 Thread");
        thread4.start();
        Thread thread5 = new Thread(new Consumer(table),"No5 Thread");
        thread5.start();
        Thread thread6 = new Thread(new Consumer(table),"No6 Thread");
        thread6.start();
        TimeUnit.SECONDS.sleep(10);
        thread.interrupt();
        thread6.interrupt();
        thread2.interrupt();
        thread3.interrupt();
        thread4.interrupt();
        thread5.interrupt();
        
    }
}
