/** *************************************************
 *	Patricia Renee Taylor
 *       CIST 2372 Summer 2018
 *	Assignment #2a part 2
 *
 * Build Account class.  The Account class should have 3 Properties:
 * Balance, Owner and AcctNo.  The Account class should have 2 constructors,
 * one that takes all 3 properties and one that takes no args(the default).
 * The Account class should have set and get methods as well as deposit
 * and withdraw methods.  Also include a display() method that outputs
 * AcctNo, Owner and Balance. Use a main() method to test out this class.
 *
 ************************************************** */
public class AccountEx {

//------------ Properties-------------
    private String acctNo;
    private String owner;
    private double balance;

//-------------Setters and Getters---------	
    public void setAcctNo(String acctNum) {
        acctNo = acctNum;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setOwner(String Ownr) {
        owner = Ownr;
    }

    public String getOwner() {
        return owner;
    }

    public void setBalance(double bal) {
        balance = bal;
    }

    public double getBalance() {
        return balance;
    }

//-------------Constructors------------   
    //Creating constructors: one empty, one full.
    public AccountEx(String acctNum, String own, double bal) {
        setAcctNo(acctNum);
        setOwner(own);
        setBalance(bal);
    }

    public AccountEx() {
        setAcctNo("");
        setOwner("");
        setBalance(0.0);
    }

    //-------------Deposit & Withdrawl methods-----   
    public void deposit(double depositAmt) {
        balance = balance + depositAmt;
    }

    public void withdraw(double withdrawAmt) throws InsufficientFunds {
        if (withdrawAmt > balance) {
            throw new InsufficientFunds();
        } else {
            balance = balance - withdrawAmt;
        }
    }

//-------------Display Method-----------	
    public void display() {
        System.out.println("Account Information");
        System.out.println("Account Number:  " + acctNo);
        System.out.println("Owner:           " + owner);
        System.out.println("Balance:         $" + balance);
    }

//-------------Main Method for Testing----	
    public static void main(String args[]) {

        AccountEx a1;
        a1 = new AccountEx("2222", "Frank", 500.00);
        a1.deposit(100.00);

        try {
            a1.withdraw(900.00);
        } catch (InsufficientFunds e) {
            System.out.println(e);
        }

        a1.display();

    }//end main
}//end class

	
