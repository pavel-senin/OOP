import java.util.ArrayList;
import java.util.List;

public class StoringStudentInMemory implements StudentStorage {

    List<Student> students = new ArrayList<>();

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public Student getByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public int getByCourse(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student.getCourseOfStudy();
            }
        }
        return 0;
    }

    @Override
    public List<Student> getAllStudent() {
        return students;
    }
}