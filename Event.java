package university;

import java.util.Date;

public abstract class Event {
    private String name;   // Название мероприятия
    private Date date;     // Дата проведения
    private String description; // Описание мероприятия

    public Event(String name, Date date, String description) {
        this.name = name;
        this.date = date;
        this.description = description;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract String eventDetails();
}
