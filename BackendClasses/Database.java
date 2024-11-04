package BackendClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

abstract class Database<T extends common> {

    ArrayList<T> records = new ArrayList<>();
    String filename;

    public Database(String filename) {
        this.filename = filename;
        readFromFile();
    }

    public ArrayList<T> returnAllRecords() {
        return records;
    }

    public String getFilename() {
        return filename;
    }

    public void readFromFile() {
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                records.add(createRecordFrom(line));
            }
            scan.close();
        } catch (FileNotFoundException e) {
            return;
        }
    }

    public boolean contains(String key) {
        return searchToGetIndex(key) != -1;
    }

    public T getRecord(String key) {
        if (searchToGetIndex(key) != -1) {
            return records.get(searchToGetIndex(key));
        } else {
            return null;
        }
    }

    public boolean insertRecord(T record) {
        if (searchToGetIndex(record.getSearchKey()) == -1) {
            records.add(record);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteRecord(String key) {
        if (searchToGetIndex(key) != -1) {
            records.remove(records.get(searchToGetIndex(key)));
            return true;
        } else {
            return false;
        }
    }

    public void saveToFile() throws IOException {
        FileWriter writer = new FileWriter(getFilename(), false);
        for (T t : records) {
            writer.write(t.lineRepresentation() + "\n");
        }
        writer.close();
    }

    public int searchToGetIndex(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSearchKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    abstract public T createRecordFrom(String line);

}
