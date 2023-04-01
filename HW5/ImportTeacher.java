import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ImportTeacher implements ImporterTeacher{
    @Override
    public List<Teacher> importerTeacher(String filePath) {
        TeacherStorage<Teacher> teacherStorage = new StoringTeacherInMemory();
        ExporterTeacher exporter = new ExportTeacher();
        ImporterTeacher importer = new ImportTeacher();
        InformationSystem<Person> informationSystem = new InformationSystem<Person>(teacherStorage, importer, exporter);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                Specialization specialization = Specialization.valueOf(parts[1]);
                List<String> students = Arrays.asList(parts[2]);
                teacherStorage.add(new Teacher(name, specialization, students));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (List<Teacher>) teacherStorage;
    }
}