package Singal;

import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args)throws IOException {
        InetAddress addr = InetAddress.getByName(null);
        System.out.println("地址 = " + addr);
        Socket socket = new Socket(addr, Server.PORT);
        try{
            System.out.println("Socket = " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            for(int i = 0; i < 10; ++i){
                out.println("客户端来信：" + i);//向服务器发送消息
                String str = in.readLine();//接收服务器发过来的消息
                System.out.println(str);//把收到的消息打印出来
            }
            out.println("END");
        }finally {
            System.out.println("客户端关闭....");
            socket.close();
        }

    }
}