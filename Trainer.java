package lab4;

public class Trainer implements common {
    
    private String speciality;    
    private String trainerId;
    private String name;
    private String email;
    private String phoneNumber;

    public Trainer(String speciality, String trainerId, String name, String email, String phoneNumber) {
        this.speciality = speciality;
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    
    @Override
    public String lineRepresentation() {
        String line =trainerId + "," + name + "," + email + "," + speciality + "," +phoneNumber;
        return line;
    }

    @Override
    public String getSearchKey() {
        return trainerId;
    }
}
