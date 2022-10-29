//客户端线程的界面

package mult;
import javax.swing.*;
import java.awt.event.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;


public class ClientWindow extends JFrame{
    private JButton button=new JButton("登录");
    private JLabel name=new JLabel("姓名：");
    private JLabel password=new JLabel("密码：");
    public JTextField namef=new JTextField("",1);
    public JTextField passf=new JTextField("",1);
    Client client;
    public ClientWindow(InetAddress addr){
        client = new Client(addr);
        setTitle(client.MyId() + "号客户端");
        setLayout(null);
        setSize(300,200);
        setLocation(400,200);
        button.setLocation(100,100);
        button.setSize(100,20);
        name.setBounds(20,20,100,20);
        namef.setBounds(140,20, 100,20);
        password.setBounds(20,60,100,20);
        passf.setBounds(140,60,100,20);
        add(button);
        add(name);
        add(namef);
        add(password);
        add(passf);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.out.println(namef.getText());
                client.out.println(passf.getText());
            }
        });
        //要设置，关闭窗口的时候，socket也关闭
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    client.state = "exit";
                    client.socket.close();
                }catch (IOException E){
                }
            }
            });
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        client.Windows = this;//将客户端后端与窗口相连，使得可以在后端操作关闭窗口
        // 如果最开始，服务器给客户端线程发送的不是“Verifying User!",则直接关闭窗口
        // 关闭socket的一切行为交给client.java
        JOptionPane.showConfirmDialog(null,client.state,"来自服务器的消息",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        if(client.state.equals("Server Wrong!"))
            this.dispose();
    }
}
