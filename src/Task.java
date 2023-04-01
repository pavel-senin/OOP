import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyy0y HH:mm");
    private int id;
    private String authorName;
    private Priority priority;
    private LocalDateTime creationDateTime;
    private LocalDateTime deadLineDateTime;
    private String description;

    public Task(int id, String authorName, Priority priority, LocalDateTime creationDateTime, LocalDateTime deadLineDateTime, String description) {
        this.id = id;
        this.authorName = authorName;
        this.priority = priority;
        this.creationDateTime = creationDateTime;
        this.deadLineDateTime = deadLineDateTime;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getDeadLineDateTime() {
        return deadLineDateTime;
    }

    public void setDeadLineDateTime(LocalDateTime deadLineDateTime) {
        this.deadLineDateTime = deadLineDateTime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id - " + id +
                ", дата постановки задачи - " + creationDateTime.format(DATE_FORMATTER) +
                ", дедлайн - " + deadLineDateTime.format(DATE_FORMATTER) +
                ", приоритет - " + priority +
                ", имя автора - '" + authorName + '\'' +
                ", описание - '" + description + '\'' +
                '}';
    }
}