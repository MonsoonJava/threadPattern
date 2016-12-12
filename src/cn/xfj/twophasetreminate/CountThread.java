package cn.xfj.twophasetreminate;


public class CountThread implements Runnable{

   // private  volatile boolean requestToStop = false;

    private int countNumber = 0;
    
    
    public final void toStop(){
       // requestToStop = true;
        Thread.currentThread().interrupt();;
    }
    
    @Override
    public void run() {
        try{
            while(!Thread.currentThread().isInterrupted() ){
                System.out.println(Thread.currentThread().isInterrupted());
                dowork();
            }
        }catch(InterruptedException e ){
            System.out.println("异常");
        }finally{
            doStop();
        }
    }

    private void doStop() {
        System.out.println("0000"+Thread.currentThread().isInterrupted());
        
        
        System.out.println("线程停止"+countNumber);
        System.out.println("STOP");
    }

    private void dowork() throws InterruptedException{
        countNumber++;
        System.out.println("countNumber-----" + countNumber);
        if(Thread.currentThread().isInterrupted()){
            Thread.currentThread().interrupted();
        }
       // Thread.sleep(50);
    }
    
    
    
}
