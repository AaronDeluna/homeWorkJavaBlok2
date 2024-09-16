package homework3.ex5;

import java.time.LocalDateTime;

public class Review {
    private int id;
    private String text;
    private int likesCount;
    private LocalDateTime date;

    public Review(int id, String text, int likesCount, LocalDateTime date) {
        this.id = id;
        this.text = text;
        this.likesCount = likesCount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", likesCount=" + likesCount +
                ", date=" + date +
                '}';
    }
}
