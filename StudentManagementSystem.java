import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}

public class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, int grade) {
        students.add(new Student(name, grade));
    }

    public void removeStudent(String name) {
        Student foundStudent = null;
        for (Student student : students) {
            if (student.getName().equals(name)) {
                foundStudent = student;
                break;
            }
        }
        if (foundStudent != null) {
            students.remove(foundStudent);
            System.out.println("Student removed: " + name);
        } else {
            System.out.println("Student not found: " + name);
        }
    }

    public void searchStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                System.out.println("Grade for " + name + ": " + student.getGrade());
                return;
            }
        }
        System.out.println("Student not found: " + name);
    }

    public void sortByName() {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }

    public void sortByGrade() {
        Collections.sort(students, Comparator.comparing(Student::getGrade).reversed());
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        String choice;
        
        do {
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Search student");
            System.out.println("4. Sort by name");
            System.out.println("5. Sort by grade");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student grade: ");
                    int grade = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    system.addStudent(name, grade);
                    System.out.println("Student added: " + name);
                    break;
                case "2":
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();
                    system.removeStudent(name);
                    break;
                case "3":
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();
                    system.searchStudent(name);
                    break;
                case "4":
                    system.sortByName();
                    System.out.println("Students sorted by name.");
                    break;
                case "5":
                    system.sortByGrade();
                    System.out.println("Students sorted by grade.");
                    break;
                case "6":
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (!choice.equals("6"));
    }
}