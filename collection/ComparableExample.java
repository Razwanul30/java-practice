import java.util.*;

class Student implements Comparable<Student> {
    int roll;
    String name;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        return this.roll - other.roll; 
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(3, "Rahim"));
        students.add(new Student(1, "Karim"));

        Collections.sort(students); 
        for (Student student : students) {
            System.out.println("Roll: " + student.roll + ", Name: " + student.name);
        }
    }
}