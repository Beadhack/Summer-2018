package businessobject_gui;
import java.sql.*;

/*************************************************************************
 *
 *      Patricia Renee Taylor
 *      CIST 2372 
 *      Summer 2018
 *      Assignment #5b
 *      6/20/18
 *
 * 1.)  Create a class Student. Class will be fully formed with properties,
 * setters/getters, two constructors, a display method. Add connectivity
 * to sql database. Add methods selectDB(), insertDB(), updateDB() and
 * deleteDB() which will all work with the database. Test all functionality
 * in the main() method. This class will be used by Student-GUI interface
 * program.
 * 
 **************************************************************************/
public class Student2  {
	
    Statement stmt;// make class variables so can put connection into method
    Connection con;
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
	//Creating a constructor accepting all fields on instantiation.
    public Student2(int ID, String firstN, String lastN, String strt, 
                String cty, String sta, int zCode, String emal, double gpa_avg){
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
            openConnection();
            
            String sql;
            sql = "select * from Students where ID = " + SID;
            System.out.println(sql);
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            rs.next();
                setSID(rs.getInt(1));   
                setFirstName(rs.getString(2));
                setLastName(rs.getString(3));
                setStreet(rs.getString(4));
                setCity(rs.getString(5));
                setState(rs.getString(6));
                setZip(rs.getInt(7));
                setEmail(rs.getString(8));
                setGpa(rs.getDouble(9));
                
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
            openConnection();
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
            int resultFlag = stmt.executeUpdate(sql);
            
            if(resultFlag == 1){
                System.out.println("Insert was successful.");
            }else{
                System.out.println("Insert was NOT successful.");
            }
                
            con.close();

        }catch(Exception e){
            System.out.println("pp: " + e);
        }
    }//end insertDB() method
  
//-------------Delete Method------------
  
    public void deleteDB(){
        try{
            System.out.println("Starting deleteDB............");
            openConnection();
            String sql;
            sql = "delete from Students where ID = "+getSID();											 
            System.out.println(sql);
            int resultFlag = stmt.executeUpdate(sql);
            
            if(resultFlag == 1){
                System.out.println("Delete was successful.");
            }else{
                System.out.println("Delete was NOT successful.");
            }
		
            con.close();

        }catch(Exception e){
            System.out.println("pp: " + e);
        }
    }//end deleteDB() method
  
  //-------------updateDB method---------

  public void updateDB(){
        try{
            System.out.println("Starting updateDB............");
            openConnection();
            String sql;
            sql = "update Students set ID = " +getSID()+ ", "
                                +"FirstName = '" +getFirstName()+"', "
                                +"LastName  = '" +getLastName()+"', "
                                +"Street    = '" +getStreet()+"', "
                                +"City      = '" +getCity()+"', "
                                +"State     = '" +getState()+"', "
                                +"Zip       = "  +getZip()+", "  
                                +"EMail     = '" +getEmail()+"', "
                                +"GPA       = "  +getGpa()+", ";
            System.out.println(sql);
            int resultFlag = stmt.executeUpdate(sql);
            
            if(resultFlag == 1){
                System.out.println("Insert was successful.");
            }else{
                System.out.println("Insert was NOT successful.");
            }
             
            con.close();

        }catch(Exception e){
            System.out.println("pp: " + e);
        }
    }//end updateDB() method
  
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

//-------------Connects to DB-----------
    
    public void openConnection(){
        try{
        con = 
            //    DriverManager.getConnection("jdbc:ucanaccess://C:/Use"
            //            + "rs/ptaylo14/Desktop/Java/Lab5/RegistrationDB.mdb");
                DriverManager.getConnection("jdbc:ucanaccess://C:/Users/"
                         + "prtaylor/Desktop/RegistrationMDB.mdb");  
            
        stmt = con.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }//close openConnection
    
//-------------Main Method for Testing----	
    public void main(String args[]){
	
        Student2  s1 = new Student2();  
        s1.selectDB(8);
        s1.display();         
       
        //Student2 s2=new Student2();
        //s2.insertDB(38,"Frank", "Mayer", "123 Main street", "Atlanta", "GA",
        //        +  30100, "fmayes@yahoo.com", 3.3);
       
        //Student2 s3 = new Student2();
        //s3.selectDB(38);
        //s3.deleteDB();
        
        //Student2 s4 = new Student2();
        //s4.selectDB(7);
        //s4.setZip(30107);
        //s4.updateDB();
        //System.out.println("+++++++++++++");
        //s4.display();
     
    }//end main
}//end class

