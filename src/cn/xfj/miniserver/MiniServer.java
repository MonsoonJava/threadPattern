package cn.xfj.miniserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MiniServer {

    private final int serverPort;
    
    public MiniServer(int serverPort){
        this.serverPort = serverPort;
    }
    
    public void execute() throws IOException{
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Listen on prot " + serverPort);
        try{
            while(true){
                System.out.println("Accepting ...");
                Socket socketClient = serverSocket.accept();
                System.out.println("connected to " + socketClient);
                new Thread(){
                    @Override
                    public void run(){
                        Service.service(socketClient);
                    }
                }.start();
            }
        }finally{
            serverSocket.close(); 
        }
    }
}
