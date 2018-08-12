/*
 *********************************************************************
 *      Patricia Renee Taylor 
 *      CIST 2372 
 *      Summer 2018 
 *      Assignment #5 
 *
 * 1.)	Build a simple class - has only one method, main(). Read in all
 * of the rows of data from the Instructors Table in the REgistration Database,
 * then print out this datas. Follow the steps outlined in class. Use try-catch
 * blocks for all database access code.
 *
 * ********************************************************************
*/
package DBTester;
import java.sql.*;
/**
 *
 * @author ptaylo14
 */
public class DBTester {
    public static void main(String[] args){
        try{
            System.out.println("Starting DB Tester............");
                //Load Driver - Step #1
            Connection con=
                DriverManager.getConnection("jdbc:ucanaccess://C:/Use"
                        + "rs/ptaylo14/Desktop/Java/Lab5/RegistrationDB.mdb");
            
                //Create Statement - Step #3
            Statement stmt = con.createStatement();
            
                //  Execute Statement - Step #4
            String sql;
            sql = "select * from Instructors";
            System.out.println(sql);
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
                //Process Data - Step #5
            while (rs.next()){
                System.out.println("\n" + "ID:         " + rs.getString(1));
                System.out.println("FirstName:  " + rs.getString(2));
                System.out.println("LastName:   " + rs.getString(3));
                System.out.println("Street:     " + rs.getString(4));
                System.out.println("City:       " + rs.getString(5));
                System.out.println("State:      " + rs.getString(6));
                System.out.println("ZipCode:    " + rs.getInt(7));
                System.out.println("Office:     " + rs.getString(8));
                System.out.println("Email:      " + rs.getString(9));
            }    
                //Close Connection - Step #6
                con.close();
            
        }catch(Exception e){
            System.out.println("pp: " + e);
        }
    }//end main
}//end class
