package cn.xfj.permessage;

public class RequestThread implements Runnable{

    private static final Helper helper= new Helper();
    
    private int count ;
    
    private char c ;
    
    public RequestThread(int count, char c) {
        super();
        this.count = count;
        this.c = c;
    }

    @Override
    public void run() {
        helper.hand(count, c);
    }

}
