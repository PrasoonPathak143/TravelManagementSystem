package codewithhimanshu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPass extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    ForgetPass(){
       setBounds(550,250,850,400);//location on jframe
       getContentPane().setBackground(Color.white);//backgound color of jframe
       setLayout(null);//to remove by default border layout

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        JLabel l6= new JLabel(i1);
        l6.setBounds(580,70,100,100);
        add(l6);

        JPanel p=new JPanel();
        p.setLayout(null);//to set layout null
        p.setBounds(30,30,500,300);//set the location
        add(p);//to add panel
        JLabel l1=new JLabel("Username");
        l1.setBounds(40,40,100,25);
        p.add(l1);//to add label

        t1=new JTextField();
        t1.setBounds(220,40,150,25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p.add(t1);//to add textfield

        b1=new JButton("Search");
        b1.setBackground(Color.gray);
        b1.setForeground(Color.blue);
        b1.setBounds(380,40,100,25);
        b1.addActionListener(this);
        p.add(b1);

        JLabel l2=new JLabel("Name");
        l2.setBounds(40,80,100,25);
        p.add(l2);

        t2=new JTextField();
        t2.setBounds(220,80,150,25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p.add(t2 );

        JLabel l3=new JLabel("Your Security Question");
        l3.setBounds(40,120,150,25);
        p.add(l3);

        t3=new JTextField();
        t3.setBounds(220,120,150,25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p.add(t3);

        JLabel l4=new JLabel("Answer");
        l4.setBounds(40,160,100,25);
        p.add(l4);

        t4=new JTextField();
        t4.setBounds(220,160,150,25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p.add(t4);

        b2=new JButton("Retrieve");
        b2.setBackground(Color.gray);
        b2.setForeground(Color.yellow);
        b2.setBounds(380,160,100,25);
        b2.addActionListener(this);
        p.add(b2);

        JLabel l5=new JLabel("Password");
        l5.setBounds(40,200,100,25);
        p.add(l5);

        t5=new JTextField();
        t5.setBounds(220,200,150,25);
        t5.setBorder(BorderFactory.createEmptyBorder());
        p.add(t5);

        b3=new JButton("Back");
        b3.setBackground(Color.gray);
        b3.setForeground(Color.yellow);
        b3.setBounds(200,250,100,25);
        b3.addActionListener(this);
        p.add(b3);
    }

    public static void main(String[] args){

     new ForgetPass().setVisible(true);
    }

 @Override
 public void actionPerformed(ActionEvent ae) {
     Conn c=new Conn();
  if(ae.getSource()==b1){
   try{
   String sql="select * from account where username = '"+t1.getText()+"'";
   ResultSet rs= c.s.executeQuery(sql);
   while(rs.next()){
    t2.setText(rs.getString("name"));
    t3.setText(rs.getString("security"));
   }
   }catch(Exception e){}
  }
  else if(ae.getSource()==b2){
   try{
    String sql="select * from account where answer = '"+t4.getText()+"'AND username='"+t1.getText()+"'";
    ResultSet rs= c.s.executeQuery(sql);
    while(rs.next()){
     t5.setText(rs.getString("password"));
    }
   }catch(Exception e){}

  }
  else if(ae.getSource()==b3){
   this.setVisible(false);
   new Login().setVisible(true);
  }
 }
}
