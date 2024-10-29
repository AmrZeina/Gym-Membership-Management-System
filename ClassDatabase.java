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
import java.util.ArrayList;


public class ClassDatabase extends Database<Class> {
    
    public ClassDatabase(String filename) {
        super(filename);
    }
    
    
     @Override
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

     @Override
    public Class createRecordFrom(String line) {

        String[] temp = line.split(",");
         Class class1 = new Class(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        return class1;

    }
     @Override
    public ArrayList<Class> returnAllRecords() {
        return records;
    }
     @Override
    public boolean contains(String key)
    {
        return searchToGetIndex(key)!=-1;
    }

     @Override
    public Class getRecord(String key) {
        return (searchToGetIndex(key) != -1) ? records.get(searchToGetIndex(key)) : null;

    }

     @Override
    public void insertRecord(Class record) {
        if (searchToGetIndex(record.getSearchKey()) != -1) {
            System.out.println("This class already exist");
        } else {
            records.add(record);
            saveToFile();
        }

    }

     @Override
    public void deleteRecord(String key) {

        if (searchToGetIndex(key) == -1) {
            System.out.println("This class does not exist already");
        } else {
            records.remove(searchToGetIndex(key));
            saveToFile();
        }

    }

     @Override
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

     @Override
     public int searchToGetIndex(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (key.equals(records.get(i).getSearchKey())) {

                return i;

            }

        }
        return -1;
    }

    
    
}
