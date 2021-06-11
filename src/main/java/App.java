import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        try {
            Connection connection = db.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
