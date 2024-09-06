import java.util.ArrayList;

public class Tuition {
    ArrayList <Student> studentsList = new ArrayList<>();
    ArrayList <Course> coursesList = new ArrayList<>();

    private int searchStudent(String stu_id){
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getStu_id().equals(stu_id)) {
                return i;
            }
        }
        return -1;
    }

    private int searchCourse(String course_code){
        for (int i = 0; i < coursesList.size(); i++) {
            if (coursesList.get(i).getCourse_code().equals(course_code)) {
                return i;
            }
        }
        return -1;
    }

    private int searchPayment(String payment_id){
        for (int i = 0; i < studentsList.size(); i++) {
            for (int j=0; j < studentsList.get(i).paymentsList.size(); j++) {
                if (studentsList.get(i).paymentsList.get(j).getPayment_id().equals(payment_id)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean addStudent(String stu_id, String stu_name, int age, String gender){
        if (searchStudent(stu_id) == -1) {
            studentsList.add(new Student(stu_id, stu_name, age, gender));
            return true;
        }
        return false;
    }

    public boolean addCourse(String course_name, String course_code, String course_description){
        if (searchCourse(course_code) == -1) {
            coursesList.add(new Course(course_name, course_code, course_description));
            return true;
        }
        return false;
    }

    public boolean doPayment(String payment_id, String stu_id, String course_code, int payment_month, double amount){
        if (searchStudent(stu_id) != -1 && searchCourse(course_code) != -1) {
            Student selectedStudent = getStudent(stu_id);
            Payment newPayment = new Payment(course_code, payment_id, payment_month, amount);
            selectedStudent.paymentsList.add(newPayment);
            return true;
        }
        return false;
    }

    public ArrayList<Payment> viewPaymentHistory(String stu_id){
        int selectedStudentIndex = searchStudent(stu_id);
        if (selectedStudentIndex != -1) {
            return new ArrayList<>(studentsList.get(selectedStudentIndex).paymentsList);
        } else {
            return new ArrayList<>();
        }
    }

    public ArrayList<Student> getAllStudents(){
        return studentsList;
    }

    public ArrayList<Course> getAllCourses(){
        return coursesList;
    }

    public Student getStudent(String stu_id){
        int index = searchStudent(stu_id);
        if (index != -1) {
            return studentsList.get(index);
        }
        return null;
    }

    public Course getCourse(String course_code){
        int index = searchCourse(course_code);
        if (index != -1) {
            return coursesList.get(index);
        }
        return null;
    }

    public Payment getPayment(String payment_id){
        int index = searchPayment(payment_id);
        if (index != -1) {
            return studentsList.get(index).paymentsList.get(index);
        }
        return null;
    }
    
    
}
