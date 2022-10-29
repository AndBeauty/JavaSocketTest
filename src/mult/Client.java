package mult;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client extends Thread{
    protected Socket socket;
    private BufferedReader in;
    protected PrintWriter out;
    private static int count = 0;
    protected int id = ++count;
    protected String state = "";
    public String message;
    protected ClientWindow Windows;
    public  int MyId(){
        return id;
    }
    public Client(InetAddress addr){
        System.out.println("创建客户端：" + id);
        try {
            socket = new Socket(addr, MultServer.PORT);
            System.out.println("Socket = " + socket);
        }catch (IOException e){}
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            start();
        }catch (IOException e){
            try {
                System.out.println("关闭客户端" + id);
                state = "exit";
                socket.close();
            }catch (IOException e2){}
        }
    }

    public void run(){
        out.println(id);
        try {
            String str = in.readLine();//读取服务器发送过来的消息
            if(!str.equals("Verifying Server!")){
                state = "Server Wrong!";
            }
            else{
                state = "Server is Working!";
                do{
                    message = in.readLine();
                    if(message.equals("PassWord Wrong!"))
                        JOptionPane.showConfirmDialog(null,message,"来自服务器的消息",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
                    System.out.println("来自服务器：" + message);
                }while(message.equals("PassWord Wrong!"));
                if(message.equals("Illegal User!"))
                    JOptionPane.showConfirmDialog(null,message,"来自服务器的消息",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showConfirmDialog(null,message,"来自服务器的消息",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                Windows.dispose();
            }
        }catch (IOException e){}
        finally {
            try {
                System.out.println("关闭客户端" + id);
                state = "exit";
                socket.close();
            }catch (IOException E){}
        }
    }
}