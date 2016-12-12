package cn.xfj.futurepatten;

public class FutureMain {

    public static void main(String[] args) {
        try {
            System.out.println("Main Start");
            Data future1 = Host.request(-1, 'A');
            //Data future2 = Host.request(20, 'B');
            //Data future3 = Host.request(30, 'C');
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // System.out.println(future2.getContent());
            System.out.println(future1.getContent());
           // System.out.println(future3.getContent());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("得到异常");
        } 
        System.out.println("Main stop");
    }
    
}
