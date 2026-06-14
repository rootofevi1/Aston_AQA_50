package lesson_5_students;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        // Student 1
        Student student1 = new Student("Alexander", "A-01", 1);
        student1.addGrade("Math", 5);
        student1.addGrade("Physics", 4);
        student1.addGrade("English", 5);
        students.add(student1);

        // Student 2
        Student student2 = new Student("Andrey", "A-01", 1);
        student2.addGrade("Math", 2);
        student2.addGrade("Physics", 2);
        student2.addGrade("English", 3);
        students.add(student2);

        // Student 3
        Student student3 = new Student("Viktoriya", "B-02", 2);
        student3.addGrade("Math", 4);
        student3.addGrade("Physics", 4);
        student3.addGrade("English", 3);
        students.add(student3);

        // Student 4
        Student student4 = new Student("Diana", "B-02", 2);
        student4.addGrade("Math", 2);
        student4.addGrade("Physics", 2);
        student4.addGrade("English", 2);
        students.add(student4);

        // Student 5
        Student student5 = new Student("Anna", "A-01", 1);
        student5.addGrade("Math", 5);
        student5.addGrade("Physics", 5);
        student5.addGrade("English", 4);
        students.add(student5);

        System.out.println("=== Initial student list ===");
        for (Student s : students) {
            System.out.printf("%s (Course %d, Average: %.2f)%n",
                    s.getName(), s.getCourse(), s.getAverageGrade());
        }

        removeFailingStudents(students);

        System.out.println("\n=== After removing students with average < 3 ===");
        for (Student s : students) {
            System.out.printf("%s (Course %d, Average: %.2f)%n",
                    s.getName(), s.getCourse(), s.getAverageGrade());
        }

        transferSuccessfulStudents(students);

        System.out.println("\n=== After transfer (average >= 3) ===");
        for (Student s : students) {
            System.out.printf("%s (Course %d, Average: %.2f)%n",
                    s.getName(), s.getCourse(), s.getAverageGrade());
        }

        Set<Student> studentSet = new HashSet<>(students);

        System.out.println("\n=== Students on course 2 ===");
        printStudents(studentSet, 2);

        System.out.println("\n=== Students on course 3 ===");
        printStudents(studentSet, 3);
    }

    // Methods
    public static void removeFailingStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
            }
        }
    }

    public static void transferSuccessfulStudents(List<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
