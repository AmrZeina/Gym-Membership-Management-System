
package labb4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MemberDatabase {

    private  ArrayList<Member> records = new ArrayList<>();
    private String filename;

    public MemberDatabase(String filename) {
        this.filename = filename;
    }

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

    public Member createRecordFrom(String line) {

        String[] temp = line.split(",");
        Member member = new Member(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
        return member;

    }
    public ArrayList<Member> returnAllRecords() {
        return records;
    }

    public Member getRecord(String key) {
        return (searchForMember(key) != -1) ? records.get(searchForMember(key)) : null;

    }

    public void insertRecord(Member record) {
        if (searchForMember(record.getSearchKey()) != -1) {
            System.out.println("This member already exist");
        } else {
            records.add(record);
            saveToFile();
        }

    }

    public void deleteRecord(String key) {

        if (searchForMember(key) == -1) {
            System.out.println("This member does not exist already");
        } else {
            records.remove(searchForMember(key));
            saveToFile();
        }

    }

    public void saveToFile() {
        try {

            FileWriter writer = new FileWriter(filename, false);
            for (Member record : records) {
                writer.write(record.lineRepresentation() + "\n");
            }
            writer.close();

        } catch (IOException exc) {
            System.out.println("file not found");
        }

    }

    private int searchForMember(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (key == records.get(i).getSearchKey()) {

                return i;

            }

        }
        return -1;
    }

}
