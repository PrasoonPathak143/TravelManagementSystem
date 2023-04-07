package codewithhimanshu;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{

    JProgressBar p;
    Thread t;
    String username;

    public void run(){
        try{
            for(int i = 1; i <= 101 ; i++){
                int m = p.getMaximum();//100
                int n = p.getValue();// let assume n =23
                if (n < m){//23<100
                    p.setValue(p.getValue() + 1);//24
                }else{
                    i = 101;
                    setVisible(false);
                    new Dashboard(username).setVisible(true);
                }
                Thread.sleep(30);
            }
        }
        catch (Exception ignored){
        }
    }
    //constructor
    public Loading(String user) {
        String  username = user;

        setBounds(500,200,600,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        t = new Thread(this);
        JLabel l1= new JLabel("Travel And Tourism Application");
        l1.setBounds(40,10,500,30);
        l1.setFont(new Font("Raleway", Font.BOLD,30));
        l1.setForeground(Color.BLUE);
        l1.setBorder(BorderFactory.createEmptyBorder());
        add(l1);

        p = new JProgressBar();
        p.setStringPainted(true);
        p.setBounds(130,80,300,25);
        add(p);

        JLabel l2 = new JLabel("please wait...");
        l2.setBounds(225,120,150,30);
        l2.setFont(new Font("Tahoma", Font.CENTER_BASELINE,15));
        l2.setForeground(Color.red);
        add(l2);

        JLabel l3 = new JLabel("Welcome"+ " " + username );
        l3.setBounds(50,200,200,30);
        l3.setFont(new Font("Tahoma", Font.CENTER_BASELINE,15));
        l3.setForeground(Color.red);
        add(l3);

        t.start();
    }
    public static void main(String[] args){

        new Loading("").setVisible(true);
    }
}
