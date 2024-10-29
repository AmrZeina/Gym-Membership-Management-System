/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labb4;


public class Class {
    private String classID,className,trainerID;
    private int duration,availableSeats;

    public Class(String classID, String className, String trainerID, int duration, int availableSeats) {
        this.classID = classID;
        this.className = className;
        this.trainerID = trainerID;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }
   
    public int getAvailableSeats ()
    {
        return availableSeats;
    }
    
    public void setAvailableSeats (int availableSeats) 
    {
        if(availableSeats>0)
        this.availableSeats=availableSeats;
        else
            System.out.println("Number of seats invalid!");
    }
    
    public String lineRepresentation () 
    {
        return classID+","+className+","+trainerID+","+duration+","+availableSeats;
    }
    
    public String getSearchKey () 
    {
        return classID;
    }
        
        
    
}
