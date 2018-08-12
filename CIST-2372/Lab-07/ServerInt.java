
/*************************************************************************
 *
 *      Patricia Renee Taylor
 *      CIST 2372
 *      Summer 2018
 *      Assignment #7 part 2
 *      
 * 2.) Build 2 classes, one a Client ClientInt.java that sends 5-ish integers.
 * The second, Server ServerInt.java, receives the integers and prints them 
 * to the console. Server will continue to read until receives flag of zero.
 * Test in two console windows
 *  
 **************************************************************************/

package socketprograms;
import java.io.*;
import java.net.*;

public class ServerInt   {
    
    public static void main(String[] args){
        
        try{
            //Create a Server socket
            ServerSocket ss = new ServerSocket(8001);
            
            //listen for a connection request from client
            Socket s1 = ss.accept();
            
            //returns an input stream for this socket
            InputStream is = s1.getInputStream();
            
            //
            DataInputStream dis = new DataInputStream(is);
            
            System.out.println("Server started "+"\n");
            
            while(true){
                int numberIn = dis.readInt();
                
                if (numberIn == 0){
                    System.out.println("Integer transfer complete");
                    //System.exit(1);
                    is.close();
                }
                
                System.out.println(numberIn);
            }//end while
        }catch(Exception ee){ 
            System.out.println(ee);
        }//end try/catch
    }//end main
}
