package cn.xfj.workerthread;

public class Channel {

    private static final int REQUEST_QUEUE_LENGTH = 100;
    
    private Request[] requestQueue;
    
    private Thread[] threadPool;
    
    private int head;//下一个request读取的位置
    
    private int tail;//下一个request存放的位置
    
    private int count;//request的总个数
    
    public Channel(int poolSize){
        requestQueue = new Request[REQUEST_QUEUE_LENGTH];
        threadPool = new Thread[poolSize];
        
        for(int i = 0; i < threadPool.length; i++){
            threadPool[i] = new Thread(new WorkerThread(this),"Thread NO." + i);
        }
        head = 0;
        tail = 0;
        count = 0;
    }
    
    public synchronized void putRequest(Request request) throws InterruptedException{
        while(count > requestQueue.length ){
            this.wait();
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        this.notifyAll();
    }
    
    public synchronized Request getRequest() throws InterruptedException{
        while(count <= 0 ){
            this.wait();
        }
        Request returnRequest = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        this.notifyAll();
        return returnRequest;
    }
    
    public void startWorkers(){
        for(int i = 0; i < threadPool.length ; i++){
            threadPool[i].start();
        }
    }
    
}
