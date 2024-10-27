/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labb4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

/**
 *
 * @author amrze
 */
public class ClassDatabase {
     private ArrayList<Class> records=new ArrayList<>();
    private String filename;

    public ClassDatabase(String filename) {
        this.filename = filename;
    }
    
    public void readFromFile() {
        
        Class class1;

        try {
            File file = new File(filename);
            FileReader reader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] temp = line.split(",");
                if (temp.length == 5) {
                    class1= new Class(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
                    records.add(class1);
                }

            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Class createRecordFrom(String line) {

        String[] temp = line.split(",");
         Class class1 = new Class(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        return class1;

    }
    public ArrayList<Class> returnAllRecords() {
        return records;
    }
    public boolean contains(String key)
    {
        return searchForClass(key)!=-1;
    }

    public Class getRecord(String key) {
        return (searchForClass(key) != -1) ? records.get(searchForClass(key)) : null;

    }

    public void insertRecord(Class record) {
        if (searchForClass(record.getSearchKey()) != -1) {
            System.out.println("This class already exist");
        } else {
            records.add(record);
            saveToFile();
        }

    }

    public void deleteRecord(String key) {

        if (searchForClass(key) == -1) {
            System.out.println("This class does not exist already");
        } else {
            records.remove(searchForClass(key));
            saveToFile();
        }

    }

    public void saveToFile() {
        try {

            FileWriter writer = new FileWriter(filename, false);
            for (Class record : records) {
                writer.write(record.lineRepresentation() + "\n");
            }
            writer.close();

        } catch (IOException exc) {
            System.out.println("file not found");
        }

    }

    private int searchForClass(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (key.equals(records.get(i).getSearchKey())) {

                return i;

            }

        }
        return -1;
    }

    
}
