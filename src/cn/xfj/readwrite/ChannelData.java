package cn.xfj.readwrite;


public class ChannelData {

    private final ReadWriteLock lock = new ReadWriteLock();
    
    private char[] charData;
    
    public ChannelData(int charSize){
        charData = new char[charSize];
        for (char c : charData) {
            c = '*';
        }
    }
    
    public char[] read() throws InterruptedException{
        lock.readLock();
        try{
            slowly();
            char[] doReadBuffer = doRead();
            return doReadBuffer;
        }finally{
            lock.readUnlock();
        }
    }

    private char[] doRead() {
        char[] charBuffer = new char[charData.length];
        for(int i = 0 ; i < charData.length;i++){
            charBuffer[i] = charData[i];
        }
        return charBuffer;
    }
    
    public void write(char charOne) throws InterruptedException{
        lock.writeLock(); 
        try{
            slowly();
            doWrite(charOne);
        }finally{
            lock.writeUnlock();
        };
    }

    private void doWrite(char charOne) {
        for(int i = 0 ; i < charData.length;i++){
            charData[i] = charOne;
        }
    }
    
    private void slowly() throws InterruptedException{
        Thread.sleep(50);
    }
    
}
