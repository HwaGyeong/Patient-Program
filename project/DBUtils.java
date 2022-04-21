
package project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
     public static Connection ConnectToMySQLDB(String dbURL,String UserName, String Password){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(dbURL,UserName,Password);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}
