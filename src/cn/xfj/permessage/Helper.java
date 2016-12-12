package cn.xfj.permessage;

public class Helper {
    
    public void hand(int count,char c){
        System.out.println("Hand [begin]" + Thread.currentThread().getName());
        try {
            for(int i = 0;i<count;i++){
                slowly();
                System.out.print(c);
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hand [End]" + Thread.currentThread().getName());
    }

    private void slowly() throws InterruptedException {
        Thread.sleep(1000);
    }

}
