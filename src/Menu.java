import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Menu {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static void menu() {

        TaskScheduler<Task> taskScheduler = new TaskScheduler<Task>(new StoringTaskInMemory(), new ImportTask(), new ExportTask());

        System.out.println("Выберите действие :\n" +
                "1. Добавить задачу.\n" +
                "2. Экспортировать задачу.\n" +
                "3. Импортировать задачу.\n" +
                "4. Посмотреть задачи\n" +
                "5. Найти задачу по id\n");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    System.out.println("Введите id задачи");
                    int id = Integer.parseInt(reader.readLine());
                    System.out.println("Введите ФИО автора задачи");
                    String authorName = reader.readLine();
                    System.out.println("Введите приоритет задачи (LOW, MEDIUM, HIGH): ");
                    Priority priority = Priority.valueOf(reader.readLine().toUpperCase());
                    System.out.println("Введите дату и время постановки задачи в формате \"dd.MM.yyyy HH:mm\"");
                    LocalDateTime createDateTime = LocalDateTime.parse(reader.readLine(), DATE_FORMATTER);
                    System.out.println("Введите дату и время дедлайна задачи");
                    LocalDateTime deadlineDateTime = LocalDateTime.parse(reader.readLine(), DATE_FORMATTER);
                    System.out.println("Введите описание задачи");
                    String description = reader.readLine();
                    taskScheduler.addTask(id, authorName, priority, createDateTime, deadlineDateTime, description);
                    break;
                case 2:
                    System.out.println("введите путь к файлу для экспорта. Файл должен быть в формате csv/jsom/xml");
                    String filePath = reader.readLine();
                    taskScheduler.exportTasks(filePath);
                    break;
                case 3:
                    System.out.println("введите путь к файлу для импорта. Файл в формате csv/jsom/xml");
                    String line = reader.readLine();
                    taskScheduler = taskScheduler.importTasks(line);
                    break;
                case 4:
                    List<Task> tasks = taskScheduler.getAllTask();
                    if (tasks.isEmpty()) {
                        System.out.println("нет задач.");
                    } else {
                        for (Task task : tasks) {
                            System.out.println(task);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Введите ID задачи: ");
                    int taskId = Integer.parseInt(reader.readLine());
                    Task taskById = taskScheduler.getTaskById(taskId);
                    if (taskById == null) {
                        System.out.println("Задача с таким ID не найдена.");
                    } else {
                        System.out.println(taskById);
                    }
                    break;
                default:
                    System.out.println("Неверный вариант. Пожалуйста, попробуйте еще раз.");
                    break;
            }
        } catch (IOException e) {
            System.out.println("неверный ввод");
            ;
        }
    }
}
