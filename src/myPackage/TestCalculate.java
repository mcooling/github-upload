package myPackage;

public class TestCalculate {

    public static void main(String[] args) {

        String calcString = "Test string used for Calculate class";
        Calculate testCalc = new Calculate(calcString);
        System.out.println(testCalc.toString());
    }
}
