package university;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int bookNumber;
    private boolean isActivist;
    private String studentAccount;  // Добавлено поле для учебного счёта
    private List<String> events;  // Список мероприятий

    public Student(String name, int bookNumber) {
        this.name = name;
        this.bookNumber = bookNumber;
        this.isActivist = false;
        this.studentAccount = "";  // По умолчанию учебный счёт пуст
        this.events = new ArrayList<>();
    }

    // Устанавливаем, является ли студент активистом
    public void setActivist(boolean isActivist) {
        this.isActivist = isActivist;
    }

    // Устанавливаем номер учебного счёта
    public void setStudentAccount(String studentAccount) {
        this.studentAccount = studentAccount;
    }

    // Получаем учебный счёт
    public String getStudentAccount() {
        return studentAccount;
    }

    // Добавляем мероприятие
    public void addEvent(String event) throws DuplicateEventException {
        if (events.contains(event)) {
            throw new DuplicateEventException("Этот студент уже участвовал в данном мероприятии.");
        }
        events.add(event);
    }

    // Получаем количество мероприятий
    public int getTotalEventsCount() {
        return events.size();
    }

    // Получаем список мероприятий
    public List<String> getEvents() {
        return events;
    }

    // Геттеры и сеттеры для других полей
    public String getName() {
        return name;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public boolean isActivist() {
        return isActivist;
    }
}
