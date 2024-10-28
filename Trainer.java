package lab4;

public class Trainer extends Person {
    
    private String speciality;    

    public Trainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        super(name, trainerId , email, phoneNumber);
        this.speciality = speciality;
    }
    
    @Override
    public String lineRepresentation() {
        String line = getId() + "," + getName() + "," + getEmail() + "," + speciality + "," + getPhoneNumber();
        return line;
    }

    @Override
    public String getSearchKey() {
        return getId();
    }
}
