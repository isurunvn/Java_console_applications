public class Member {
    private String member_id;
    private String member_name;


    public Member(String member_id, String member_name) {
        this.member_id = member_id;
        this.member_name = member_name;
    }

    public String getMemberName(){
        return member_name;
    }

    public String getMemberId(){
        return member_id;
    }

}
