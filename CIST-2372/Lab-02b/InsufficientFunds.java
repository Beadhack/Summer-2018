
/** *************************************************
 *	Patricia Renee Taylor
 *       CIST 2372 Summer 2018
 *	Assignment #2b part 2
 *
 * 1.) Build an InsufficientFundsException class. Create a new File called
 * “InsufficientFunds.java”. Have this class extend from the Exception class.
 * Also add to your Account class.  Make it so that when the withdraw method
 * attempt to set the balance below zero(the withdraw() method is called,
 * and the amount the user is trying to withdraw is greater than the available
 * balance), the InsufficientFundsException will be thrown.
 *
 *2.) Lastly, in your Account class’s main method, use try-catch blocks to
 * catch this InsufficientFundsException when you call the withdraw() method.
 *
 *If you try to withdraw more than the available balance, do we still get
 * a run-time error??
 *
 ************************************************** */
public class InsufficientFunds extends Exception {

    public String msg = "   >>>***>>>   Insuffecient Funds";

    public String toString() {
        return msg;
    }
}//end class

		
