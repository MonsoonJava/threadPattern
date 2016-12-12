package cn.xfj.workerthread;

public class WorkerThread implements Runnable {

    private Channel channel;
    
    public WorkerThread(Channel channel){
        this.channel = channel;
    }
    
    @Override
    public void run() {
        while(true){
            try {
                Request request = channel.getRequest();
                request.execute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

}
