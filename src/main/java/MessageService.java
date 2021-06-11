import models.AbstractMessage;
import models.Message;
import models.NullMessage;

import java.util.ArrayList;
import java.util.Iterator;
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

        if (MessageDAO.createMessageDB(record)) {
            System.out.println("Mensaje creado.");
        } else {
            System.out.println("No se puedo crear el mensaje.");
        }

    }
    public static void readMessages() {
        ArrayList<Message> messages = MessageDAO.readMessagesDB();
        if (messages.size() == 0) {
            System.out.println("No hay mensajes");
        } else {
            Iterator<Message> it = messages.iterator();
            while (it.hasNext()) {
                Message message = it.next();
                printAMessage(message);
            }
        }

    }
    public static void deleteMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el ID del mensaje:");
        int messageId = sc.nextInt();
        if (MessageDAO.deleteMessageDB(messageId)) {
            System.out.println("Se elimino el mensaje de id '"+messageId+"'");
        } else {
            System.out.println("No se pudo eliminar el mensaje");
        }
    }
    public static void updateMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el ID del mensaje:");
        int messageId = sc.nextInt();
        AbstractMessage message = MessageDAO.getMessageById(messageId);
        if (message.isNull()) {
            System.out.println("El mensaje no existe");
        } else {
            System.out.println("Mensaje original:");
            System.out.println(message.getMessage());
            System.out.println("Escribe el nuevo mensaje:");
            sc = new Scanner(System.in);
            String newTextMessage = sc.nextLine();
            message.setMessage(newTextMessage);
            System.out.println("1. Save\n2. Cancel");
            int option = sc.nextInt();
            if (option == 1) {
                boolean result = MessageDAO.updateMessageDB((Message) message);
                if (result) {
                    System.out.println("Se actualizo el mensaje");
                }
            } else {
                System.out.println("Proceso cancelado.");
            }
        }
    }
    public static void printAMessage(AbstractMessage message) {
        System.out.println(
                "ID: " + message.getMessageId()
                + "\nMensaje:\n" + message.getMessage()
                + "\nAutor: " + message.getMessageAuthor()
                + "\nFecha: " + message.getMessageDate()
                + "\n"
        );
    }
}
