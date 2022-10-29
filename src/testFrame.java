import mult.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class messageFromServer extends JFrame{
    // private JButton exitButton = new JButton("确定");
    private JLabel mesg = new JLabel("",JLabel.CENTER);
    public messageFromServer(String str){
        setTitle("");
        setSize(200,200);
        setLocation(800,200);
        mesg.setText(str);
        mesg.setBounds(100,150,200,20);
        add(mesg);
    }
}
public class testFrame extends JFrame{
    private JButton button=new JButton("登录");
    private JLabel name=new JLabel("姓名：");
    private JLabel password=new JLabel("密码：");
    public JTextField namef=new JTextField("",1);
    public JTextField passf=new JTextField("",1);
    public testFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(300,200);
        setLocation(400,200);
        button.setLocation(100,100);
        button.setSize(100,20);
        name.setBounds(20,20,100,20);
       passf.setBounds(140,60,100,20);
        namef.setBounds(140,20, 100,20);
        password.setBounds(20,60,100,20);
       // passf.setBounds(140,60,100,20);
        add(button);
        add(name);
        add(namef);
        add(password);
        add(passf);
        setVisible(true);
    }
    public static void main(String[]args){
        testFrame f = new testFrame();
        f.setVisible(true);
    }
}
