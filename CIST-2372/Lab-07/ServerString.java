

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

public class ServerString   {
    
    
    public static void main(String[] args){
        
        try{
            //Create a Server socket
            ServerSocket ss = new ServerSocket(8000);
            
            //listen for a connection request on ss object
            Socket s1 = ss.accept();
            
            //returns an input stream for this socket
            InputStream is = s1.getInputStream();
            
            //isr is  bridge from byte streams to character streams
            InputStreamReader isr = new InputStreamReader(is);
            
            //reads text from a character-input stream, buffering characters
            BufferedReader br = new BufferedReader(isr);
            
            System.out.println("Server started "+"\n");
            String str = null;
            str = br.readLine();
            System.out.println("Client String = " + str);
            
            
        }catch(Exception ee){ 
            System.out.println(ee);
        }//end try/catch
    }//end main
}
