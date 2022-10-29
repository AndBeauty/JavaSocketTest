package mult;

import java.io.*;
import java.net.*;

class ServerWorker extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String id;
    private int readTime = 0;
    public ServerWorker(Socket skt) throws IOException{
        socket = skt;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
        id = in.readLine();
        System.out.println("与客户端" + id + "建立连接：" + socket);
        start();
    }
    public boolean judgeTheUser(String name, String code){
        return name.equals("luoxin") && code.equals("123456");
    }
    public void run(){
        try {
            out.println("Verifying Server!");
            while(readTime < 3){
                String name = in.readLine();
                String code = in.readLine();
                System.out.println("来自客户端" +id+ "："+ "姓名：" + name + ",密码：" + code);
                if(judgeTheUser(name, code)) {
                    out.println("Registration Successful!");
                    break;
                }
                else{
                    readTime++;
                    if(readTime < 3)
                        out.println("PassWord Wrong!");
                    else
                        out.println("Illegal User!");
                }
            }
            Thread.sleep(1000);

        }catch (IOException e){
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("与客户端" + id + "的连接关闭....");
                socket.close();
            }catch (IOException e){
            }
        }
    }
}

public class MultServer {
    public static final int PORT = 8080;
    static ServerSocket s;
    public static void main(String[]args)throws IOException{
        s = new ServerSocket(PORT);
        System.out.println("启动服务器：" + s);
        try {
           while(true) {
                Socket socket = s.accept(); //一直在等待新的客户端与其连接
                try {
                    new ServerWorker(socket);

                }catch (IOException e){
                    System.out.println("与客户端的连接建立失败....");
                    socket.close();
                }
           }
        }finally {
            System.out.println("服务器关闭....");
            s.close();
        }
    }
}
