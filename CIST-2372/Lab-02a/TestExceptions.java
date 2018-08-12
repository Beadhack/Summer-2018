package CIST2372HomeWork_nx;

/**********************************************************************
 * Patricia Renee Taylor CIST 2372 Summer 2018 Assignment #2a
 *
 * 1.)	Build a class with the given code in the main method.
 *
 * Compile and run this class. What happens? Now add try/catch blocks to catch
 * these exceptions? Is there another way that you can prevent a run-time error
 * without using try-catch blocks?
 *
 *********************************************************************/
public class TestExceptions {

    public static void main(String args[]) {

        int[] myArr = new int[10];
        int x, y, z;
        x = 0;
        y = 10;
        z = 0;

        try {
            z = y / x;
            myArr[10] = 0;
            System.out.println("result: " + z);
        } catch (ArithmeticException ea) {
            System.out.println("an integer can't be divided by zero");
        } catch (ArrayIndexOutOfBoundsException eo) {
            System.out.println("must use array index within bounds");
        }

        System.out.println("Having fun yet?");

    }//end of main
}
