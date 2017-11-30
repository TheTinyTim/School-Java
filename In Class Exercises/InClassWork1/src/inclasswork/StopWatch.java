/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclasswork;

/**
 *
 * @author ni0784722
 */
public class StopWatch {
    
    private long startTime;
    
    public long getStartTime () { return startTime; } 
    
    private long endTime;
    
    public long getEndTime () { return endTime; }
    
    public StopWatch ()
    {
        //Set the start time with the current system time
        startTime = getCurrentTime();
    }
    
    public void start ()
    {
        //Reset the stop watch with the current time
        startTime = getCurrentTime();
    }
    
    public void stop ()
    {
        //Set the end time to the current system time
        endTime = getCurrentTime();
    }
    
    public double getElapsedTime ()
    {
        //Get the elapsed time by subtracting the end time by the start time and divide by 1000 to get the time in seconds
        return (endTime - startTime) / 1000d;
    }
    
    //Get the current system time
    public long getCurrentTime (){ return System.currentTimeMillis(); }
    
}
