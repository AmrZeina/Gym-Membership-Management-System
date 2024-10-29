package labb4;

public class Member extends Person {

    private String membershipType;
    private String status;

    public Member(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        super(name, memberID, email, phoneNumber);
        this.membershipType = membershipType;
        this.status = status;
    }

    @Override
    public String lineRepresentation() {
        return getId() + "," + getName() + "," + membershipType + "," + getEmail() + "," + getPhoneNumber() + "," + status;
    }

    @Override
    public String getSearchKey() {
        return getId();
    }

}
