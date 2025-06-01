package project1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choise;

        do {

            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choise = sc.nextInt();
            sc.nextLine();

            switch (choise) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    updateStudent();
                    break;

                case 5:
                    System.out.println("Existing .....");
                    break;

                default:
                    System.out.println("default ");
            }

        } while (choise != 5);
    }

    static void addStudent() {
        System.out.print("Enter total number of students you want to insert: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume the leftover newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student details (id name age): ");
            // String line = sc.nextLine(); // read entire line

            // String[] parts = line.split(" "); // split by spaces
            // int id = Integer.parseInt(parts[0]);
            // String name = parts[1];
            // int age = Integer.parseInt(parts[2]);
            int id = sc.nextInt();
            String name = sc.next();
            int age = sc.nextInt();
            students.add(new Student(id, name, age));
            System.out.println("✅ Student " + (i + 1) + " added.");
        }
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    static void deleteStudent() {
        System.out.println("Enter student id to delete :");
        int id = sc.nextInt();

        boolean removed = students.removeIf(s -> s.id == id);

        if (removed) {
            System.out.println("✅ Student deleted successfully.");
        } else {
            System.out.println("❌ Student with ID " + id + " not found.");
        }

    }

    static void updateStudent() {
        System.out.println("Enter student id to update :");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter new name: ");
                s.name = sc.next();

                System.out.print("Enter new age: ");
                s.age = sc.nextInt();

                sc.nextLine();

                System.out.println("✅ Student updated successfully.");
                return;
            }
        }
    }

}
