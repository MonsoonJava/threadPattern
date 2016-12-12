package cn.xfj.readwrite;

public class Main {

    public static void main(String[] args) {
        ChannelData channelData = new ChannelData(15);
        new Thread(new ReadThread(channelData),"thread NO.1").start();
        new Thread(new ReadThread(channelData),"thread NO.2").start();
        new Thread(new ReadThread(channelData),"thread NO.3").start();
        new Thread(new ReadThread(channelData),"thread NO.4").start();
        new Thread(new WriteThread(channelData),"thread NO.5").start();
        new Thread(new WriteThread(channelData),"thread NO.6").start();
    }

}
