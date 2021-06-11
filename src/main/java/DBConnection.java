import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection singletonConn = null;
    public static Connection getConnection() {
        if (singletonConn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                singletonConn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/tests",
                        "gabriel",
                        "123654"
                );
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return singletonConn;
    }
}
