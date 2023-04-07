package codewithhimanshu;
import java.sql.*;

public class Conn {
    Connection h;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            h=DriverManager.getConnection("jdbc:mysql://localhost:3306/tour","root","1234");//object of connection interface
            s=h.createStatement();
        }catch(Exception e){

        }
    }
}
