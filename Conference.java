package university;

import java.util.Date;

public class Conference extends Event {
    private String reportTitle; // Название доклада

    public Conference(String name, Date date, String description, String reportTitle) {
        super(name, date, description);
        this.reportTitle = reportTitle;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    @Override
    public String eventDetails() {
        return getName() + " (Доклад: " + reportTitle + ")";
    }
}
