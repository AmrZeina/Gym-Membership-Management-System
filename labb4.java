package labb4;

import java.util.ArrayList;

public class labb4 {

    public static void main(String[] args) {
        // Specify the file name for storing member data
        String filename = "members.txt";

        // Create a MemberDatabase instance
        MemberDatabase database = new MemberDatabase(filename);

        // Test reading from the file
        database.readFromFile();
        System.out.println("All records after reading from file:");
        displayAllRecords(database);

        // Test inserting a new member
        Member newMember = new Member("M123", "Alice Smith", "Gold", "alice@example.com", "123-456-7890", "Active");
        database.insertRecord(newMember);
        Member newMember2 = new Member("M567", "Alice Smith", "Gold", "alice@example.com", "123-456-7890", "Active");
        database.insertRecord(newMember2);
        System.out.println("\nAll records after inserting a new member:");
        displayAllRecords(database);

        // Test retrieving a specific member by ID
        String searchKey = "M123";
        Member foundMember = database.getRecord(searchKey);
        if (foundMember != null) {
            System.out.println("\nRecord found for ID " + searchKey + ":");
            System.out.println(foundMember.lineRepresentation());
        } else {
            System.out.println("\nNo record found for ID " + searchKey);
        }

        // Test deleting a member
        database.deleteRecord(searchKey);
        System.out.println("\nAll records after deleting member with ID " + searchKey + ":");
        displayAllRecords(database);
    }

    // Helper method to display all records in the database
    private static void displayAllRecords(MemberDatabase database) {
        ArrayList<Member> records = database.returnAllRecords();
        for (Member record : records) {
            System.out.println(record.lineRepresentation());
        }
    }
}
