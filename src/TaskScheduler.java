import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskScheduler<T extends Task> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private TaskStorage<T> taskStorage;
    private Importer importer;
    private Exporter exporter;

    public TaskScheduler(TaskStorage<T> tTaskStorage, Importer importer, Exporter exporter) {
        this.taskStorage = tTaskStorage;
        this.importer = importer;
        this.exporter = exporter;
    }

    public void addTask(int id, String authorName, Priority priority, LocalDateTime creationDateTime, LocalDateTime deadLineDateTime, String description) {
        T task = (T) new Task(id, authorName, priority, creationDateTime, deadLineDateTime, description);
    }

    public T getTaskById(int id) {
        return taskStorage.getById(id);
    }

    public List<T> getAllTask() {
        return taskStorage.getAll();
    }

    public void exportTasks(String filePath) {
        List<T> tasks = taskStorage.getAll();
        exporter.export(tasks, filePath);
    }

    public TaskScheduler<Task> importTasks(String filePath) {
        return importer.importer(filePath);
    }
}