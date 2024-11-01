package lab4;

import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

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
        memberDatabase.insertRecord(M);
    }

    public ArrayList<Member> getListOfMembers() {
        return memberDatabase.returnAllRecords();
    }

    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class C = new Class(classID, className, trainerID, duration, maxParticipants);
        classDatabase.insertRecord(C);
    }

    public ArrayList<Class> getListOfClasses() {
        return classDatabase.returnAllRecords();
    }

    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        Class targetClass = classDatabase.getRecord(classID);
        if (targetClass != null && targetClass.getAvailableSeats() > 0) {
            MemberClassRegistration registration = new MemberClassRegistration(memberID, classID, "active", registrationDate);
            registrationDatabase.insertRecord(registration);
            targetClass.setAvailableSeats(targetClass.getAvailableSeats() - 1);
            return true;
        }
        return false;
    }

    public boolean cancelRegistration(String memberID, String classID) {
    MemberClassRegistration registration = registrationDatabase.getRecord(memberID + classID);
        if (registration != null && !registration.getRegistrationStatus().equals("canceled") &&
            ChronoUnit.DAYS.between(registration.getRegistrationDate(), LocalDate.now()) <= 3) {
            
            registration.setRegistrationStatus("canceled");
            Class targetClass = classDatabase.getRecord(classID);
            if (targetClass != null) {
                targetClass.setAvailableSeats(targetClass.getAvailableSeats() + 1);
            }
            return true;
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
