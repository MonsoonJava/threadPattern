package cn.xfj.futurepatten;

public class FutureData implements Data{

    private RealData realData = null;
    
    private boolean ready = false;
    
    private Exception exception = null;
    
    public synchronized void setRealData(RealData realData){
        if(ready || realData == null){
            return;
        }
        this.realData = realData;
        ready = true;
        this.notifyAll();
    }
    
    @Override
    public synchronized String getContent() throws Exception{
        while(!ready){
            try {
                System.out.println("执行wait");
                this.wait();
                System.out.println("退出wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(exception != null){
            System.out.println("抛出异常");
            throw this.exception;
        }
        return this.realData.getContent();
    }
    
    public synchronized void setException(Exception e){
        if(null == e || ready){
            return;
        }
        this.exception = e;
        ready = true;
        this.notifyAll();
    }

}
