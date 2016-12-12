package cn.xfj.twophasetreminate;

public class CountMain {

    public static void main(String[] args) throws InterruptedException {
        CountThread countThread = new CountThread();
        Thread thread = new Thread(countThread);
        thread.start();
        Thread.sleep(10);
        System.out.println("发出interrupt");
        //countThread.toStop();
        thread.interrupt();
        thread.join();
    }
}
