package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySql {


    private ConnectionMySql(){}

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        //String url = "jdbc:mysql://127.0.0.1:80/javaEETP";
        String url = "jdbc:mysql://localhost:3306/javaEETP?user=root&password=";
//        DriverManager.getConnection(url);
        return DriverManager.getConnection(url);

    }
}
