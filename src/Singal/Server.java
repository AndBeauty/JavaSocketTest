package Singal;

import java.io.*;
import java.net.*;
public class Server {
    public static final int PORT = 8080;
    public static void main(String[] args)throws IOException{
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("启动服务器：" + s);
        try {
            Socket socket = s.accept();
            try {
                System.out.println("客户端建立连接：" + socket);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                while (true){
                    String str = in.readLine();//接收客户端发过来的消息
                    if(str.equals("END"))
                        break;
                    System.out.println(str);//把客户端发过来的消息打印出来
                    out.println("服务器回复：" + str);//发消息给客户端
                }
            }finally {
                System.out.println("与客户端的连接关闭....");
                socket.close();
            }
        }finally {
            System.out.println("服务器关闭.....");
            s.close();
        }
    }
}
