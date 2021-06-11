package models;

public class NullMessage extends AbstractMessage {
    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public int getMessageId() {
        return -1;
    }

    @Override
    public void setMessageId(int messageId) {}

    @Override
    public String getMessage() {
        return "Not Available";
    }

    @Override
    public void setMessage(String message) {}

    @Override
    public String getMessageAuthor() {
        return "Not Available";
    }

    @Override
    public void setMessageAuthor(String messageAuthor) {}

    @Override
    public String getMessageDate() {
        return "Not Available";
    }

    @Override
    public void setMessageDate(String messageDate) {}
}
