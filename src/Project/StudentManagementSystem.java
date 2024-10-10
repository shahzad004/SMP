package Project;

import Project.StudentMS;

import java.util.Scanner;

// Main class
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EnrollmentManagement enrollmentManagement = new EnrollmentManagement();

                /*     // Sample data
        enrollmentManagement.addStudent(new Graduate(1, "Alice", "alice@example.com", "1234567890"));
        enrollmentManagement.addStudent(new Undergraduate(2, "Bob", "bob@example.com", "0987654321"));

        enrollmentManagement.addCourse(new MandatoryCourse(101, "Mathematics", 3));
        enrollmentManagement.addCourse(new ElectiveCourse(102, "Art History", 2));
                */

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Print All Students");
            System.out.println("5. Print All Graduate Students");
            System.out.println("6. Print All Undergraduate Students");
            System.out.println("7. Print All Courses");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Add Student section
                System.out.print("Enter Student ID: ");
                int studentId = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Email: ");
                String email = scanner.nextLine();

                System.out.print("Enter Phone Number: ");
                String phoneNumber = scanner.nextLine();

                System.out.print("Is this student a graduate? (true/false): ");
                boolean isGraduate = scanner.nextBoolean();

                enrollmentManagement.addStudent(studentId, name, email, phoneNumber, isGraduate);
                System.out.println("Student added successfully!");

            } else if (choice == 2) {
                // Add Course section
                System.out.print("Enter Course ID: ");
                int courseId = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter Course Name: ");
                String courseName = scanner.nextLine();

                System.out.print("Enter Credits: ");
                int credits = scanner.nextInt();

                System.out.print("Is this course mandatory? (true/false): ");
                boolean isMandatory = scanner.nextBoolean();

                enrollmentManagement.addCourse(courseId, courseName, credits, isMandatory);
                System.out.println("Course added successfully!");

            }

             else if (choice == 3) {
                System.out.print("Enter Student ID: ");
                int studentId = scanner.nextInt();
                System.out.print("Enter Course ID: ");
                int courseId = scanner.nextInt();
                enrollmentManagement.enrollStudentInCourse(studentId, courseId);
            } else if (choice == 4) {
                enrollmentManagement.printAllStudents();
            } else if (choice == 5) {
                enrollmentManagement.printAllGraduateStudents();
            } else if (choice == 6) {
                enrollmentManagement.printAllUndergraduateStudents();
            } else if (choice == 7) {
                enrollmentManagement.printAllCourses();
            } else if (choice == 8) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }}