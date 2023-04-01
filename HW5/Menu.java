import TaskScheduler.Priority;
import TaskScheduler.Task;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static void menu() {
        List<String> student = new ArrayList<>(); // Лист должен формироваться отдельно

        StoringTeacherInMemory storingTeacherInMemory = new StoringTeacherInMemory();
        StoringStudentInMemory storingStudentInMemory = new StoringStudentInMemory();

        InformationSystem<Teacher> teacherInformationSystem = new InformationSystem<>(
                new StoringTeacherInMemory(), new ImportTeacher(),
                new ExportTeacher());

        InformationSystem<Student> studentInformationSystem = new InformationSystem<>(
                new StoringStudentInMemory(), new ImportStudent(),
                new ExportStudent());

        System.out.println("Выберите действие :\n" +
                "1. Добавить студента.\n" +
                "2. Добавить преподавателя.\n" +
                "3. Найти преподавателя по предмету.\n" +
                "4. Найти преподавателя по имени.\n" +
                "5. Найти студента по имени.\n" +
                "6. Найти курс на котором учится студент.\n" +
                "7. Экспортировать данные преподавателей.\n" +
                "8. Экспортировать данные студентов\n" +
                "9. Импортировать данные преподавателей.\n" +
                "10.Импортировать данные студентов.");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int choice = Integer.parseInt(reader.readLine());
            String name;
            Specialization specialization;
            switch (choice) {
                case 1:
                    System.out.println("Введите ФИО студента");
                    name = reader.readLine();
                    System.out.println("Введите специализацию : ");
                    specialization = Specialization.valueOf(reader.readLine().toUpperCase());
                    System.out.println("Введите на каком курсе учится");
                    int courseOfStudy = Integer.parseInt(reader.readLine());
                    studentInformationSystem.addStudent(name, specialization, courseOfStudy);
                    break;
                case 2:
                    System.out.println("Введите ФИО преподавателя");
                    name = reader.readLine();
                    System.out.println("Введите специализацию : ");
                    specialization = Specialization.valueOf(reader.readLine().toUpperCase());
                    System.out.println("Введите на каком курсе учится");
                    teacherInformationSystem.addTeacher(name, specialization, student);
                    break;
                case 3:
                    System.out.println("Введите наименование предмета.");
                    specialization = Specialization.valueOf(reader.readLine().toUpperCase());
                    storingTeacherInMemory.getTeacherBySpecialization(specialization);
                    break;
                case 4:
                    System.out.println("Введите имя преподавателя");
                    name = reader.readLine();
                    storingTeacherInMemory.getByName(name);
                    break;
                case 5:
                    System.out.println("Введите имя студента");
                    name = reader.readLine();
                    storingStudentInMemory.getByName(name);
                    break;
                case 6:
                    System.out.println("Введите курс на котором учится студент.");
                    name = reader.readLine();
                    storingStudentInMemory.getByCourse(name);
                    break;
                case 7 :
                    System.out.println("введите путь к файлу для экспорта преподавателей.");
                    String filePath = reader.readLine();
                    teacherInformationSystem.exportTeacher(filePath);
                    break;
                case 8 :
                    System.out.println("введите путь к файлу для экспорта студентов.");
                    String line = reader.readLine();
                    teacherInformationSystem.exportStudent(line);
                    break;
                case 9 :
                    System.out.println("введите путь к файлу для импорта преподавателей.");
                    String lineT = reader.readLine();
                    teacherInformationSystem.importerTeacher(lineT);
                    break;
                case 10 :
                    System.out.println("введите путь к файлу для импорта студентов.");
                    String lineS = reader.readLine();
                    teacherInformationSystem.importerStudent(lineS);
                    break;
                default:
                    System.out.println("Неверный вариант. Пожалуйста, попробуйте еще раз.");
                    break;
            }
        } catch (IOException e) {
            System.out.println("неверный ввод");
        }
    }
}