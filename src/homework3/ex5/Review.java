package homework3.ex5;

import java.time.LocalDateTime;

public class Review implements Comparable<Review> {
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
    public int compareTo(Review other) {
        int likeComparison = Integer.compare(other.getLikesCount(), this.getLikesCount());
        if (likeComparison != 0) {
            return likeComparison;
        }
        int dateComparison = this.getDate().compareTo(other.getDate());
        if (dateComparison != 0) {
            return dateComparison;
        }

        return Integer.compare(this.getId(), other.getId());
    }

    @Override
    public String toString() {
        return "Review{"
                + "id=" + id
                + ", text='" + text + '\''
                + ", likesCount=" + likesCount
                + ", date=" + date + '}';
    }
}
