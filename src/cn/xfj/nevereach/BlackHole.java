package cn.xfj.nevereach;

public class BlackHole {

    public static void enter(Object obj){
        System.out.println("step 1");
        magic(obj);
        System.out.println("step 2");
        synchronized (obj) {
            System.out.println("step3 never reach here");
        }
    }

    private static void magic(final Object obj) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        new Thread(){
            public void run(){
                synchronized (obj) {
                    while(true){
                       
                    }
                }
            }
        }.start();
    }
    
    public static void main(String[] args) {
        BlackHole.enter(new Object());
    }
    
}
