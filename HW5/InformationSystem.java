import java.util.List;

public class InformationSystem <T extends Person>{
    private TeacherStorage teacherStorage;
    private  StudentStorage studentStorage;
    private ImporterStudent importerStudent;
    private ImporterTeacher importerTeacher;
    private ExporterStudent exporterStudent;
    private ExporterTeacher exporterTeacher;

    public InformationSystem(TeacherStorage teacherStorage, ImporterTeacher importerTeacher, ExporterTeacher exporter) {
        this.teacherStorage = teacherStorage;
        this.importerTeacher = importerTeacher;
        this.exporterTeacher = exporter;
    }

    public InformationSystem(StudentStorage studentStorage, ImporterStudent importerStudent, ExporterStudent exporter) {
        this.studentStorage = studentStorage;
        this.importerStudent = importerStudent;
        this.exporterStudent = exporter;
    }

    List<Teacher> importerTeacher(String filePath){
        return importerTeacher.importerTeacher(filePath);
    }
    List<Student> importerStudent(String filePath) {
        return importerStudent.importerStudent(filePath);
    }

    public void exportTeacher(String filePath) {
        List<Teacher> teachers = teacherStorage.getAllTeacher();
        exporterTeacher.exporterTeacher(teachers ,filePath);
    }

    public void exportStudent(String filePath) {
        List<Student> students = studentStorage.getAllStudent();
        exporterStudent.exporterStudent(students, filePath);
    }

    public void addTeacher(String name, Specialization specialization, List<String> student) {
        Teacher teacher = new Teacher(name, specialization, student);
    }

    public void addStudent(String name, Specialization specialization, int courseOfStudy) {
        Student student = new Student(name, specialization, courseOfStudy);
    }
}