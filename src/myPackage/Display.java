package myPackage;

public class Display

{
    //declare private variables
    private int [] intArrayIn;
    private char [] alphabetArrayIn;

    public Display(int [] reqIntArray, char [] reqAlphabetArray) {
        intArrayIn = reqIntArray;
        alphabetArrayIn = reqAlphabetArray;
    }

    //create constructor
    public void DisplayOutput()
    {
        int largestNumber = 0;
        for (int i = 0; i < intArrayIn.length; i++) {
            if (intArrayIn[i] > largestNumber) {
                largestNumber = intArrayIn[i];
            }
        }

        //loop back through the array, checking the largest number each time
        //create an inner loop to print each time each letter features

        for (int i = largestNumber; i > 0; i--) {
            //add conditional statement to format the column
            //adds a space to ensure numbers 1-9 are aligned
            //this does place an upper limit of 99 though, before it goes out of line again

            //***REMOVE THE 99 LINE COMMENT. ADD INTO THE REPORT INSTEAD***

            if (i < 10) {
                System.out.print(" ");
            }
            System.out.print(i);
            System.out.print(" "); //column spacing

            //inner loop to add a star each time char occurs
            for (int j = 0; j < intArrayIn.length; j++) {
                if (intArrayIn[j] >= i) {
                    System.out.print("*");
                } else
                    System.out.print(" "); //adds a space where no char occurs
                System.out.print(" "); //column spacing
            }
            System.out.println();
        }

        //create a loop to print the character under each column
        System.out.print("   "); //initial column spacing
        for (int i = 0; i < alphabetArrayIn.length; i++) {
            System.out.print(alphabetArrayIn[i]);
            System.out.print(" "); //column spacing
        }
        System.out.println();

        //the commented code below has been left in
        //can be used if we want to display the bar chart horizontally
        //may choose to switch, depending on whether the x or y axis is greater

		/*for(int i = 0; i < 26; i++) //loops through every character of the string passed in
			{
				if(intArray[i] > 0)
				{
					System.out.print("Char " + alphabetArray[i] + ": ");
					String stars = "";
					int counter = 0;

					for (int j = 0; j < intArray[i]; j++)
					{
						stars = stars + "*";
						counter++;
					}
					System.out.println(stars + " (" + counter + ")");
				}
			}*/
    }

    //create getter methods
    public int[] getIntArray() {
        return intArrayIn;
    }

    public char[] getAlphabetArray() {
        return alphabetArrayIn;
    }

    //add toString to test
    public String toString()
    {
        System.out.println();
        return "The int array value is " + getIntArray() + " and the alphabet array value is " +
                getAlphabetArray();
    }
}
