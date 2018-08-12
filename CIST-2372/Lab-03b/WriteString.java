 

/**
 * *********************************************************************
 *      Patricia Renee Taylor 
 *      CIST 2372 
 *      Summer 2018 
 *      Assignment #3b part 3
 *
 * 3.) Write a String to a File using PrintStream – Build a class WriteString.
 * This class, when instantiated, will write a string to a file by using a 
 * PrintStream object connected to a FileOutputStream Object.
 * 
 * main() code should be:
 *    WriteString ws = new WriteString(“f1.txt”,“Hello world”);
 *
 * *********************************************************************
 */
import java.io.*;

public class WriteString {

    /*Constructor - Receives file fname to send string to, 
        and String phrase to put in file.
    */
    public WriteString(String fname, String phrase) {

        /*Assign object name f3 using File, check to see if exists. If yes
           then exit program, if not then continue.
        */   
        File f3 = new File(fname);
        if (f3.exists()) {
            System.out.println("File exists, pick a new file name.");
            System.exit(42);
        } else {
            System.out.println("file not found - proceeding");
        }
        
        /*Try block holds file i/o, catch block throws IOException if triggered. 
            Put File object f3 into FileOutputStream object fout, and fout
            to PrintStream object ps.
        */
        try {
            FileOutputStream fout = new FileOutputStream(f3);
            PrintStream ps = new PrintStream(fout);

            /* Write passed-in object phrase to file using println method. */
            ps.println(phrase);
           
            fout.close();
            
        }//end try
        catch (IOException e) {
            System.out.println(e);
        }//end catch
        
    }//end constructor

    public static void main(String[] args) {
        
        WriteString ws = new WriteString("/home/prtaylor/testWS1.txt",
                "Hello World");
      
    }//end main
}//end class

