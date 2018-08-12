 
package hw_3;

/**
 * *********************************************************************
 *      Patricia Renee Taylor 
 *      CIST 2372 
 *      Summer 2018 
 *      Assignment #3a part 2
 *
 * 3.) Reading from a File – Build a class called FileRead.java. This class,
 * when instantiated, will read the text from a file and print the data to the
 * Console. main() consists of: FileRead fr = new FileRead(“myfile.txt”);
 *
 **********************************************************************
 */
import java.io.*;

public class FileRead {

    /*Constructor takes file name to read from.*/
    public FileRead(String fname) {

        File f2 = new File(fname);

        /* Interrogate f2 to see if it exists. */
        if (f2.exists()) {
            System.out.println("File exists. Have at it.");
        } else {
            System.out.println("file not found - try another file name.");
            System.exit(-1);
        }

        /* wrap i/o code in try block, catch to ioexception e. Create 
             FileInputStream object "fintput" and point it at file object f2.
         */
        try {
            FileInputStream finput = new FileInputStream(f2);

            /*Create byte array for string characters. */
            byte byteArray[] = new byte[15];

            /*Read from finput into byteArray. */
            finput.read(byteArray);

            /*Convert the byte characters in byteArray to String, then store
                them in the String object phrase, then print and close file. 
             */
            String phrase = new String(byteArray);
            System.out.println(phrase);
            finput.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }//end constructor

    public static void main(String[] args) {

        FileRead fr = new FileRead("/home/prtaylor/testOutput3.txt");

    }//end main
}//end class

