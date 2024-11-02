package lab4;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MemberClassRegistrationDatabase extends Database<MemberClassRegistration> {

    public MemberClassRegistrationDatabase(String filename) throws FileNotFoundException {
        super(filename);
    }

    @Override
    public MemberClassRegistration createRecordFrom(String line) {
        line = line.replace(" ", "");
        String[] splitted = line.split(",");
        if (splitted.length != 4) {
            return null;
        }
        LocalDate date;
        try {
            date = LocalDate.parse(splitted[2]);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid Date Format!");
            return null;
        }
        return new MemberClassRegistration(splitted[0], splitted[1], splitted[3], date);
    }

    public void deleteRecordsByClassID(String ID) {
        for (int i = 0; i < returnAllRecords().size(); i++) {
            if (returnAllRecords().get(i).getClassID().equals(ID)) {
                returnAllRecords().remove(returnAllRecords().get(i));
                return;
            }
        }
    }
}
