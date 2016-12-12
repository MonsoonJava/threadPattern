package cn.xfj.workerthread;

public class Request {

    private String name;
    
    private int numberID;
    
    public Request(String name,int numberID){
        this.name = name;
        this.numberID = numberID;
    }
    
    public void execute() throws InterruptedException{
        Thread.sleep(100);
        System.out.println("[" + name + "] ’s " + numberID +" request is consumered by " + Thread.currentThread().getName() );
    }
}
