package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class TrainerDatabase extends Database<Trainer>{
    
    public TrainerDatabase(String filename) throws FileNotFoundException {
        super(filename);
        readFromFile();
    }

    @Override
    public void readFromFile() {
        try {
            File file = new File(getFilename());
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                getRecords().add(createRecordFrom(line));
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Trainers data not found!");
            return;
        }
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

    @Override
    public ArrayList<Trainer> returnAllRecords() {
        return getRecords();
    }

    @Override
    public boolean contains(String key) {
        return searchTrainer(key) != -1;
    }

    @Override
    public Trainer getRecord(String key) {
        if (searchTrainer(key) != -1) {
            return getRecords().get(searchTrainer(key));
        } else {
            return null;
        }
    }

    @Override
    public void insertRecord(Trainer record) {
        if (searchTrainer(record.getSearchKey()) == -1) {
            getRecords().add(record);
            System.out.println("Trainer added!");
        } else {
            System.out.println("Trainer is already added on the system!");
        }
    }

    @Override
    public void deleteRecord(String key) {
        if (searchTrainer(key) != -1) {
            getRecords().remove(getRecords().get(searchTrainer(key)));
            System.out.println("Trainer removed!");
        } else {
            System.out.println("Trainer is not on the system!");
        }
    }

    @Override
    public void saveToFile() throws IOException {
        FileWriter writer = new FileWriter(getFilename(), false);
            for (Trainer trainer : getRecords()) {
                writer.write(trainer.lineRepresentation() + "\n");
            }
            System.out.println("Changes Saved");
            writer.close();
    }

    @Override
    int searchTrainer(String key) {
        for (int i = 0; i < getRecords().size(); i++) {
            if (getRecords().get(i).getSearchKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
