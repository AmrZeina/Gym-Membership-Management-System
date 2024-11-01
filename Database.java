package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Database<T extends common> {

    ArrayList<T> records = new ArrayList<>();
    String filename;

    public Database(String filename) {
        this.filename = filename;
    }

    public ArrayList<T> returnAllRecords() {
        return records;
    }

    public String getFilename() {
        return filename;
    }

    public void readFromFile() {
        try {
            File file = new File(getFilename());
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                returnAllRecords().add(createRecordFrom(line));
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Data not found!");
            return;
        }
    }

    public boolean contains(String key) {
        return searchToGetIndex(key) != -1;
    }

    public T getRecord(String key) {
        if (searchToGetIndex(key) != -1) {
            return returnAllRecords().get(searchToGetIndex(key));
        } else {
            return null;
        }
    }

    public void insertRecord(T record) {
        if (searchToGetIndex(record.getSearchKey()) == -1) {
            returnAllRecords().add(record);
            System.out.println("Record added!");
        } else {
            System.out.println("Record is already added on the system!");
        }
    }

    public void deleteRecord(String key) {
        if (searchToGetIndex(key) != -1) {
            returnAllRecords().remove(returnAllRecords().get(searchToGetIndex(key)));
            System.out.println("Registration removed!");
        } else {
            System.out.println("Registration is not on the system!");
        }
    }

    public void saveToFile() throws IOException {
        FileWriter writer = new FileWriter(getFilename(), false);
        for (T t : returnAllRecords()) {
            writer.write(t.lineRepresentation() + "\n");
        }
        System.out.println("Changes Saved");
        writer.close();
    }

    public int searchToGetIndex(String key) {
        for (int i = 0; i < returnAllRecords().size(); i++) {
            if (returnAllRecords().get(i).getSearchKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    abstract public T createRecordFrom(String line);

}
