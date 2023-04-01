import java.util.List;

public interface TeacherStorage<T extends Teacher>{

    void add(T teacher);
    T getByName(String name);
    T getTeacherBySpecialization(Specialization specialization);
    List<Student> getStudentByTeacher(String teacherName);
    List<T> getAllTeacher();

}