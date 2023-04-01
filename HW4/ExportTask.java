import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExportTask implements Exporter<Task>{
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void export(List<Task> tasks, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))){
            for (Task task : tasks) {
                writer.printf("%d,%s,%s,%s,%s,%s%n", task.getId(), task.getAuthorName(), task.getPriority(), task.getCreationDateTime().format(DATE_FORMATTER),
                        task.getDeadLineDateTime().format(DATE_FORMATTER), task.getDescription());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
