package cn.xfj.mythread;

public class TheMain {

    public static void main(String[] args) {
        
        Gate gate = new Gate();
        new Thread(new UserThread(gate,"ada","america")).start();
        new Thread(new UserThread(gate,"bana","bosten")).start();
        new Thread(new UserThread(gate,"caja","china")).start();
    }
}
