import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application
{
    public static void main(String[] args) throws FileNotFoundException
    {
        /**
         *
         * Application:
         * Write a program that repeatedly lets the user choose from the following options:
         * • Add a new patient to the practice (where there is already a patient with that first name, last name and date of birth, the
         * user should be informed and the patient should not be added).
         * • Delete a patient from the practice (you should handle any outstanding appointments appropriately – this may require
         * adding an extra method to your queue outside the standard functionality)
         * • Display all patients
         * • Create a new appointment for a specific patient and add it to the queue (the appointment should be allocated a
         * random triage level between 1 and 5)
         * • Call the next patient in
         * • Exit
         */

        Scanner keyboard = new Scanner(System.in);
        String[] menuOptions = {
                "0. Add a new patient to the practice",
                "1. Delete a patient from the practice",
                "2. Display all patients",
                "3. Create a new appointment for a specific patient and add it to the queue",
                "4. Call the next patient in",
                "5. Exit",
        };

        int menuChoice = -1;
        do {
            displayMenu(menuOptions, "Hospital menu");
            try {
                menuChoice = getMenuChoice(menuOptions.length);
                switch (menuChoice) {
                    case 1:
                        //Add a new patient to the practice
                        break;
                    case 2:
                        // Delete a patient from the practice
                        break;
                    case 3:
                        // Display all patients
                        break;
                    case 4:
                        // Create a new appointment for a specific patient and add it to the queue
                        break;
                    case 5:
                        // Call the next patient in
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid - Please enter a valid option");
            }
        }
        while(menuChoice != 0);

    }

    public static void displayMenu(String[] menuOptions, String menuTitle) {
        System.out.println(menuTitle);
        System.out.println("Please choose from one of the following options:");
        for (String option: menuOptions) {
            System.out.println(option);
        }
    }

    public static int getMenuChoice(int numItems) {
        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();
        while (choice < 1 || choice > numItems) {
            System.out.printf("Please enter a valid option (1 - %d)\n", numItems);
            choice = keyboard.nextInt();
        }
        return choice;
    }
}
