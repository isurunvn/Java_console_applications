import java.util.ArrayList;

public class Hostel {

    ArrayList<Tenant> tenantsList = new ArrayList<>();

    public int searchTenant(String tenant_id) {
        for (int i=0; i<tenantsList.size(); i++) {
            if (tenantsList.get(i).getTenant_id().equals(tenant_id)) {
                return i;
            }
        }
        return -1;
    }

    public int searchRoom(int room_number) {
        for (int i=0; i<tenantsList.size(); i++) {
            if (tenantsList.get(i).getRoom_number() == room_number) {
                return i;
            }
        }
        return -1;
    }

    public boolean addTenant(String tenant_id, String tenant_name, int room_number) {
        if (searchTenant(tenant_id) == -1 && searchRoom(room_number) == -1) {
            tenantsList.add(new Tenant(tenant_id, tenant_name, room_number));
            return true;
        } else {
            return false;
        }
    }

    public boolean removeTenant(String tenant_id) {
        if (searchTenant(tenant_id) != -1) {
            tenantsList.remove(searchTenant(tenant_id));
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Tenant> getAllTenants() {
        return tenantsList;
    }

    public int getTenantCount() {
        return tenantsList.size();
    }

    public boolean doPayment(String tenant_id, int month, double amount) {
        int tenantIndex = searchTenant(tenant_id);
        if (tenantIndex != -1) {
            tenantsList.get(tenantIndex).payments.add(new Payment(month, amount));
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Payment> viewPaymentHistory(String tenant_id) {
        int tenantIndex = searchTenant(tenant_id);
        if (tenantIndex != -1) {
            return tenantsList.get(tenantIndex).payments;
        } else {
            return null;
        }
    }
    
    public double totalPaymentForRoom(String tenant_id) {
        int tenantIndex = searchTenant(tenant_id);
        int totalPayment = 0;
        if (tenantIndex != -1) {
            for (int i = 0; i < tenantsList.get(tenantIndex).payments.size(); i++) {
                totalPayment += tenantsList.get(tenantIndex).payments.get(i).getAmount();
            }
            return totalPayment;
        } else {
            return 0;
        }
    }

    public boolean checkPaymentStatus(String tenant_id, int month) {
        int tenantIndex = searchTenant(tenant_id);
        if (tenantIndex != -1) {
            for (int i = 0; i < tenantsList.get(tenantIndex).payments.size(); i++) {
                if (tenantsList.get(tenantIndex).payments.get(i).getPayment_month() == month
                    && tenantsList.get(tenantIndex).payments.get(i).getAmount() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Tenant> tenantsWithMissingPayments(int month) {
        ArrayList<Tenant> tenantsWithMissingPayments = new ArrayList<>();
        for (int i = 0; i < tenantsList.size(); i++) {
            if (!checkPaymentStatus(tenantsList.get(i).getTenant_id(), month)) {
                tenantsWithMissingPayments.add(tenantsList.get(i));
            }
        }
        return tenantsWithMissingPayments;
    }
}
