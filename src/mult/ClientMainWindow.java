//客户端主窗口，通过这个窗口创建客户端线程

package mult;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Vector;

public class ClientMainWindow extends JFrame{
    private static InetAddress addr;
    private JButton button = new JButton("创建新的服务窗口");
    public ClientMainWindow()throws IOException{
        addr = InetAddress.getByName(null);
        setTitle("客户端主进程");
        setSize(300,300);
        setLocation(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        button.setLocation(50,100);
        button.setSize(200,40);
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建客户端线程
               new ClientWindow(addr);
            }
        });
    }

    public static void main(String[] args) throws IOException{
        ClientMainWindow mainWindows = new ClientMainWindow();
        mainWindows.setVisible(true);
    }
}
