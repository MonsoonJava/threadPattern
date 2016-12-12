package cn.xfj.workerthread;

import java.util.Random;

public class ClientThread implements Runnable{

    private static final Random random = new Random();
    
    private int IDCount = 0;
    
    private Channel channel ;
    
    private String name;
    
    public ClientThread(Channel channel,String name){
        this.channel = channel;
        this.name = name;
    }
    
    
    @Override
    public void run() {
        while(true){
            try {
                IDCount++;
                Thread.sleep(random.nextInt(50));
                channel.putRequest(new Request(name,IDCount));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
