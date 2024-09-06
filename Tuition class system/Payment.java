public class Payment {
    private String course_code;
    private String payment_id;
    private int payment_month;
    private double amount;

    public Payment(String course_code, String payment_id, int payment_month, double amount) {
        this.course_code = course_code;
        this.payment_id = payment_id;
        this.payment_month = payment_month;
        this.amount = amount;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public int getPayment_month() {
        return payment_month;
    }

    public double getAmount() {
        return amount;
    }

    public String getCourse_code() {
        return course_code;
    }
    
}
