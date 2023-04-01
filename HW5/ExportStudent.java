import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportStudent implements ExporterStudent{

    @Override
    public void exporterStudent(List<Student> students, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))){
            for (Student student : students) {
                writer.printf("%s,%d,%s", student.getName(), student.getCourseOfStudy(), student.getSpecialization());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
