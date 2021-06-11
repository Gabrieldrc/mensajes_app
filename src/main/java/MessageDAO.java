import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {
    public static void createMessageDB(Message message) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps;
        String query = "INSERT INTO message (message, message_author)" +
                "VALUES (?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, message.getMessage());
            ps.setString(2, message.getMessageAuthor());
            ps.executeUpdate();
            System.out.println("Message created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void readMessageDB() {

    }
    public static void deleteMessageDB(int messageId) {

    }
    public static void updateMessageDB(Message message) {

    }
}
