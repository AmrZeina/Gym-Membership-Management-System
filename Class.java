/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labb4;

/**
 *
 * @author amrze
 */
public class Class {
    private String classID,className,trainerID;
    private int duration,availableSeats;
    
    public int getAvailableSeats ()
    {
        return availableSeats;
    }
    
    public void setAvailableSeats (int availableSeats) 
    {
        this.availableSeats=availableSeats;
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
