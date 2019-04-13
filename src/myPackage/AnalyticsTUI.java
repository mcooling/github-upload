package myPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnalyticsTUI

        /*
         * PSEUDOCODE, for main method behaviour
         *
         * MAIN MENU
         * Print a welcome message to the user
         * Display a menu with 4 options: a) text input, b) read from file, c) demo, d) exit Lab 2
         * LAB 2, SWITCH STATEMENT, using a nested switch for demo
         * After each option is executed, the user should be asked to choose again, until they choose exit
         * LAB 4, WHILE LOOP (boolean set to true)
         * For text analysis, call a separate calculate class
         *
         * MANUAL TEXT INPUT
         * Use scanner class with a stored variable, to enter text manually
         *
         * FILE READ
         * For file input, offer three file options to choose from (nested switch)
         * Use FileInputStream to read files
         * Add exception handling, for if the file isn't there
         * LAB 9, FILES
         *
         * DEMO MODE
         * Add a further sub-menu (nested switch)
         * Three options: text, file, return to main menu
         * Use static text for manual, and ask the user to enter file name for file
         * For file option, add error handling and display if user enters wrong filename
         *
         * EXTRA FEATURES
         *
         * After each time calculate class is called and output displayed, programme should pause
         * User should choose when to return to main menu (System.in.read())
         */

