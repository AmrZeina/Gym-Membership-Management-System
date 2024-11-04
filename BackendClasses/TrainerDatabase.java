package BackendClasses;

import java.io.FileNotFoundException;

public class TrainerDatabase extends Database<Trainer> {

    public TrainerDatabase(String filename) throws FileNotFoundException {
        super(filename);
    }

    @Override
    public Trainer createRecordFrom(String line) {
        line = line.replace(" ", "");
        String[] splitted = line.split(",");
        if (splitted.length != 5) {
            return null;
        }
        return new Trainer(splitted[0], splitted[1], splitted[2], splitted[3], splitted[4]);
    }
}
