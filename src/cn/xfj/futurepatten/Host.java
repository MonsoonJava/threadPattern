package cn.xfj.futurepatten;

public class Host {

    public static Data request(final int count,final char c){
        final FutureData futureData = new FutureData();
        System.out.println("Request start");
        new Thread(){
            public void run(){
                System.out.println("subThread start");
                try {
                    RealData realData = new RealData(count,c);
                    futureData.setRealData(realData);
                } catch (Exception e) {
                    futureData.setException(e);;
                }
                System.out.println("subThread end");
            }
        }.start();
        System.out.println("Request end");
        return futureData;
        
    }
    
}
