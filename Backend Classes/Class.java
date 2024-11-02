package lab4;

public class Class implements common {

    private String classID, className, trainerID;
    private int duration, availableSeats;

    public Class(String classID, String className, String trainerID, int duration, int availableSeats) {
        this.classID = classID;
        this.className = className;
        this.trainerID = trainerID;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int Seats) {
        if (Seats >= 0) {
            this.availableSeats = Seats;
        } else {
            System.out.println("Number of seats invalid!");
        }
    }

    @Override
    public String lineRepresentation() {
        return classID + "," + className + "," + trainerID + "," + duration + "," + availableSeats;
    }

    @Override
    public String getSearchKey() {
        return classID;
    }

}
