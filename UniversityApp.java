package university;

import java.util.List;
import java.util.Scanner;

public class UniversityApp {
    private static Group group = new Group();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Система управления университетом ===");
            System.out.println("1. Добавить студента");
            System.out.println("2. Просмотреть всех студентов");
            System.out.println("3. Сделать студента активистом");
            System.out.println("4. Добавить мероприятие студенту");
            System.out.println("5. Установить учебный счёт студенту");
            System.out.println("6. Выйти");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // чтобы не было проблем с переходом на новую строку

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    makeActivist(scanner);
                    break;
                case 4:
                    addEventToStudent(scanner);
                    break;
                case 5:
                    setStudentAccount(scanner);
                    break;
                case 6:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Введите имя студента: ");
        String name = scanner.nextLine();
        System.out.print("Введите номер зачетной книжки: ");
        int bookNumber = scanner.nextInt();
        scanner.nextLine(); // для перехода на новую строку

        Student student = new Student(name, bookNumber);
        group.addStudent(student);

        System.out.println("Студент добавлен: " + student.getName());
    }

    private static void viewAllStudents() {
        List<Student> students = group.getStudents();
        if (students.isEmpty()) {
            System.out.println("Нет студентов в базе.");
        } else {
            for (Student student : students) {
                System.out.println("Имя: " + student.getName());
                System.out.println("Номер зачетной книжки: " + student.getBookNumber());
                System.out.println("Активист: " + (student.isActivist() ? "Да" : "Нет"));
                System.out.println("Учебный счёт: " + student.getStudentAccount());
                System.out.println("Мероприятия: " + student.getEvents());
                System.out.println("Количество мероприятий: " + student.getTotalEventsCount());
                System.out.println();
            }
        }
    }

    private static void makeActivist(Scanner scanner) {
        System.out.print("Введите номер зачетной книжки студента, чтобы сделать его активистом: ");
        int bookNumber = scanner.nextInt();
        scanner.nextLine(); // для перехода на новую строку

        Student student = group.findStudentByBookNumber(bookNumber);
        if (student != null) {
            student.setActivist(true);
            System.out.println("Студент " + student.getName() + " теперь активист.");
        } else {
            System.out.println("Студент с таким номером зачетной книжки не найден.");
        }
    }

    private static void addEventToStudent(Scanner scanner) {
        System.out.print("Введите номер зачетной книжки студента: ");
        int bookNumber = scanner.nextInt();
        scanner.nextLine(); // для перехода на новую строку

        System.out.print("Введите название мероприятия: ");
        String event = scanner.nextLine();

        Student student = group.findStudentByBookNumber(bookNumber);
        if (student != null) {
            try {
                student.addEvent(event);
                System.out.println("Мероприятие добавлено для студента " + student.getName());
            } catch (DuplicateEventException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Студент с таким номером зачетной книжки не найден.");
        }
    }

    private static void setStudentAccount(Scanner scanner) {
        System.out.print("Введите номер зачетной книжки студента: ");
        int bookNumber = scanner.nextInt();
        scanner.nextLine(); // для перехода на новую строку

        System.out.print("Введите учебный счёт для студента: ");
        String studentAccount = scanner.nextLine();

        Student student = group.findStudentByBookNumber(bookNumber);
        if (student != null) {
            student.setStudentAccount(studentAccount);
            System.out.println("Учебный счёт установлен для студента " + student.getName());
        } else {
            System.out.println("Студент с таким номером зачетной книжки не найден.");
        }
    }
}
