package university;

import java.util.Date;

public class Competition extends Event {
    private String projectTitle; // Название проекта на конкурсе
    private double prizeAmount;  // Сумма приза (если есть)

    public Competition(String name, Date date, String description, String projectTitle, double prizeAmount) {
        super(name, date, description);
        this.projectTitle = projectTitle;
        this.prizeAmount = prizeAmount;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public double getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(double prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    @Override
    public String eventDetails() {
        return getName() + " (Проект: " + projectTitle + ", Приз: " + (prizeAmount > 0 ? prizeAmount : "Нет") + ")";
    }
}
