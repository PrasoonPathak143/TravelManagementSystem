package codewithhimanshu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {
    JButton b1,b2;
    JTextField t1,t2,t3,t4;
    Choice c1;
    public SignUp() {

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(330,200,900,350);

        JPanel p1=new JPanel();
        p1.setBackground(new Color(131,177,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        JLabel l1=new JLabel("Username");
        l1.setBounds(30,10,150,50);
        l1.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        p1.add(l1);

         t1=new JTextField();
        t1.setBounds(200,23,200,25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);

        JLabel l2=new JLabel("Name");
        l2.setBounds(30,50,150,50);
        l2.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        p1.add(l2);

         t2=new JTextField();
        t2.setBounds(200,62,200,25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);

        JLabel l3=new JLabel("Password");
        l3.setBounds(30,90,150,50);
        l3.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        p1.add(l3);

         t3=new JPasswordField();
        t3.setBounds(200,102,200,25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);

        JLabel l4=new JLabel("Security Question");
        l4.setBounds(30,130,160,50);
        l4.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        p1.add(l4);

         c1=new Choice();
        c1.add("Your first School name");
        c1.add("your favorite book");
        c1.add("Your favorite Sports");
        c1.add("your nickName");
        c1.setBounds(200,145,200,50);
        p1.add(c1);

        JLabel l5=new JLabel("Answer");
        l5.setBounds(30,169,160,50);
        l5.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        p1.add(l5);

         t4 =new JTextField();
        t4.setBounds(200,183,200,25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(200,180,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l6=new JLabel(i3);
        l6.setBounds(600,60,200,200);
        add(l6);

         b1=new JButton("Create");
        b1.setBounds(60,250,90,25);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        p1.add(b1);

         b2=new JButton("Back");
        b2.setBounds(280,250,90,25);
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.addActionListener(this);
        p1.add(b2);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent hk) {
        if(hk.getSource()==b1){
           String username=t1.getText();// "",''
           String name=t2.getText();
           String password=t3.getText();
           String security=c1.getSelectedItem();
           String answer=t4.getText();
           String query="insert into account values('"+username+"','"+name+"','"+password+"','"+security+"','"+answer+"')";
           try{
               Conn c=new Conn();
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Account Added Sucessfully");
               this.setVisible(false);
               new Login().setVisible(true);
           }catch(Exception e){

           }
        }
        else if(hk.getSource()==b2){
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new SignUp();
    }



}