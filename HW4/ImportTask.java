import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ImportTask implements Importer<Task>{
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public TaskScheduler<Task> importer(String filePath) {
        TaskStorage<Task> taskStorage = new StoringTaskInMemory();
        Exporter exporter = new ExportTask();
        Importer importer = new ImportTask();
        TaskScheduler<Task> taskScheduler = new TaskScheduler<Task>(taskStorage, importer, exporter);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String authorName = parts[1];
                Priority priority = Priority.valueOf(parts[2]);
                LocalDateTime createDateTime = LocalDateTime.parse(parts[3], DATE_FORMATTER);
                LocalDateTime deadlineDateTime = LocalDateTime.parse(parts[4], DATE_FORMATTER);
                String description = parts[5];
                taskScheduler.addTask(id, authorName, priority, createDateTime, deadlineDateTime, description);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return taskScheduler;
    }
}
