import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection = null;
    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/tests",
                        "gabriel",
                        "123654"
                );
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }
        return connection;
    }
}
