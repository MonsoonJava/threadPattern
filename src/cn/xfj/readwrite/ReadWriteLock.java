package cn.xfj.readwrite;

public class ReadWriteLock {

    private int readingReaders = 0;
    
    private int writingWriters = 0;
    
    private int waitingWriters = 0;
    
    private boolean preferWrite = true;
    
    public synchronized void readLock() throws InterruptedException{
        while(writingWriters > 0 || (waitingWriters >0 && preferWrite)){
            this.wait();
        }
        readingReaders++;
    }
    
    public synchronized void readUnlock(){
        readingReaders--;
        preferWrite = true;
        this.notifyAll();
    }
    
    public synchronized void writeLock() throws InterruptedException{
        waitingWriters++;
        try {
            while(writingWriters >0 || readingReaders > 0){
                this.wait();
            }
        } finally {
            waitingWriters--;
        }
        writingWriters++;
    }
    
    public synchronized void writeUnlock(){
        writingWriters--;
        preferWrite = false;
        this.notifyAll();
    }
    
}
