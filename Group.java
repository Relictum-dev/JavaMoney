package university;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Student> students;

    public Group() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student findStudentByBookNumber(int bookNumber) {
        for (Student student : students) {
            if (student.getBookNumber() == bookNumber) {
                return student;
            }
        }
        return null;
    }
}
