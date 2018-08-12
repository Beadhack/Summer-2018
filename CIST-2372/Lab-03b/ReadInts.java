package hw_3;


/**********************************************************************
 *      Patricia Renee Taylor 
 *      CIST 2372 
 *      Summer 2018 
 *      Assignment #3b part 2
 *
 * 2.) Read Integers from a File – This time build a class ReadInts. This class,
 * when instantiated, will read the integers from the file given, and print them
 * to the Console. All the code to write the data to the file goes in the
 * Constructor. This code goes in main() ReadInts ri = new
 * ReadInts(“mydata.dat”);
 *
 * *********************************************************************/
import java.io.*;

public class ReadInts {

    /*constructor - receives file fname passed in from main()*/
    public ReadInts(String fname) {
        
        /*Assign object name f1 using File, check to see if exists. If yes
           then go ahead, if not then exit program.
        */    
        File f1 = new File(fname);
        if (f1.exists()) {
            System.out.println("File exists, go ahead and read.");
        } else {
            System.out.println("file not found ");
            System.exit(-1);
        }
        
        /*Try block holds file i/o, catch block throws IOException if 
           triggered. Put File object f1 into FileInputStream object fin, hand fin
            to DataInputStream object dsin.
        */
        try {
            FileInputStream fin = new FileInputStream(f1);
            DataInputStream dsin = new DataInputStream(fin);

            /*Read array of integers from file using for loop, print them to
                console. 0 is sentinal end, causing break to exit loop.
            */
            int x;
            do {
                x = dsin.readInt();
                if (x == 0) {
                    break;
                }
                System.out.println(x);
            } while (true);
            
            /* Close FileInputStream fin. */
            fin.close();

        }//end try
        catch (IOException e) {
            System.out.println(e);
        }//end catch

    }//end constructor

    /*main() calls constructor ReadInts and passes file name to read.  */
    public static void main(String[] args) {

        ReadInts ri;
        ri = new ReadInts("/home/prtaylor/testInt1.txt");

    }//end main
}//end class

