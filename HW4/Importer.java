import java.util.List;

public interface Importer<T extends Task>{

    TaskScheduler<T> importer(String filePath);
}
