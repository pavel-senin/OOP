import java.util.ArrayList;
import java.util.List;

public class StoringTeacherInMemory implements TeacherStorage {
    List<Teacher> teachers = new ArrayList<>();

    @Override
    public void add(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public Teacher getByName(String name) {
        for (Teacher teacher : teachers) {
            if (teacher.getName().equals(name)) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public Teacher getTeacherBySpecialization(Specialization specialization) {
        for (Teacher teacher : teachers) {
            if (teacher.getSpecialization().equals(specialization)) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public List<Student> getStudentByTeacher(String teacherName) {
        return null;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teachers;
    }

}
