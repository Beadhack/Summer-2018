/*************************************************************************
 *
 *      Patricia Renee Taylor
 *      CIST 2372
 *      Summer 2018
 *      Assignment #7 part 1
 *      
 *
 * 1.)  Build 2 classes, ServerString.java that sends a single String message
 * and the second a Client ClientString.java, that receives the message and
 * prints it to the Console. Program works in Dos Windows, having 2 open
 * two run the program. Test on local machine, then use two separate machines.
 *  
 **************************************************************************/

package socketprograms;
import java.io.*;
import java.net.*;

public class ClientString   {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        
        try{
            //create socket object s1, connected to port 8000
            Socket s1 = new Socket("localhost", 8000);
            
            //create outgoing stream PrintStream using s1 socket
            PrintStream pout =  new PrintStream(s1.getOutputStream());
            
            System.out.println("client Started "+"\n");
            
            //send output to pout printstream, which sends to s1 socket
            pout.println("Go Braves - Get the pennant!");
            
            
        }catch(Exception ee){ 
            System.out.println(ee);
            System.out.println("Error n socketSetup()");
        }//end try/catch
    }//end main



}
