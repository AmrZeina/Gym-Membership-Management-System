/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labb4;

import java.time.LocalDate;

/**
 *
 * @author amrze
 */
public class MemberClassRegistration {
    private String memberID, classID,status;
    private LocalDate registrationDate;

    public MemberClassRegistration(String memberID, String classID, String status, LocalDate registrationDate) {
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.registrationDate = registrationDate;
    }
    
    public String getMemberID () 
    {
        return memberID;
    }
    
    public String getClassID () 
    {
        return classID;
    }
    public LocalDate getRegistrationDate () 
    {
        return registrationDate;
    }
    public String getSearchKey ()
    {
        return memberID+classID;
    }
    public String lineRepresentation ()
    {
        return memberID+","+classID+","+registrationDate+","+status;
    }
  
        
}
