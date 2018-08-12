

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
import java.util.Scanner;

public class ClientInt {
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int intnum = 1;
        
        try{
            //create socket object s1, connected to port 8001
            Socket s1 = new Socket("localhost", 8001);
            //create outgoing stream for data using s1 socket
            DataOutputStream dos =  new DataOutputStream(s1.getOutputStream());
            
            System.out.println("client Started "+"\n");
            
            while (intnum != 0){
            
                System.out.println("Please enter a non-zero integer, "
                                            + "or enter zero to quit: ");
                //read integer from user
                intnum = input.nextInt();
                
                //send output to pout printstream, which sends to s1 socket
                dos.writeInt(intnum);
            }//end while
            dos.close();
        }catch(Exception ee){ 
            System.out.println(ee);
        }//end try/catch
    }//end main

}//end class
