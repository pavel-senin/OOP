import java.util.List;

public class Student extends Person {
    private int courseOfStudy;

    public Student(String name, Specialization specialization, int courseOfStudy) {
        super(name, specialization);
        this.courseOfStudy = courseOfStudy;
    }

    public Student(String name, int courseOfStudy, Specialization specialization) {
        super(name, specialization);
        this.courseOfStudy = courseOfStudy;
    }

    public int getCourseOfStudy() {
        return courseOfStudy;
    }

    public void setCourseOfStudy(int courseOfStudy) {
        this.courseOfStudy = courseOfStudy;
    }

}