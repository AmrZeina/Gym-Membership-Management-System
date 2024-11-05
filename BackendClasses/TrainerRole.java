package BackendClasses;

import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TrainerRole {

    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;

    public TrainerRole() throws FileNotFoundException {
        this.memberDatabase = new MemberDatabase("Members.txt");
        this.classDatabase = new ClassDatabase("Classes.txt");
        this.registrationDatabase = new MemberClassRegistrationDatabase("Registrations.txt");
    }

    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        Member M = new Member(memberID, name, membershipType, email, phoneNumber, status);
        if (memberDatabase.insertRecord(M)) {
            JOptionPane.showMessageDialog(null, "The member with ID= " + memberID + " has succefully added!");
        } else {
            JOptionPane.showMessageDialog(null, "The member with ID= " + memberID + " Already Exists!", "Message", JOptionPane.ERROR_MESSAGE);
        }

    }

    public ArrayList<Member> getListOfMembers() {
        return memberDatabase.returnAllRecords();
    }

    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class C = new Class(classID, className, trainerID, duration, maxParticipants);
        if (classDatabase.insertRecord(C)) {
            JOptionPane.showMessageDialog(null, "The class with ID= " + classID + " has succefully added!");
        } else {
            JOptionPane.showMessageDialog(null, "The class with ID= " + classID + " Already Exists!", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Class> getListOfClasses() {
        return classDatabase.returnAllRecords();
    }

    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        if (classDatabase.getRecord(classID) != null && classDatabase.getRecord(classID).getAvailableSeats() == 0) {
            JOptionPane.showMessageDialog(null, "Class has no available seats", "Message", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (registrationDatabase.contains(memberID + classID)) {
            JOptionPane.showMessageDialog(null, "This member is already registered to this class");
            return false;
        }
        if (memberDatabase.contains(memberID) && classDatabase.getRecord(classID) != null && classDatabase.getRecord(classID).getAvailableSeats() > 0) {
            MemberClassRegistration registration = new MemberClassRegistration(memberID, classID, "active", registrationDate);
            registrationDatabase.insertRecord(registration);
            classDatabase.getRecord(classID).setAvailableSeats(classDatabase.getRecord(classID).getAvailableSeats() - 1);
            JOptionPane.showMessageDialog(null, "The member with ID= " + memberID + " has succefully registered to class= " + classID);
            return true;
        }  
        else if (!memberDatabase.contains(memberID)) {
                JOptionPane.showMessageDialog(null, "The member with ID= " + memberID + " does not exist");
            }
        else if (!classDatabase.contains(classID)) {
                JOptionPane.showMessageDialog(null, "The class with ID= " + classID + " does not exist");
            }
        return false;
    }

    public boolean cancelRegistration(String memberID, String classID) {
        MemberClassRegistration registration = registrationDatabase.getRecord(memberID + classID);
        if (registration != null && !registration.getRegistrationStatus().equals("canceled")
                && ChronoUnit.DAYS.between(registration.getRegistrationDate(), LocalDate.now()) <= 3) {

            registration.setRegistrationStatus("canceled");
            registrationDatabase.deleteRecordsByClassID(classID);
            Class targetClass = classDatabase.getRecord(classID);
            if (targetClass != null) {
                targetClass.setAvailableSeats(targetClass.getAvailableSeats() + 1);
            }
            registrationDatabase.deleteRecordsByClassID(classID);
            JOptionPane.showMessageDialog(null, "The member with ID= " + memberID + " has been unregistered from class= " + classID);
            return true;
        }
        if (registration != null && registration.getRegistrationStatus().equals("canceled")) {
            JOptionPane.showMessageDialog(null, "Registration is already canceled!", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Registration does not exist!");
        }

        return false;
    }

    public ArrayList<MemberClassRegistration> getListOfRegistrations() {
        return registrationDatabase.returnAllRecords();
    }

    public void removeClass(String classID) {
        classDatabase.deleteRecord(classID);
        registrationDatabase.deleteRecordsByClassID(classID); // Add method to delete registrations for specific classID
    }

    public void logout() throws IOException {
        registrationDatabase.saveToFile();
        classDatabase.saveToFile();
        memberDatabase.saveToFile();
    }
}
