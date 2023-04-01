import java.util.List;

public interface TaskStorage <T extends Task>{

    void add(T task);

    T getById(int id);

    List<T> getAll();
}