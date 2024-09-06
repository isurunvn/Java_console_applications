import java.util.ArrayList;
import java.util.Scanner;

public class TuitionApplication {
    public static void main(String[] args) {
        char choice;

        Scanner sc = new Scanner(System.in);

        Tuition tuition = new Tuition();

        System.out.println("Welcome to the Tuition Management System");
        System.out.println("----------------------------------------");


        do {
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Do Payment");
            System.out.println("4. Filter Student by student Id");
            System.out.println("5. Filter Courses by course code");
            System.out.println("6. Filter Payment by payment id");
            System.out.println("7. View All Students");
            System.out.println("8. View All Courses");
            System.out.println("9. View Payment History of a Student");
            System.out.println("0. Exit");

            System.out.println("Please enter your choice: ");
            choice = sc.next().charAt(0);

            switch (choice) {
                case '1':
                    option1(tuition);
                    break;
                case '2':
                    option2(tuition);
                    break;
                case '3':
                    option3(tuition);
                    break;
                case '4':
                    option4(tuition);
                    break;
                case '5':
                    option5(tuition);
                    break;
                case '6':
                    option6(tuition);
                    break;
                case '7':
                    option7(tuition);;
                    break;
                case '8':
                    option8(tuition);
                    break;
                case '9':
                    option9(tuition);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != '0');
    }

    public static void option1(Tuition tuition) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student id: ");
        String stu_id = sc.next();
        System.out.println("Enter student name: ");
        String name = sc.next();
        System.out.println("Enter student age: ");
        int age = sc.nextInt();
        System.out.println("Enter student gender: ");
        String gender = sc.next();

        boolean success = tuition.addStudent(stu_id, name, age, gender);
        if (success) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Failed to add student.");
        }
    }

    public static void option2(Tuition tuition) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter course name: ");
        String name = sc.next();
        System.out.println("Enter course code: ");
        String code = sc.next();
        System.out.println("Enter course description: ");
        String description = sc.next();

        boolean success = tuition.addCourse(name, code, description);
        if (success) {
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Failed to add course.");
        }
    }

    public static void option3(Tuition tuition) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter payment id: ");
        String payment_id = sc.next();
        System.out.println("Enter payed student id: ");
        String stu_id = sc.next();
        System.out.println("Enter payed course code: ");
        String course_id = sc.next();
        System.out.println("Enter payment Month: ");
        int month = sc.nextInt();
        System.out.println("Enter amount: ");
        double amount = sc.nextDouble();

        boolean success = tuition.doPayment(payment_id, stu_id, course_id, month, amount);
        if (success) {
            System.out.println("Payment added successfully.");
        } else {
            System.out.println("Failed to add payment.");
        }
    }

    public static void option4(Tuition tuition) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student id to search: ");
        String stu_id = sc.next();

        Student student = tuition.getStudent(stu_id);

        if (student != null) {
            System.out.println("Student found.");
            System.out.println("Student name: " + student.getName());
            System.out.println("Student age: " + student.getAge());
            System.out.println("Student gender: " + student.getGender());
        } else {
            System.out.println("Student not found.");
        }
    }
    
    public static void option5(Tuition tuition) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter course code to search: ");
        String course_code = sc.next();

        Course course = tuition.getCourse(course_code);
        if (course != null) {
            System.out.println("Course found.");
            System.out.println("Course name: " + course.getCourse_name());
            System.out.println("Course code: " + course.getCourse_code());
            System.out.println("Course description: " + course.getCourse_description());
        } else {
            System.out.println("Course not found.");
        }
    }

    public static void option6(Tuition tuition) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter payment id to search: ");
        String payment_id = sc.next();

        Payment payment = tuition.getPayment(payment_id);
        if (payment != null) {
            System.out.println("Payment found.");
            System.out.println("Payment id: " + payment.getPayment_id());
            // System.out.println("Student id: " + payment.getStu_id());
            System.out.println("Course code: " + payment.getCourse_code());
            System.out.println("Payment month: " + payment.getPayment_month());
            System.out.println("Payment amount: " + payment.getAmount());
        } else {
            System.out.println("Payment not found.");
        }
    }

    public static void option7(Tuition tuition) {
        System.out.println("All students: ");
        ArrayList<Student> students = tuition.getAllStudents();
        for (int i = 0; i < students.size(); i++) {
            System.out.println("Student id: " + students.get(i).getStu_id());
            System.out.println("Student name: " + students.get(i).getName());
            System.out.println("Student age: " + students.get(i).getAge());
            System.out.println("Student gender: " + students.get(i).getGender());
        }
    }

    public static void option8(Tuition tuition) {
        System.out.println("All courses: ");
        ArrayList<Course> courses = tuition.getAllCourses();
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("Course code: " + courses.get(i).getCourse_code());
            System.out.println("Course name: " + courses.get(i).getCourse_name());
            System.out.println("Course description: " + courses.get(i).getCourse_description());
        }
    }

    public static void option9(Tuition tuition) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student id to view payment history: ");
        String stu_id = sc.next();

        ArrayList<Payment> payment = tuition.viewPaymentHistory(stu_id);
        if (payment != null) {
            System.out.println("Payment history for student: " + stu_id);
            for (int i = 0; i < payment.size(); i++) {
                System.out.println("Payment id: " + payment.get(i).getPayment_id());
                System.out.println("Course code: " + payment.get(i).getCourse_code());
                System.out.println("Payment month: " + payment.get(i).getPayment_month());
                System.out.println("Payment amount: " + payment.get(i).getAmount());
            }
        } else {
            System.out.println("Payment not found.");
        }
    }


}