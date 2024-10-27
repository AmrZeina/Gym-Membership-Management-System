package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class TrainerDatabase {

    private ArrayList<Trainer> records = new ArrayList<>();
    private String filename;

    public TrainerDatabase(String filename) throws FileNotFoundException {
        this.filename = filename;
        readFromFile();
    }

    private Trainer createRecordFrom(String line) {
        line = line.replace(" ", "");
        String[] splitted = line.split(",");
        if (splitted.length != 5) {
            System.out.println("Error: Invalid data format. Line does not have 5 elements: " + line);
            return null;
        }
        return new Trainer(splitted[0], splitted[1], splitted[2], splitted[3], splitted[4]);
    }

    private void readFromFile() throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            records.add(createRecordFrom(line));
        }
        scan.close();
    }

    private int searchTrainer(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSearchKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Trainer> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        return searchTrainer(key) != -1;
    }

    public Trainer getRecord(String key) {
        if (searchTrainer(key) != -1) {
            return records.get(searchTrainer(key));
        } else {
            return null;
        }
    }

    public void insertRecord(Trainer record) {
        if (searchTrainer(record.getSearchKey()) == -1) {
            records.add(record);
        } else {
            System.out.println("Trainer is already added on the system!");
        }
    }

    public void deleteRecord(String key) {
        if (searchTrainer(key) != -1) {
            records.remove(records.get(searchTrainer(key)));
        } else {
            System.out.println("Trainer is not on the system!");
        }
    }

    public void saveToFile() throws IOException {
        try {
            FileWriter writer = new FileWriter(filename, false);
            for (Trainer trainer : records) {
                writer.write(trainer.lineRepresentation() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File Not Found");
        }

    }
}
