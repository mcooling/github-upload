package myPackage;

public class TimeCharOccursTest {

    public static void main(String[] args) {

        String input = ("Heather Rowena Clarke");
        char character = ('e');

        int expectedOutput = 4; //in this case the total length of the string array is 5. should fail
        int actualOutput = Calculate.timesCharOccurs(character, input);
        boolean testSuccess = actualOutput == expectedOutput;

        if(testSuccess)
        {
            System.out.println("Test Passed");
        }

        else
        {
            System.out.println("Test Failed");
            System.out.println("Expected output was: " + expectedOutput);
            System.out.println("Actual output was: " + actualOutput);
        }
    }
}
