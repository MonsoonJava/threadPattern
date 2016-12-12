package cn.xfj.miniserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Service {
    
    public static void service(Socket socket){
        System.out.println(Thread.currentThread().getName() + ": Service.service (" + socket + ") Begin");
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeBytes("HTTP/1.0 200\r\n");
            out.writeBytes("Content-type: text/html\r\n");
            out.writeBytes("\r\n");
            out.writeBytes("<html><head><title>Countdown</title></head><body>");
            out.writeBytes("<h1>Count start!</h1>");
            for(int i = 10;i > 0;i--){
                System.out.println(Thread.currentThread().getName() + "Count i =" + i);
                out.writeBytes("<br>"+i+"<br>");
                out.flush();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "Service.service (" + socket + ") END");
        }
        
    }
}
