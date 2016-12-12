package cn.xfj.readwrite;

public class ReadThread implements Runnable {

    private ChannelData channelData;
    
    public ReadThread(ChannelData channelData){
        this.channelData = channelData;
    }
    @Override
    public void run() {
        while(true){
            try {
                char[] read = channelData.read();
                StringBuffer buffer = new StringBuffer();
                for (char d : read) {
                    buffer.append(d);
                }
                String showStatement = Thread.currentThread().getName() + "read the char " + buffer.toString();
                System.out.println(showStatement);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
