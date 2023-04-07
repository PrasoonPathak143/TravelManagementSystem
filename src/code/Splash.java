package codewithhimanshu;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread t1;
    Splash(){
        //size and location
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2=i1.getImage().getScaledInstance(1600, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel L1= new JLabel(i3);

        L1.setBounds(0,0,1366,768);
        add(L1);
        setLayout(null);
        t1= new Thread(this);
        t1.start();
    }
    public static void main(String[] args) {

        //front page
        Splash hk=new Splash();
        hk.setVisible(true);
        int x = 1;
        for(int i=1;i<700;i++,i+=6,x+=7) {
            hk.setLocation(750-(x+i)/2, 400-(i/2));
            hk.setSize(x+i,i);
            try{
                Thread.sleep(10);
            }catch(Exception e){}
        }
        hk.setVisible(true);
    }
    public void run(){
        try{
            Thread.sleep(7000);
            this.setVisible(false);
            new Login().setVisible(true);

        }catch(Exception e){}
    }
}