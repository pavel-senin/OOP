import java.util.List;
public interface Exporter<T extends Task> {

    void export(List<T> task, String FilePath);
}
