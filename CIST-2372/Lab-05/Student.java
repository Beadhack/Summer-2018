package DBTester;
/*
 *********************************************************************
 *      Patricia Renee Taylor 
 *      CIST 2372 
 *      Summer 2018 
 *      Assignment #5b 
 *
 * 1.)	Creat class Student. Class will not be tied to Database, yet.
 * The Student class should have the same properties as the Database table:
 * SID, FirstName, LastName, etc. Include all the set and get methods as
 * needed. Include 2 constructors, an empty constructor, and one that takes
 * all properties. Include a display() method that prints out all properties.
 * Use a main() to instantiate and test out this Student class. No DB calls.
 *
 * ********************************************************************
*/


public class Student  {
	
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
    public Student(int ID, String firstN, String lastN, String strt, String cty, String sta, int zCode, String emal, double gpa_avg){
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
    public Student(){
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
    }
	
//-------------Main Method for Testing----	
    public static void main(String args[]){
		
	Student s1;
	s1 = new Student();
        
	Student e1;
	e1 = new Student(900441030,"Katherine", "Taylor","Cherokee St", 
                 "Marietta", "Georgia", 30067, "ktaylo@gmail.com",4.0);
	e1.display();
		
    }//end main
}//end class



