
import java.sql.*;
/*
 *********************************************************************
 *      Patricia Renee Taylor 
 *      CIST 2372 
 *      Summer 2018 
 *      Assignment #5b Part 2
 *
 * 2.)	Modify the Student class from part 1. Add a mew method called
 * selectDB() that takes only one argument, SID. When a user calls this
 * method, it should SELECT from the database that Student and get all
 * the Student's data from the database, and put this daa into the 
 * appropreate properties. (Hint: You will use an SQL Select statement
 * here.) Test out this method in the main.
 *
 * ********************************************************************
*/


public class Student2  {
	
//------------ Properties-------------
    private int    SID;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int    zip;
    private String email;
    private double gpa;
	
//-------------Constructors----------------
	//Creating a constructor which will accept all the fields on instantiation.
    public Student2(int ID, String firstN, String lastN, String strt, String cty, String sta, int zCode, String emal, double gpa_avg){
        setSID(ID);
        setFirstName(firstN);
        setLastName(lastN);
        setStreet(strt);
        setCity(cty);
        setState(sta);
        setZip(zCode);
        setEmail(emal);
        setGpa(gpa_avg);
        
    }
    //Constructor which sets values to empty strings and zeros.
    public Student2(){
        setSID(0);
        setFirstName("");
        setLastName("");
        setStreet("");
        setCity("");
        setState("");
        setZip(0);
        setEmail("");
        setGpa(0.0);
    }
//-------------Setters and Getters---------

    public void setSID(int StID){
    	SID = StID; }
    public int getSID(){
        return SID; }
	
    public void setFirstName(String fName){
    	firstName = fName; }
    public String getFirstName() {
    	return firstName; }
    
    public void setLastName(String lName){
    	lastName = lName; }
    public String getLastName() {
    	return lastName; }
    
    public void setStreet(String strt){
    	street = strt; }
    public String getStreet() {
    	return street; }
    
    public void setCity(String cty){
    	city = cty; }
    public String getCity() {
    	return city; }
    
    public void setState(String sta){
    	state = sta; }
    public String getState() {
    	return state; }
    
    public void setZip(int zCode){
    	zip = zCode; }
    public double getZip() {
    	return zip; }
    
    public void setEmail(String em){
    	email = em; }
    public String getEmail() {
    	return email; }
    
    public void setGpa(double gp){
    	gpa = gp; }
    public double getGpa() {
    	return gpa; }
    
//-------------selectDB method---------

  public void selectDB(int SID){
        try{
            System.out.println("Starting DB Tester............");
            
                //Load Driver - Step #1
            Connection con=
            //    DriverManager.getConnection("jdbc:ucanaccess://C:/Use"
            //            + "rs/ptaylo14/Desktop/Java/Lab5/RegistrationDB.mdb");
                DriverManager.getConnection("jdbc:ucanaccess://C:/Users/"
                         + "prtaylor/Desktop/RegistrationMDB.mdb");  
            
                //Create Statement - Step #3
            Statement stmt = con.createStatement();
            
                //  Execute Statement - Step #4
            String sql;
            sql = "select * from Students where ID = " + SID;
            System.out.println(sql);
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            rs.next();
            
                //Process Data - Step #5
            
                setSID(rs.getInt(1));   
                setFirstName(rs.getString(2));
                setLastName(rs.getString(3));
                setStreet(rs.getString(4));
                setCity(rs.getString(5));
                setState(rs.getString(6));
                setZip(rs.getInt(7));
                setEmail(rs.getString(8));
                setGpa(rs.getDouble(9));
                //Close Connection - Step #6
                con.close();
            
        }catch(Exception e){
            System.out.println("pp: " + e);
        }
    }//end selectDB() method   
  
  //-------------insertDB method---------

  public void insertDB(int SID, String fName,   String lName, 
                        String street,  String city,   String state, 
			int zip,   String eMail,   Double gpa){
        try{
            System.out.println("Starting insertDB............");

                //Load Driver - Step #1
            Connection con=
                DriverManager.getConnection("jdbc:ucanaccess://C:/Users/"
                         + "prtaylor/Desktop/RegistrationMDB.mdb");

                //Create Statement - Step #3
            Statement stmt = con.createStatement();

                //  Execute Statement - Step #4
            String sql;
            sql = "insert into Students values("+SID+",'"
                                                +fName+"','"
                                                +lName+"','"
                                                +street+"','"
                                                +city+"','"
                                                +state+"',"
                                                +zip+",'"
                                                +eMail+"','"
                                                +gpa+"')";
            System.out.println(sql);
            int resultFlag; //integer returned on completion of update - should be number of lines worked on
            resultFlag = stmt.executeUpdate(sql);
            System.out.println("code returned from insertDB() is: " + resultFlag);
            
                //Close Connection - Step #6
                con.close();

        }catch(Exception e){
            System.out.println("pp: " + e);
        }
    }//end insertDB() method
  
//-------------Delete Method------------
  
  public void deleteDB(){
        try{
            System.out.println("Starting deleteDB............");

                //Load Driver - Step #1
            Connection con=
                DriverManager.getConnection("jdbc:ucanaccess://C:/Users/"
                         + "prtaylor/Desktop/RegistrationMDB.mdb");

                //Create Statement - Step #3
            Statement stmt = con.createStatement();

                //  Execute Statement - Step #4
            String sql;
            sql = "delete from Students where ID = "+getSID();
																			 
            System.out.println(sql);
            int resultFlag; //integer returned on completion of update - should be number of lines worked on
            resultFlag = stmt.executeUpdate(sql);
            System.out.println("result flag from delete is " + resultFlag);
			
                //Close Connection - Step #6
                con.close();

        }catch(Exception e){
            System.out.println("pp: " + e);
        }
    }//end deleteDB() method
 
  
//-------------Display Method-----------
        
    public void display(){
	System.out.println("Student ID: " + SID);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name:  " + lastName);
        System.out.println("Street:     " + street);
        System.out.println("City:       " + city);
        System.out.println("State:      " + state);
	System.out.println("Zip Code:   " + zip);
        System.out.println("Email:      " + email);
	System.out.println("GPA:        " + gpa);
	System.out.println(" ");
    }//end display()

	
//-------------Main Method for Testing----	
    public static void main(String args[]){
	
        //Student2  s1 = new Student2();  
        //s1.selectDB(4);
        //s1.display();          //displays all data from DB for student with id=4
       
        //Student2 s2=new Student2();
        //s2.insertDB(35,"Frank", "Mayer", "123 Main street", "Atlanta", "GA",
        //        +  30100, "fmayes@yahoo.com", 3.3);
       
        Student2 s3 = new Student2();
        s3.selectDB(35);
        s3.deleteDB();
     
    }//end main
}//end class


