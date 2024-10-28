package lab4;

import java.io.IOException;
import java.util.ArrayList;

abstract class Database<T> {

    private ArrayList<T> records = new ArrayList<>();
    private String filename;

    public Database(String filename) {
        this.filename = filename;
    }

    public ArrayList<T> getRecords() {
        return records;
    }

    public String getFilename() {
        return filename;
    }
    
    abstract public void readFromFile();
    
    abstract public T createRecordFrom(String line);

    abstract public ArrayList<Trainer> returnAllRecords();

    abstract public boolean contains(String key);
    
    abstract public T getRecord(String key);
    
    abstract public void insertRecord(Trainer record);
    
    abstract public void deleteRecord(String key);
    
    abstract public void saveToFile() throws IOException;
    
    abstract int searchTrainer(String key);
    
}
