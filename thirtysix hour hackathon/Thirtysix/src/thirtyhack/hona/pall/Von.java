package thirtyhack.hona.pall;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Von{

    Connection connection;
    Connection connection2;
    Statement statement;
    Statement statement2;
    public Von(){
        try{
            
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/healtcaredata", "root", "asher");
            connection2=DriverManager.getConnection("jdbc:mysql://localhost:3306/conn", "root", "asher");
            statement2= connection.createStatement();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
