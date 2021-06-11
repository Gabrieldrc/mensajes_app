import java.util.Scanner;

public class MessageService {
    public static void createMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje:");
        String message = sc.nextLine();
        System.out.println("Tu nombre:");
        String name = sc.nextLine();

        Message record = new Message();
        record.setMessage(message);
        record.setMessageAuthor(name);

        MessageDAO.createMessageDB(record);

    }
    public static void readMessage() {

    }
    public static void deleteMessage() {

    }
    public static void updateMessage() {

    }
}
