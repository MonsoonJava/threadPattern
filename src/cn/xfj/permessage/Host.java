package cn.xfj.permessage;

public class Host {
    
    private static final Helper helper= new Helper();
    
    private static int threadNumber = 0;
    
    public void request(final int count,final char c){
        System.out.println("Request [begin] " );
        /*new Thread(new Runnable(){
            @Override
            public void run() {
                helper.hand(count, c);
            }
        },"Thread NO." + incThreadNumber()).start();*/
       new Thread(new RequestThread(count,c),"Thread NO." + incThreadNumber()).start();
        System.out.println("Request [End] " );
    }

    private synchronized static int incThreadNumber(){
        return threadNumber++;
    }
}
