import java.util.List;

public interface ExporterPerson {

    void exporterTeacher(List<Teacher> teachers, String filePath);
    void exporterStudent(List<Student> students, String filePath);
}