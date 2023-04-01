import java.util.List;

public class Teacher extends Person{
    private List<String> students;

    public Teacher(String name, Specialization specialization) {
        super(name, specialization);
    }

    public Teacher(String name, Specialization specialization, List<String> students) {
        super(name, specialization);
        this.students = students;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }
}