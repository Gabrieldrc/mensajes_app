package models;

public abstract class AbstractMessage {
    protected int messageId;
    protected String message;
    protected String messageAuthor;
    protected String messageDate;

    public abstract boolean isNull();
    public abstract int getMessageId();
    public abstract void setMessageId(int messageId);
    public abstract String getMessage();
    public abstract void setMessage(String message);
    public abstract String getMessageAuthor();
    public abstract void setMessageAuthor(String messageAuthor);
    public abstract String getMessageDate();
    public abstract void setMessageDate(String messageDate);
}
