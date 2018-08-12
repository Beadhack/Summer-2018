
/*
 *********************************************************************
 *      Patricia Renee Taylor 
 *      CIST 2372 
 *      Summer 2018 
 *      Assignment #4 part 1
 *
 * 1.)	Write an Application that extends the Thread class, call it 
 * MyThread.java.  Have your new class accept an integer(i.e. 200) when 
 * it is instantiated.  (MyThread mt = new MyThread(200); )
 * This integer number will be the number of times that this class loops 
 * and prints a message.  The message should read "thread Running-200
 * The 200 would be whatever number is passed into the constructor.
 * If the number was 300, then output should read “ Thread Running-300
 * Use a main method to test this class.  In the main start 2 Threads, 
 * one Thread with 250 and one Thread with 300.  What happens?  
 * You do not need to use the sleep() method for this exercise.
 *
 * ********************************************************************
*/

public class MyThread extends Thread {
    int count = 0;
    int x = 0;
	
    /*Constructor - receives number of times to print count.*/
    public MyThread(int x) {
	count = x;
    }
    
    /*Run method which gives instructions for seperate thread. */
    public void run(){
        for (int i = 0; i <= count; i++){
            System.out.println("Thread running_x " + count);
        }
    }        
        
    /*main() calls constructor MyThread passing # times to print, then start
        thread. Run two threads.  */
    public static void main(String[] args) {
		
        MyThread mt1 = new MyThread(200);
        mt1.start();
        MyThread mt2 = new MyThread(300);
        mt2.start();
    }//end main
}//end class

