package BackendClasses;

public class Member implements common {

    private String membershipType;
    private String status;
    private String memberID;
    private String name;
    private String email;
    private String phoneNumber;

    public Member( String memberID, String name, String membershipType, String email, String phoneNumber ,String status) {
        this.membershipType = membershipType;
        this.status = status;
        this.memberID = memberID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    

    @Override
    public String lineRepresentation() {
        return memberID + "," + name + "," + membershipType + "," + email + "," + phoneNumber + "," + status;
    }

    @Override
    public String getSearchKey() {
        return memberID;
    }

}
