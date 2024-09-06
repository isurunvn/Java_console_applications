import java.util.ArrayList;

public class Student {
    private String stu_id;
    private String stu_name;
    private int age;
    private String gender;

    ArrayList <Payment> paymentsList = new ArrayList<>();


    public Student(String stu_id, String stu_name, int age, String gender) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.age = age;
        this.gender = gender;
    }

    public String getStu_id() {
        return stu_id;
    }

    public String getName() {
        return stu_name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    
    
}
