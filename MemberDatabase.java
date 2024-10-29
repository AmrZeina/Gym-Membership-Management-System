
package labb4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MemberDatabase extends Database<Member> {

    
    public MemberDatabase(String filename) {
        super(filename);
        
    }

    @Override
    public void readFromFile() {
        Member member;

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
                if (temp.length == 6) {
                    member = new Member(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
                    records.add(member);
                }

            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Member createRecordFrom(String line) {

        String[] temp = line.split(",");
        Member member = new Member(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
        return member;

    }
    @Override
    public ArrayList<Member> returnAllRecords() {
        return records;
    }
    @Override
    public boolean contains(String key) {
        return searchToGetIndex(key) != -1;
    }

    @Override
    public Member getRecord(String key) {
        return (searchToGetIndex(key) != -1) ? records.get(searchToGetIndex(key)) : null;

    }

    @Override
    public void insertRecord(Member record) {
        if (searchToGetIndex(record.getSearchKey()) != -1) {
            System.out.println("This member already exist");
        } else {
            records.add(record);
            saveToFile();
        }

    }

    @Override
    public void deleteRecord(String key) {

        if (searchToGetIndex(key) == -1) {
            System.out.println("This member does not exist already");
        } else {
            records.remove(searchToGetIndex(key));
            saveToFile();
        }

    }

    @Override
    public void saveToFile() {
        try {

            try (FileWriter writer = new FileWriter(filename, false)) {
                for (Member record : records) {
                    writer.write(record.lineRepresentation() + "\n");
                }
            }

        } catch (IOException exc) {
            System.out.println("file not found");
        }

    }

    @Override
    public int searchToGetIndex(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (getRecords().get(i).getSearchKey().equals(key)) {

                return i;

            }

        }
        return -1;
    }

    

    

}
