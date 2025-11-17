package Project1;

/**
 * Project: Library Simulation - Phase #2 (Final Integrated Product)
 * File: LibrarySimulator.java
 * Main class to run the simulation using the Member class.
 * Group Members: [Insert Student Name and ID 1], [Insert Student Name and ID 2], [Insert Student Name and ID 3]
 * GitHub Repository Link: [Insert your GitHub Repository link here if applicable for bonus]
 */


import java.util.Scanner;
import java.util.Locale;

public class LibrarySimulator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        // --- Create Members ---
        Member fahad = new Member(101, "Fahad", 0);
        Member saleh = new Member(102, "Saleh", 0);
        Member mohammed = new Member(103, "Mohammed", 0);

        boolean running = true;
        System.out.println("==============================");
        System.out.println("       Welcome to the Public Library Simulator");

        while (running) {
            System.out.println("\n==============================");
            System.out.println("1. Login as " + fahad.getName() + " " + fahad.getId());
            System.out.println("2. Login as " + saleh.getName() + " " + saleh.getId());
            System.out.println("3. Login as " + mohammed.getName() + " " + mohammed.getId());
            System.out.println("4. Login as Administrator");
            System.out.println("5. Exit");
            System.out.println("------------------------------");
            System.out.print("Enter your choice: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
                continue;
            }

            int choice = input.nextInt();

            if (choice >= 1 && choice <= 3) {
                Member currentMember = (choice == 1) ? fahad : (choice == 2 ? saleh : mohammed);
                String currentUser = currentMember.getName() + " " + currentMember.getId();
                boolean sessionActive = true;

                while (sessionActive) {
                    System.out.println("\n==============================");
                    System.out.println("      User Menu: " + currentUser);
                    System.out.println("1. View Borrowed Books Count");
                    System.out.println("2. Borrow Book");
                    System.out.println("3. Return Book");
                    System.out.println("4. View Session Summary");
                    System.out.println("5. Reset Session Statistics");
                    System.out.println("6. Exit to Main Menu");
                    System.out.println("------------------------------");
                    System.out.print("Choose an option: ");

                    if (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        input.next();
                        continue;
                    }

                    int userChoice = input.nextInt();

                    switch (userChoice) {
                        case 1:
                            currentMember.viewBorrowedCount();
                            break;
                        case 2:
                            currentMember.borrowOne();
                            break;
                        case 3:
                            currentMember.returnOne();
                            break;
                        case 4:
                            currentMember.displayStatistics();
                            break;
                        case 5:
                            currentMember.reset();
                            break;
                        case 6:
                            sessionActive = false;
                            System.out.println("Logging out of " + currentUser + "...");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            } 
            else if (choice == 4) {
                boolean adminActive = true;

                while (adminActive) {
                    System.out.println("\n==============================");
                    System.out.println("        Administrator Menu");
                    System.out.println("1. View Total Library Statistics");
                    System.out.println("2. Exit to Main Menu");
                    System.out.println("------------------------------");
                    System.out.print("Choose an option: ");

                    if (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        input.next();
                        continue;
                    }

                    int adminChoice = input.nextInt();

                    switch (adminChoice) {
                        case 1:
                            Member.displayTotalStatistics();
                            break;
                        case 2:
                            adminActive = false;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            } 
            else if (choice == 5) {
                running = false;
                System.out.println("Exiting the system... Goodbye!");
            } 
            else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}



