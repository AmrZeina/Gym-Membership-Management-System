package lab4;

import java.util.ArrayList;

abstract class Database {

    private ArrayList<Object> records = new ArrayList<>();
    private String filename;

    abstract public void readFromFile();
    
    abstract public Object createRecordFrom(String line);

    abstract public ArrayList<Object> returnAllRecords();

    abstract public boolean contains(String key);
    
    abstract public Object getRecord(String key);
    
    abstract public void insertRecord(Object record);
    
    abstract public void deleteRecord(String key);
    
    abstract public void saveToFile();
    
    abstract int searchTrainer(String key);
    
}
