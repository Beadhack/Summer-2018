package hw_3;


/** *********************************************************************
 *	Patricia Renee Taylor
 *      CIST 2372 Summer 2018
 *	Assignment #3a part 1
 *
 * 1.) – Build a class called FileDetails.java.  When you instantiate this class
 * and give it a filename, it will report back the size of the file, whether
 * the file is Readable and whether the file is Writable; plus any other file
 * information that you might deem important. Bulk of code goes into the
 * constructor.
 * Only code in main() is FileDetails fd=newFileDetails( );
 *
 ********************************************************************** */
import java.io.*;

public class FileDetails {

    //constructor
    public FileDetails(String fname) {

        File f1 = new File(fname);
        if (f1.exists()) {
            System.out.println("file exists");
        } else {
            System.out.println("file not found");
            System.exit(1);
        }
        System.out.println("file length: " + f1.length());
        System.out.println("file can be read: " + f1.canRead());
        System.out.println("file can be written: " + f1.canWrite());
        System.out.println("file path is: " + f1.getPath());
    }//end constructor

    public static void main(String[] args) {
        try {
            FileDetails fd;
            fd = new FileDetails("/home/prtaylor/Documents/test.txt");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//end main
}//end class

