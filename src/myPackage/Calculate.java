package myPackage;

public class Calculate

/*
 * ADDED THIS TEST LINE FOR GIHUB BRANCHING
 *
 * PSEUDOCODE, for calculate class behaviour
 * Called by main method
 * LABS 5/6, METHODS
 * LAB 7, ARRAYS (Letter Frequencies & Text Processing)
 * LABS 10/11, OBJECTS & CLASSES
 *
 * 1. ACCEPT STRING CONTENT PASSED FROM MAIN METHOD
 * 2. PERFORM ANALYTICS ON THE CONTENT
 * 3. DISPLAY THE OUTPUT GRAPHICALLY
 *
 * ACCEPT STRING CONTENT PASSED FROM MAIN METHOD
 * All inputs passed in as a string
 * Either from text entered manually, or read in from files
 *
 * PERFORM ANALYTICS ON THE CONTENT
 *
 * ***NEED TO COME BACK TO THIS. STILL NOT CLEAR IN MY HEAD***
 *
 * Calculate the frequency of each character in the string
 * Cater for both upper and lower case characters
 * Create a string array to store each character to be included in the analysis
 * Create an integer array to store the number of times each character is included in the string
 *
 * DISPLAY THE OUTPUT GRAPHICALLY
 * Loop through the intArray to find the largest number
 * Loop back through the array, decrementing from largest number to 0
 * Inner loop to print '*' each time each letter features
 * Add loops to print the x (char) & y (number) axis values for each column
 */

{
	//create global variables, for access by each method

	int[] intArray; //integer array, used in character frequency and display methods
    private String stringIn; //stores full string, passed from main method

    //to store each of the characters included in the analysis
	private static char[] alphabetArray = new char[]
			{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
					'r','s','t','u','v','w','x','y','z'};
    
    //create class constructor, to take the string passed from main method

    public Calculate(String reqString) {
    	stringIn = reqString;
    }

    //create method to conduct the analysis
	//instantiate a new object in the Display class
    public void Results() {
		intArray = charFrequency(stringIn);
		Display myDisplay = new Display(intArray, alphabetArray);
		myDisplay.DisplayOutput();
	}

	//add method to check how many times each character in the string occurs

    public static int [] charFrequency(String input) //takes in the full string
	{
		int[] intArray = new int[26]; //stores output from intArray for loop

		for(int i = 0; i < alphabetArray.length; i++) //loops through the alphabet array above
			{
				intArray[i] = timesCharOccurs(alphabetArray[i], input);
				//calls timesCharOccurs method, pass alphabet array value and full string
			}
		return intArray; //passes int array value back to method call
	}
    
    public static int timesCharOccurs(char searchCharacter, String input) 
    //called by charFrequency method above
    //takes 'alphabetArray[i]' from each loop and full string
	{
	//use .toCharArray() library method to convert string into an array
		char [] stringArray = input.toCharArray();
		int counter = 0;
		//loop count, each time stringArray value matches alphabetArray value
		for (int i = 0; i < stringArray.length; i++)
			{
				if(stringArray[i] == searchCharacter || stringArray[i] == Character.toUpperCase(searchCharacter))
				{
					counter ++; //increase counter by 1 if there's a character match
				}
			}
		return counter; //returns counter to charFrequency method
    }

	//add a toString, method, used by the TestCalculate class
	public String toString() {
    	return "Test string has name: " + stringIn;
	}
}
