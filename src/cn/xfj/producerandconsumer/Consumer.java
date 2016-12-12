package cn.xfj.producerandconsumer;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
    
    private Table table ;
    
    public Consumer(Table table){
        this.table = table;
    }

    @Override
    public void run() {
        while(true){
            try {
                String cake = table.take();
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
