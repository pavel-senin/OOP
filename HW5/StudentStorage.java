import java.util.List;

public interface StudentStorage <T extends Student>{
    void add(T student);
    T getByName(String name);
    int getByCourse(String name);
    List<T> getAllStudent();
}