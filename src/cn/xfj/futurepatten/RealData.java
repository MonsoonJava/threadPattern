package cn.xfj.futurepatten;

public class RealData implements Data{

    private String content = null;
    
    private Exception exception = null;
    
    public Exception getException(){
        return this.exception;
    }
    public RealData(int count,char c){
    
            char[] charBuffer = new char[count];
            for(int i = 0; i < count;i++){
                charBuffer[i] = c;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.content = new String(charBuffer);
    }
    @Override
    public String getContent() {
        return this.content;
    }

}
