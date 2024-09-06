import java.util.ArrayList;
import java.util.Scanner;

public class HostelApplication {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Hostel hostel = new Hostel();

        char choice;
    
        do {
            System.out.println("1. Add a tenant ");
            System.out.println("2. Remove a tenant");
            System.out.println("3. All tenants");
            System.out.println("4. Vacant rooms");
            System.out.println("5. Do payment");
            System.out.println("6. View payment history");
            System.out.println("7. View total payment for a room");
            System.out.println("8. Check payment status for a specific month");
            System.out.println("9. Identify Tenants with Missing Payments");  
            System.out.println("0. Exit");

            System.out.println("Please enter your choice: ");
            choice = scan.next().charAt(0);

            switch (choice) {
                case '1':
                    option1(hostel);
                    break;

                    case '2':
                        option2(hostel);
                        break;

                        case '3':
                        option3(hostel);
                        break;

                        case '4':
                        option4(hostel);
                        break;

                        case '5':
                        option5(hostel);
                        break;

                        case '6':
                        option6(hostel);
                        break;

                        case '7':
                        option7(hostel);
                        break;

                        case '8':
                        option8(hostel);
                        break;

                        case '9':
                        option9(hostel);
                        break;

            
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != '0');
    }

    public static void option1(Hostel hostel) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter tenant id: ");
        String tenant_id = scan.nextLine();
        System.out.println("Enter tenant name: ");
        String tenant_name = scan.nextLine();
        System.out.println("Enter room number(1 to 50): ");
        int room_number = scan.nextInt();
        if (room_number < 1 || room_number > 50) {
            System.out.println("Invalid room number");
            return;
        }

        boolean success = hostel.addTenant(tenant_id, tenant_name, room_number);
        if (success) {
            System.out.println("Tenant added successfully");
        } else {
            System.out.println("Tenant already exists");
        }
    }

    public static void option2(Hostel hostel) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter tenant id to remove: ");
        String tenant_id = scan.nextLine();

        boolean success = hostel.removeTenant(tenant_id);
        if (success) {
            System.out.println("Tenant removed successfully");
        } else {
            System.out.println("Tenant does not exist");
        }
    }

    public static void option3(Hostel hostel) {
        ArrayList<Tenant> tenants = hostel.getAllTenants();
        for (int i = 0; i < tenants.size(); i++) {
            System.out.println("Tenant Id: " + tenants.get(i).getTenant_id());
            System.out.println("Tenant name: " + tenants.get(i).getTenant_name());
            System.out.println("Room number: " + tenants.get(i).getRoom_number());
        }
    }

    public static void option4(Hostel hostel) {
        int totalTenants = hostel.getTenantCount();
        int vacants = 50 - totalTenants;
        System.out.println("Number of vacants: " + vacants);
    }

    public static void option5(Hostel hostel) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter tenant id who is paying: ");
        String tenant_id = scan.nextLine();
        System.out.println("Paying month(1 to 12): ");
        int month = scan.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Invalid month");
            return;
        }
        System.out.println("Enter amount: ");
        double amount = scan.nextDouble();

        boolean success = hostel.doPayment(tenant_id, month, amount);
        if (success) {
            System.out.println("Payment added successfully");
        } else {
            System.out.println("Payment already exists");
        }
        
    }

    public static void option6(Hostel hostel) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student id to view payment history: ");
        String stu_id = sc.next();

        ArrayList<Payment> payment = hostel.viewPaymentHistory(stu_id);
        if (payment != null) {
            System.out.println("Payment history for student: " + stu_id);
            for (int i = 0; i < payment.size(); i++) {
                System.out.println("Payment month: " + payment.get(i).getPayment_month());
                System.out.println("Payment amount: " + payment.get(i).getAmount());
            }
        } else {
            System.out.println("Payment not found.");
        }
    }

    public static void option7(Hostel hostel) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter tenant id to view total payment for a room: ");
        String tenant_id = scan.nextLine();

        double totalPayment = hostel.totalPaymentForRoom(tenant_id);
        if (totalPayment != 0) {
            System.out.println("Total payment for room: " + totalPayment);
        } else {
            System.out.println("Payment not found.");
        }
    }

    public static void option8(Hostel hostel) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter tenant id to check the payment status: ");
        String tenant_id = scan.nextLine();
        System.out.println("Enter month to check payment status: ");
        int month = scan.nextInt();

        boolean paymentStatus = hostel.checkPaymentStatus(tenant_id, month);
        if (paymentStatus) {
            System.out.println("Payment status: Paid");
        } else {
            System.out.println("Payment status: Outstanding");
        }
    }

    public static void option9(Hostel hostel) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter month to check for tenents with missing payments: ");
        int month = scan.nextInt();
        ArrayList<Tenant> tenants = hostel.tenantsWithMissingPayments(month);
        if (tenants.size() > 0) {
            System.out.println("Tenants with missing payments: ");
            for (int i = 0; i < tenants.size(); i++) {
                System.out.println("Tenant id: " + tenants.get(i).getTenant_id());
                System.out.println("Tenant name: " + tenants.get(i).getTenant_name());
            }
        } else {
            System.out.println("No tenants with missing payments");
        }
    }
}