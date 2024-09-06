public class Payment {
    private int payment_month;
    private double amount;

    public Payment( int payment_month, double amount) {
        this.payment_month = payment_month;
        this.amount = amount;
    }



    public int getPayment_month() {
        return payment_month;
    }

    public double getAmount() {
        return amount;
    }
    
    
}
