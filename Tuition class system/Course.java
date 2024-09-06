public class Course {
    private String course_name;
    private String course_code;
    private String course_description;

    public Course(String course_name, String course_code, String course_description) {
        this.course_name = course_name;
        this.course_code = course_code;
        this.course_description = course_description;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getCourse_description() {
        return course_description;
    }
    
}
