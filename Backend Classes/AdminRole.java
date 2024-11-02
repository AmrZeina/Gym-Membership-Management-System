package lab4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AdminRole {

    private TrainerDatabase database;

    public AdminRole() throws FileNotFoundException {
        this.database=new TrainerDatabase("Trainers.txt");
    }

    public void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) 
    {
        Trainer trainer=new Trainer (trainerId, name,email,specialty, phoneNumber);
        database.insertRecord(trainer);
    }
    
    public ArrayList<Trainer> getListOfTrainers()
    {
        return database.returnAllRecords();
    }
    
    public void removeTrainer(String key)
    {
        database.deleteRecord(key);
    }
    
    public void logout() throws IOException
    {
        database.saveToFile();
    }
}
