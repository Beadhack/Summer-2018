package hw_3;

/**
 * *********************************************************************
 *      Patricia Renee Taylor 
 *      CIST 2372 
 *      Summer 2018 
 *      Assignment #3b part 1
 *
 * 1.) – Write Integers to a File. This class, when instantiated, will create a
 * new file and write an array of integers to this new file. All the code to
 * write the data to the file goes in the Constructor. This code goes in main()
 * - int myArr[] = {16, 31, 90, 45, 89}; WriteInts wi = new
 * WriteInts(“mydata.dat”, myArr);
 *
 * *********************************************************************
 */
import java.io.*;

public class WriteInts {

    /*constructor - receives file fname and array intArray to write to file*/
    public WriteInts(String fname, int[] intArray) {

        /*Assign object name f1 using File, check to see if exists. If yes
           then exit program, if not then continue.
        */   
        File f1 = new File(fname);
        if (f1.exists()) {
            System.out.println("File exists, pick a new file name.");
            System.exit(42);
        } else {
            System.out.println("file not found - proceeding");
        }
        
        /*Try block holds file i/o, catch block throws IOException if triggered. 
            Put File object f1 into FileOutputStream object fout, hand fout
            to DataOutputStream object dsout.
        */
        try {
            FileOutputStream fout = new FileOutputStream(f1);
            DataOutputStream dsout = new DataOutputStream(fout);

            /* Write array of integers to file using for loop. */
            for (int i = 0; i < 5; i++) {
                dsout.writeInt(intArray[i]);
            }
            /* Add zero as last number for a sentinal to end of data. */
            dsout.writeInt(0);
            fout.close();
            
            
        }//end try
        catch (IOException e) {
            System.out.println(e);
        }//end catch
        
    }//end constructor

    public static void main(String[] args) {

        int myArr[] = {16, 31, 90, 45, 89};
        WriteInts wi = new WriteInts("/home/prtaylor/testInt4.txt", myArr);

    }//end main
}//end class

