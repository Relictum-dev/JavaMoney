package university;

import java.util.Date;

public class Olympiad extends Event {
    private int place; // Место на олимпиаде (0 - не занял призового места)

    public Olympiad(String name, Date date, String description, int place) {
        super(name, date, description);
        this.place = place;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String eventDetails() {
        return getName() + " (Место: " + (place > 0 ? place : "не призовое") + ")";
    }
}
