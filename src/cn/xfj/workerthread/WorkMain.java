package cn.xfj.workerthread;

public class WorkMain {

    public static void main(String[] args) {
        Channel channel = new Channel(5);
        new Thread(new ClientThread(channel,"ALICE")).start();
        new Thread(new ClientThread(channel,"BLIZE")).start();
        new Thread(new ClientThread(channel,"CLAITE")).start();
        channel.startWorkers();
    }
    
}
