// Mia Palmer's homework for CS119 final project.
// This program gives a vehicle to a user.
// It uses a multidimensional array to find the type of vehicle that the user wants.
// It also has multiple methods for each function of the program.

// Import file, scanner, and time unit.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    // This method is the main method.
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        // Input: Gets the vehicle that the user asks for from the user input method.
        // Process: Make a multidimensional array that is filled by a file.
        // Asks three different users to type what car they want.
        // Check that they do not have a number in their answer and
        // if they do not give a vehicle that is found in the first column,
        // ask them to try again after showing them what they can choose from.
        // Output: Displays the vehicle of the user choice and moves it down to user.

        // Declarations.
        final int ROWS = 10;
        final int COLUMNS = 2;
        String[][] vehicles = new String[ROWS][COLUMNS];
        getFile(vehicles, ROWS);

        // Loop the program three times.
        for (int i = 0; i < 3; i++) {
            int row = getUserInput(vehicles, ROWS);
            moveVehicle(vehicles, ROWS, row);
        } // End for.
    } // End main().

    // This method reads in the file.
    public static void getFile(String[][] vehicles, int rows) throws FileNotFoundException {
        // Input: The file that has the vehicles.
        // Process: Reads in the file.
        // Output: The contents of the file.

        // Declarations.
        String row;

        // Open input file.
        File vehicleList = new File("ourVehicles.txt");

        // Read the file.
        Scanner fileRead = new Scanner(vehicleList);
        System.out.println("Hi! Welcome to Mia's Vehicle Vending Machine!");

        // Loop that reads record from the file.
        for (int y = 0; y < rows; y++) {
            row = fileRead.nextLine();
            String parts[] = row.split(",");
            vehicles[y][0] = parts[0];
            vehicles[y][1] = "     ";
        } // End for.
    } // End getFile().

    // This method displays the file.
    public static void displayFile(String[][] vehicles, int rows) {
        // Input: The file that has the vehicle.
        // Process: Reads in the file.
        // Output: Displays the contents of the file to the user.

        // Show the user their options.
        System.out.println("Here are the options for your vehicle choice:");

        // Place a loop that reads record from the file.
        for (int y = 0; y < rows; y++) {

            // Display the vehicle options to the user.
            System.out.printf("%14.14s    %14.14s \n", vehicles[y][0], vehicles[y][1]);
        } // End for.
    } // End displayFile().

    // This method gets user input and checks that it is not a number.
    public static int getUserInput(String[][] vehicles, int rows) {
        // Input: The vehicle that the user wants.
        // Process: Get the user input and check that it is not a number.
        // Output: The users chosen vehicle.

        // Declarations.
        Scanner input = new Scanner(System.in);
        int type = -1;
        boolean badEntry = true;
        String line = "";

        // Place a while loop to catch any invalid answers.
        while (badEntry) {
            displayFile(vehicles, rows);

            // Ask the user for input.
            System.out.print("Please enter the kind of vehicle you want to buy: ");
            line = input.nextLine();

            // Loop to check for invalid input.
            if (!Character.isDigit(line.charAt(0))) {
                for (int x = 0; x < rows; x++) {
                    if (line.equals(vehicles[x][0])) {
                        type = x;
                        badEntry = false;
                    } // End if.
                } // End for.
            } // End if.

            if (badEntry) {
                System.out.println("That answer is invalid. Please try again: ");
            } // End if.
        } // End while.

        // Show the user what they chose.
        System.out.println("The vehicle you have chosen is " + line);
        return type;
    } // End getUserInput()

    // This method moves the users chosen vehicle down to the user.
    public static void moveVehicle(String[][] vehicles, int rows, int row) throws InterruptedException {
        // Input: The users chosen vehicle.
        // Process: Moves the vehicle from the first column into the second column and
        // display the contents of the file as it moves down each row.
        // Output: Displays the array's content as the vehicle moves down the column.

        // Declarations.
        System.out.print("\033\033");
        System.out.flush();
        vehicles[row][1] = vehicles[row][0];
        vehicles[row][0] = "     ";

        // Loop to move the vehicle down the column.
        while (row <= 9) {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Thank you for shopping!");
            displayFile(vehicles, rows);
            if (row == 9) {
                vehicles[9][1] = "Drive safely!";
                TimeUnit.SECONDS.sleep(2);
                displayFile(vehicles, rows);
            } // End if.
            else {
                vehicles[row + 1][1] = vehicles[row][1];
                vehicles[row][1] = "     ";
            } // End else.
            row++;
        } // End while

        vehicles[9][1] = "Drive safely!";
        TimeUnit.SECONDS.sleep(2);
        vehicles[9][1] = "     ";
    } // End moveVehicle().
} // End class
