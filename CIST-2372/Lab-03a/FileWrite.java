 package hw_3;

/**
 * *********************************************************************
 *      Patricia Renee Taylor 
 *      CIST 2372 
 *      Summer 2018 
 *      Assignment #3a part 2
 *
 * 2.) Writing to a File – This time build FileWrite.java. This class, when
 * instantiated, will create a new file and write a String to the file. main()
 * has only: FileWrite fw = new FileWrite(“myfile.txt”, “Go Braves”); All other
 * code goes in the constructor.
 *
 **********************************************************************
 */
import java.io.*;

public class FileWrite {

    /*Constructor takes file name to write to, and phrase to put in file.*/
    public FileWrite(String fname, String phrase) {

        File f2 = new File(fname);

        /* intorrogate f2 to see if ok to write to */
        if (f2.exists()) {
            System.out.println("File already exists. Use another name.");
            System.exit(-1);
        } else {
            System.out.println("file not found - happy writing to the file..");
        }

        /* wrap in try block, catch to ioexception e
            Create file output stream object "foutput" and point it at file object f2*/
        try {
            FileOutputStream foutput;
            foutput = new FileOutputStream(f2);

            /*create byte array of passed in string, first check length of string*/
            int x = phrase.length();
            byte byteArray[] = new byte[x];

            /*load string object phrase into byte array*/
            byteArray = phrase.getBytes();

            /*push string in the byteArray into the foutput FileOutputStream
                 then close foutput*/
            foutput.write(byteArray);
            foutput.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }//end constructor

    public static void main(String[] args) {
        try {
            FileWrite fd;
            fd = new FileWrite("/home/prtaylor/testOutput3.txt", "Go Braves!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//end main
}//end class

