import models.AbstractMessage;
import models.Message;
import models.NullMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDAO {
    public static boolean createMessageDB(Message message) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps;
        String query = "INSERT INTO message (message, message_author)" +
                "VALUES (?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, message.getMessage());
            ps.setString(2, message.getMessageAuthor());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static ArrayList<Message> readMessagesDB() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps;
        ResultSet result;
        String query = "SELECT * FROM message";
        try {
            ps = connection.prepareStatement(query);
            result = ps.executeQuery();
            ArrayList<Message> messages = new ArrayList<>();
            while (result.next()) {
                Message message = new Message(
                        result.getString("message"),
                        result.getString("message_author"),
                        result.getString("message_date")
                );
                message.setMessageId(result.getInt("message_id"));
                messages.add(message);
            }
            return messages;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean deleteMessageDB(int messageId) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps;
        ResultSet result;
        String query = "DELETE FROM message WHERE message_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, messageId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean updateMessageDB(Message message) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps;
        String query = "UPDATE message SET message = ?" +
                "WHERE message_id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, message.getMessage());
            ps.setInt(2, message.getMessageId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static AbstractMessage getMessageById(int messageId) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps;
        ResultSet result;
        String query = "SELECT * FROM message " +
                "WHERE message_id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, messageId);
            result = ps.executeQuery();
            result.next();
            Message message = new Message(
                    result.getString("message"),
                    result.getString("message_author"),
                    result.getString("message_date")
            );
            message.setMessageId(result.getInt("message_id"));
            return message;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new NullMessage();
    }
}
