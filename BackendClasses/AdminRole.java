package BackendClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AdminRole {

    private TrainerDatabase database;

    public AdminRole() throws FileNotFoundException {
        this.database=new TrainerDatabase("Trainers.txt");
    }

    public void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) 
    {
        Trainer trainer=new Trainer (trainerId, name,email,specialty, phoneNumber);
        if (database.insertRecord(trainer)) {
            JOptionPane.showMessageDialog(null, "The Trainer with ID= " + trainerId + " has succefully added!");
        } else {
            JOptionPane.showMessageDialog(null, "The Trainer with ID= " + trainerId + " Already Exists!", "Message", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public ArrayList<Trainer> getListOfTrainers()
    {
        return database.returnAllRecords();
    }
    
    public void removeTrainer(String key)
    {
        if (database.deleteRecord(key)) {
            JOptionPane.showMessageDialog(null, "The Trainer with ID= " + key + " has succefully removed!");
        } else {
            JOptionPane.showMessageDialog(null, "The Trainer with ID= " + key + " does not Exist!", "Message", JOptionPane.ERROR_MESSAGE);
        }
        database.deleteRecord(key);
    }
    
    public void logout() throws IOException
    {
        database.saveToFile();
    }
}
