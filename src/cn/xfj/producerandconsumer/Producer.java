package cn.xfj.producerandconsumer;

import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {

    private static int ProductID = 0;
    
    private Table table;
    
    private synchronized static int increaseID(){
        int number = ProductID++;
        return number;
    }
    
    public Producer(Table table){
        this.table = table;
    }
    
    private  String getCake(){
        return Thread.currentThread().getName() + " produce the " + increaseID() +" cake";
    }
    
    @Override
    public void run() {
        while(true){
            String cake = this.getCake();
            try {
                TimeUnit.SECONDS.sleep(2);
                table.put(cake);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
