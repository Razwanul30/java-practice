import java.util.*;

class Student {
    int roll;
    String name;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name); // 
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(3, "Rahim"));
        students.add(new Student(1, "Abir"));

        // Comparator given to sort by name
        Collections.sort(students, new NameComparator());
        for (Student s : students) {
            System.out.println(s.roll + " " + s.name);
        }

        // (Modern Java8+) sort by roll number in descending order
        students.sort((s1, s2) -> s2.roll - s1.roll);
        for (Student s : students) {
            System.out.println(s.roll + " " + s.name);
        }
    }
}