package Project;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base Student class
abstract class StudentMS {
    private int studentId;
    private String name;
    private String email;
    private String phoneNumber;
    private List<CourseList> enrolledCourses;

    public StudentMS(int studentId, String name, String email, String phoneNumber) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.enrolledCourses = new ArrayList<>();
    }

    public void enrollCourse(CourseList course) {
        enrolledCourses.add(course);
    }

    public void printInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Enrolled Courses: " + enrolledCourses);
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public List<CourseList> getEnrolledCourses() {
        return enrolledCourses;
    }
}

// Graduate class
class Graduate extends StudentMS {
    public Graduate(int studentId, String name, String email, String phoneNumber) {
        super(studentId, name, email, phoneNumber);
    }
}

// Undergraduate class
class Undergraduate extends StudentMS {
    public Undergraduate(int studentId, String name, String email, String phoneNumber) {
        super(studentId, name, email, phoneNumber);
    }
}

// Base Course class
abstract class CourseList {
    private int courseId;
    private String courseName;
    private int credits;

    public CourseList(int courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public abstract String getCourseType();

    @Override
    public String toString() {
        return courseName + " (Credits: " + credits + ")";
    }

    // Getters
    public int getCourseId() {
        return courseId;
    }
}

// Mandatory Course class
class MandatoryCourse extends CourseList {
    public MandatoryCourse(int courseId, String courseName, int credits) {
        super(courseId, courseName, credits);
    }

    @Override
    public String getCourseType() {
        return "Mandatory";
    }
}

// Elective Course class
class ElectiveCourse extends CourseList {
    public ElectiveCourse(int courseId, String courseName, int credits) {
        super(courseId, courseName, credits);
    }

    @Override
    public String getCourseType() {
        return "Elective";
    }
}

// Enrollment Management class
class EnrollmentManagement {
    private List<StudentMS> studentList;
    private List<CourseList> courseList;

    public EnrollmentManagement() {
        studentList = new ArrayList<>();
        courseList = new ArrayList<>();
    }
/*
    public void addStudent(StudentMS student) {
        studentList.add(student);
    }

    public void addCourse(CourseList course) {
        courseList.add(course);
    }

*/

        // to add new student
    public void addStudent(int studentId, String name, String email, String phoneNumber, boolean isGraduate) {
        StudentMS student;
        if (isGraduate) {
            student = new Graduate(studentId, name, email, phoneNumber);
        } else {
            student = new Undergraduate(studentId, name, email, phoneNumber);
        }
        studentList.add(student);
    }

    /// to add course in list
    public void addCourse(int courseId, String courseName, int credits, boolean isMandatory) {
        CourseList course;
        if (isMandatory) {
            course = new MandatoryCourse(courseId, courseName, credits);
        } else {
            course = new ElectiveCourse(courseId, courseName, credits);
        }
        courseList.add(course);
    }

    public void enrollStudentInCourse(int studentId, int courseId) {
        StudentMS student = findStudentById(studentId);
        CourseList course = findCourseById(courseId);

        if (student != null && course != null) {
            student.enrollCourse(course);
            System.out.println("Student " + studentId + " enrolled in " + course);
        } else {
            System.out.println("Invalid student ID or course ID.");
        }
    }

    private StudentMS findStudentById(int studentId) {
        for (StudentMS student : studentList) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    private CourseList findCourseById(int courseId) {
        for (CourseList course : courseList) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    public void printAllStudents() {
        for (StudentMS student : studentList) {
            student.printInfo();
            System.out.println();
        }
    }

    public void printAllCourses() {
        for (CourseList course : courseList) {
            System.out.println(course + " (Type: " + course.getCourseType() + ")");
        }
    }

    // Method to print all graduate students
    public void printAllGraduateStudents() {
        boolean found = false;
        for (StudentMS student : studentList) {
            if (student instanceof Graduate) {
                student.printInfo();
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No graduate students found.");
        }
    }

    // Method to print all undergraduate students
    public void printAllUndergraduateStudents() {
        boolean found = false;
        for (StudentMS student : studentList) {
            if (student instanceof Undergraduate) {
                student.printInfo();
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No undergraduate students found.");
        }
    }
}
