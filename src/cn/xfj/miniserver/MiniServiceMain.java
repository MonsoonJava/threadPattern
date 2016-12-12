package cn.xfj.miniserver;

import java.io.IOException;

public class MiniServiceMain {

    public static void main(String[] args) {
        MiniServer server = new MiniServer(8888);
        try {
            server.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
