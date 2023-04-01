import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ImportStudent implements ImporterStudent{
    @Override
    public List<Student> importerStudent(String filePath) {
        StudentStorage<Student> studentStorage = new StoringStudentInMemory();
        ExporterStudent exporter = new ExportStudent();
        ImporterStudent importer = new ImportStudent();
        InformationSystem<Person> informationSystem = new InformationSystem<Person>(studentStorage, importer, exporter);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                Specialization specialization = Specialization.valueOf(parts[1]);
                int courseOfStudy = Integer.parseInt(parts[2]);
                studentStorage.add(new Student(name, specialization, courseOfStudy));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (List<Student>) studentStorage;
    }
}