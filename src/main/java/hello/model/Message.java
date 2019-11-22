package hello.model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    private int id;
    private String message;
    private String timeSent;
    private int authorId;
    private String authorName; // maybe depreciated


    public Message(String authorName , String message) {

        this.message = message;
        this.authorName = authorName;

        SimpleDateFormat formatter = new SimpleDateFormat("YY-MM-DD HH:mm:ss");
        Date date = new Date();

        this.timeSent = formatter.format(date);


    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", timeSent='" + timeSent + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