{
    //store as global variables so they are accessible to all methods
    static String menuText = "Please select an option to continue";
    static boolean execute = false; //boolean variable to control when calculate code block runs

    public static void main(String[] args)
    {

        /* MAIN MENU

         * LAB 2, SWITCH STATEMENT, using a nested switch for demo
         * After each option is executed, the user should be asked to choose again, until they choose exit
         * LAB 4, WHILE LOOP (boolean set to true)
         * For text analysis, call a separate calculate class
         */

        Scanner menuScanner = new Scanner(System.in);

        // print out a welcome message to the user
        System.out.println("Welcome to the Text Analytics Programme");
        System.out.println();

        //boolean newInput = true;
        boolean returnToMain = true; //boolean variable to control when main menu re-runs

        String keyIn = "";
        String inputType = "";
        String invalidOption = "Sorry that is not a valid option. Please select a, b, or c to continue.";


        // Display a menu with 4 options: a) text input, b) read from file, c) demo, d) exit
        // After each option the user should be asked to choose again, until they choose to exit

        //Character.toUpperCase(searchCharacter)

        while (returnToMain)
        {
            System.out.println(menuText);
            System.out.println();
            System.out.println("a. Enter the text manually");
            System.out.println("b. Read the text from file");
            System.out.println("c. Enter Demo mode");
            System.out.println("d. Exit");

            //read first character from each option, to use in switch statement
            char menuOption = menuScanner.nextLine().charAt(0);

            //validation for menu options
            while (menuOption != 'a' && menuOption != 'b' && menuOption != 'c' && menuOption != 'd')
            {
                System.out.println("Sorry that is not a valid option. Please select a, b, c or d to continue.");
                menuOption = menuScanner.nextLine().charAt(0);
            }

            //add switch statement for each menu option
            switch (menuOption)
            {
                //manual text input
                case 'a':
                    execute = true; //runs the generic code block for calculate class

                    System.out.println("Please enter the word you want to analyse:");
                    keyIn = menuScanner.nextLine();
                    System.out.println();
                    inputType = "Manual";

                    // print out info to user
                    System.out.println("New string added: " + keyIn); //might not need this eventually

                    break;

                //read text from file
                //nested switch statement, offers further three files to choose fromm
                case 'b':

                    execute = true;

                    System.out.println();
                    System.out.println("You selected the read file option");
                    addFormatting();
                    System.out.println("a. Films");
                    System.out.println("b. Music Records");
                    System.out.println("c. Actors");

                    char readFile = menuScanner.nextLine().charAt(0);

                    //validation for menu options
                    while (readFile != 'a' && readFile != 'b' && readFile != 'c')
                    {
                        System.out.println(invalidOption);
                        readFile = menuScanner.nextLine().charAt(0);
                    }

                    //add exception handling for file not found
                    try
                    {
                        switch (readFile)
                        {

                            case 'a':
                                execute = true;
                                Scanner readFile1 = new Scanner(new FileInputStream("file/readFile1.txt"));
                                keyIn = "";
                                inputType = "File";

                                while (readFile1.hasNextLine())
                                {
                                    keyIn = keyIn + readFile1.nextLine() + '\n';
                                }
                                break;

                            case 'b':
                                execute = true;
                                Scanner readFile2 = new Scanner(new FileInputStream("file/readFile2.txt"));
                                keyIn = "";
                                inputType = "File";

                                while (readFile2.hasNextLine())
                                {
                                    keyIn = keyIn + readFile2.nextLine() + '\n';
                                }
                                break;

                            case 'c':
                                execute = true;
                                Scanner readFile3 = new Scanner(new FileInputStream("file/readFile3.txt"));
                                keyIn = "";
                                inputType = "File";

                                while (readFile3.hasNextLine())
                                {
                                    keyIn = keyIn + readFile3.nextLine() + '\n';
                                }
                                break;
                        }
                    }
                    catch (FileNotFoundException fileNotFoundException)
                    {
                        fileNotRead();
                    }
                    break; //break out of main menu

                //enter demo mode
                //nested switch statement for demo sub-menu

                //***NEED TO ADD A MANUAL OPTION HERE, WITH FIXED VARIABLE, FOR MARKING***//
                //WILL NEED TO AMEND ERROR HANDLING TO REFLECT

                case 'c':
                    execute = false;

                    System.out.println();
                    System.out.println("You selected the Demo option");
                    addFormatting();
                    System.out.println("a. Use demo manual text");
                    System.out.println("b. Use demo file data");
                    System.out.println("c. Return to main menu");

                    char myDemo = menuScanner.nextLine().charAt(0);

                    //validation for menu options
                    while (myDemo != 'a' && myDemo != 'b' && myDemo != 'c')
                    {
                        System.out.println(invalidOption);
                        myDemo = menuScanner.nextLine().charAt(0);
                    }

                    try
                    {
                        switch (myDemo)
                        {
                            case 'a':
                                execute = true;
                                keyIn = "This is a string of text, for use in the Text Analytics Programme";
                                inputType = "Demo Text";

                                System.out.println("Demo text used in analysis:");
                                System.out.println(keyIn);
                                System.out.println();
                                break;

                            case 'b':
                                execute = true;
                                Scanner user = new Scanner(System.in);
                                System.out.println("Please enter the demo filename demofile.txt");
                                String inputFileName = user.nextLine();

                                //add validation for manual entry of file name
                                while (!inputFileName.equals("demofile.txt"))
                                {
                                    System.out.println("Filename incorrect. please enter demofile.txt to continue");
                                    inputFileName = user.nextLine();
                                }

                                Scanner input = new Scanner(new FileInputStream("file/" + inputFileName));
                                inputType = "Demo File";
                                keyIn = "";

                                //loop to read each file line with carriage return for print
                                //otherwise, would just print as a single string
                                while (input.hasNextLine())
                                {
                                    keyIn = keyIn + input.nextLine() + '\n'; //store the file content into variable
                                }
                                System.out.println("Demo file successfully read");
                                break;

                            case 'c':
                                //boolean set to false, so it ignores the calculate code block
                                execute = false;
                                System.out.println();
                                break; //return to main menu
                            default:
                                System.out.println("Nothing was selected");
                        }
                    }
                    catch (FileNotFoundException fileNotFoundException)
                    {
                        fileNotRead();
                    }
                    break;

                case 'd':
                    execute = false; //boolean set to false, so it ignores the calculate code block
                    System.out.println();
                    System.out.println("Thank you for using my Text Analytics Programme. Goodbye!");
                    returnToMain = false; //boolean set to false, so it terminates and doesn't re-run main menu loop
                    break;
                default:
                    System.out.println("Sorry, that is not a valid option");
            }

            //switch statement to cater for the generic code block below
            String summaryText = "";

            switch (inputType)
            {
                case "Manual":
                    summaryText = "text";
                    break;

                case "File":
                    summaryText = "file";
                    break;

                case "Demo Text":
                    summaryText = "demo text";
                    break;

                case "Demo File":
                    summaryText = "demo file";
                    break;
            }

            //generic code block, to avoid repeat println statements and calls to calculate class
            //boolean controls when this is run from each switch
            if(execute)
            {
                execute = false;

                System.out.println("The analysis for the " + summaryText + " input is shown below");
                System.out.println();

                //add condition which only applies for file read options
                if(inputType.equals("File") || inputType.equals("Demo File"))
                {
                    System.out.println("The file contents are: ");
                    System.out.println();
                    System.out.print(keyIn);
                    System.out.println();
                }

                //Call calculate class
                Calculate manualKey = new Calculate(keyIn); //instantiates the object in Calculate constructor
                manualKey.Results(); //calls Results method from Calculate class, passing Calculate object
                System.out.println();
                System.out.println("The text analysis is now complete.");

                //method call for the 'Enter key to continue' code
                pressAnyKeyToContinue();
            }
        }
        menuScanner.close();
    }

    // Private method to handle 'Enter key to continue' feature

    // Each time calculate class bar chart is displayed, programme should pause
    // Allows user to view the output, before choosing to exit and return to main menu

    static private void pressAnyKeyToContinue()
    {
        System.out.println("Please press the Enter key to continue...");
        Scanner enterKeyScanner = new Scanner(System.in);
        String enterKey = enterKeyScanner.nextLine();

        while(!enterKey.isEmpty()) {
            System.out.println("Please press the Enter key to continue...");
            enterKey = enterKeyScanner.nextLine();
        }
    }

    //private methods to tidy up some duplicate inline formatting

    static private void fileNotRead() {
        System.out.println();
        System.out.println("Testing GitHub integration");
        System.out.println("The input file for this programme could not be found");
        System.out.println("Contact a system administrator if this problem continues");
        System.out.println();
        execute = false;
    }

    static private void addFormatting() {
        System.out.println(menuText);
        System.out.println();
    }
}
