
/*
 *********************************************************************
 *      Patricia Renee Taylor 
 *      CIST 2372 
 *      Summer 2018 
 *      Assignment #4 part 3
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

 * 2.)	Modify the above.  Change this class to use the Runnable Interface 
 * instead of the Thread class.  Any difference how the code runs?
 *
 * 3.)	Lastly, have the main method start 4 different threads, all with 
 * different loop counts.  Test the application, what happens? 
 *
 * ********************************************************************
*/

public class MyThread2 implements Runnable {
    int count = 0;
    int x = 0;
	
    /*Constructor - receives number of times to print count.*/
    public MyThread2(int x) {
	count = x;
    }
    
    /*Run method which gives instructions for seperate thread. */
    public void run(){
        for (int i = 0; i <= count; i++){
            System.out.println("Thread running_" + x + " " + count);
        }
    }        
        
    /*main() calls constructor MyThread passing # times to print, then start
        thread. Run two threads.  */
    public static void main(String[] args) {
		
        MyThread2 mt1 = new MyThread2(220);
        Thread t1 = new Thread(mt1);
        t1.start();
            MyThread2 mt2 = new MyThread2(240);
            Thread t2 = new Thread(mt2);
            t2.start();
        MyThread2 mt3 = new MyThread2(260);
        Thread t3 = new Thread(mt3);
        t3.start();
            MyThread2 mt4 = new MyThread2(280);
            Thread t4 = new Thread(mt4);
            t4.start();
        
    }//end main
}//end class

