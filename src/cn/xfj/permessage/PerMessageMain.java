package cn.xfj.permessage;

public class PerMessageMain {

    public static void main(String[] args) {
        Host host = new Host();
        System.out.println(" Main [begin]");
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println(" Main [end]");
    }
}
