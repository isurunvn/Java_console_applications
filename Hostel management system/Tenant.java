import java.util.ArrayList;

public class Tenant {
    private String tenant_id;
    private String tenant_name;
    private int room_number;

    ArrayList<Payment> payments = new ArrayList<>();

    public Tenant(String tenant_id, String tenant_name, int room_number) {
        this.tenant_id = tenant_id;
        this.tenant_name = tenant_name;
        this.room_number = room_number;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public String getTenant_name() {
        return tenant_name;
    }

    public int getRoom_number() {
        return room_number;
    }
    
    
}
