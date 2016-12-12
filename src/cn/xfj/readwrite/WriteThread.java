package cn.xfj.readwrite;

import java.util.Random;

public class WriteThread implements Runnable {

    private ChannelData channelData;
    
    private final String ENGLISHCHAR = "QWERTYUIOPASDFJLKZXCVBNM";
    
    private Random random = new Random();     
    
    public WriteThread(ChannelData channelData){
        this.channelData = channelData;
    }
    
    @Override
    public void run() {
        while (true) {
            char charOne = ENGLISHCHAR.charAt(random.nextInt(ENGLISHCHAR.length()));
            try {
                channelData.write(charOne);
                String showStatements = Thread.currentThread().getName() + "write in the char is " + charOne;
                System.out.println(showStatements);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
