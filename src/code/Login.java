package codewithhimanshu;
import javax.swing.*;  //import javax.swing.border.;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.*;

import java.awt.event.*;
import java.rmi.UnexpectedException;
import java.security.cert.CertificateParsingException;

public class Login extends JFrame implements ActionListener {
    JButton b1,b2,b3;

    JTextField t1;
    JPasswordField t2;
    Login()
    {
//        setSize(400, 400);
//        setLocation(750, 450);

        setLayout(null); // BorderLayout, FlowLayout, GridLayout, Grid
        getContentPane().setBackground(Color.white);
        setBounds( 400, 200, 650, 300);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.getHSBColor(173, 216, 230));
        p1.setBounds(0, 0, 300, 300);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l1 = new JLabel(i3);
        l1.setBounds(50, 80, 200, 200);
        p1.add(l1);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(300, 10, 330, 245);
        add(p2);

        JLabel l2 = new JLabel("User name");
        l2.setBounds(60, 40, 100, 25 );
        l2.setFont(new Font("SAN_SARIF",Font.PLAIN, 20));
        p2.add(l2);

         t1 = new JTextField();
        t1.setBounds(60, 70, 230, 23);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t1);

        JLabel l3 = new JLabel("Password");
        l3.setBounds(60, 100, 100, 25 );
        l3.setFont(new Font("SAN_SARIF",Font.PLAIN, 20));
        p2.add(l3);

         t2 = new JPasswordField();
        t2.setBounds(60, 130, 230, 23);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t2);

         b1 = new JButton("Login");
        b1.setBounds(60, 170, 100, 30);
        b1.setBackground(new Color(133, 193, 233));
        b1.setForeground(Color.white);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        p2.add(b1);

         b2 = new JButton("Signup");
        b2.setBounds(190, 170, 100, 30);
        b2.setBackground(Color.white);
        b2.setForeground(new Color(133, 193, 233));
        b2.setBorder(new LineBorder(new Color(133, 193, 233)));
        b2.addActionListener(this);
        p2.add(b2);

         b3 = new JButton("Forget Password");
        b3.setBounds(80, 210, 100, 27);
        b3.setBackground(Color.white);
        b3.setForeground(new Color(133, 193, 233));
        b3.setBorder(new LineBorder(new Color(133, 193, 233)));
        b3.addActionListener(this);
        p2.add(b3);

        JLabel l4 = new JLabel("Trouble in Login..");
        l4.setForeground(Color.red);
        l4.setBounds(190, 210, 100, 25);
        p2.add(l4);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent hk){
    if(hk.getSource()==b1){
        try{
         String username =t1.getText();
         String password =t2.getText();
         String sql="select * from account where username= '"+username+"' And password ='"+password+"'";
         Conn c=new Conn();
         ResultSet rs=c.s.executeQuery(sql);
         if(rs.next()){
          this.setVisible(false);
          new Loading(username).setVisible(true);
         }
         else{
             JOptionPane.showMessageDialog(null,"Invalid Login");
         }
        }catch(Exception e){

        }

    }
    else if(hk.getSource()==b2){
     new SignUp().setVisible(true);
     this.setVisible(false);
    }
    else if(hk.getSource()==b3){
        this.setVisible(false);
        new ForgetPass().setVisible(true);
        }
    }

    public static void main(String[] args){

        new Login();

    }
}