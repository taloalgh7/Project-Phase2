package Project1;

/**
 * Project: Library Simulation - Phase #2 (Final Integrated Product)
 * File: Member.java
 * Encapsulates the data and behavior of a library member account using OOP concepts.
 * Group Members: [Insert Student Name and ID 1], [Insert Student Name and ID 2], [Insert Student Name and ID 3]
 * GitHub Repository Link: [Insert your GitHub Repository link here]
 */

public class Member {

    // --- Static Library Statistics ---
    private static double TotalRevenue = 0.0;
    private static int TotalViewBorrowed = 0;
    private static int TotalBorrows = 0;
    private static int TotalReturns = 0;

    private static final double BORROW_FEE = 0.50;
    private static final int MAX_BORROW_COUNT = 5;

    // --- Member Attributes ---
    private int id;
    private String name;
    private int borrowedCount;
    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;

    // --- Constructor ---
    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;

        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;
    }

    // --- Private Helper Methods ---
    private boolean canBorrow() {
        return this.borrowedCount < MAX_BORROW_COUNT;
    }

    private boolean canReturn() {
        return this.borrowedCount > 0;
    }

    // --- Core Operations ---
    public void viewBorrowedCount() {
        System.out.println(
            "Member " + this.name + " (" + this.id + ") currently has " + this.borrowedCount + " book(s) borrowed."
        );
        this.numViewBorrowed++;
        TotalViewBorrowed++;
    }

    public boolean borrowOne() {
        if (canBorrow()) {
            this.borrowedCount++;
            this.sessionFees += BORROW_FEE;
            this.numBorrows++;

            TotalRevenue += BORROW_FEE;
            TotalBorrows++;

            System.out.printf("Book borrowed successfully by %s. Fee charged: $%.2f%n", this.name, BORROW_FEE);
            return true;
        } else {
            System.out.println("Borrow failed for " + this.name + ". Maximum limit of " + MAX_BORROW_COUNT + " books reached.");
            return false;
        }
    }

    public boolean returnOne() {
        if (canReturn()) {
            this.borrowedCount--;
            this.numReturns++;
            TotalReturns++;

            System.out.println("Book returned successfully by " + this.name + ".");
            return true;
        } else {
            System.out.println("Return failed for " + this.name + ". Member has no books currently borrowed.");
            return false;
        }
    }

    public void displayStatistics() {
        System.out.println("\n--- Session Summary for: " + this.name + " (ID: " + this.id + ") ---");
        System.out.println(" * Books currently borrowed: " + this.borrowedCount);
        System.out.println(" * Number of times viewed borrowed count: " + this.numViewBorrowed);
        System.out.println(" * Number of books borrowed (session): " + this.numBorrows);
        System.out.println(" * Number of books returned (session): " + this.numReturns);
        System.out.printf(" * Total fees incurred (session): $%.2f%n", this.sessionFees);
        System.out.println("-------------------------------------------------------------------");
    }

    public void reset() {
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;

        System.out.println("Session statistics for " + this.name + " have been reset to zero.");
    }

    // --- Admin (Static) Statistics ---
    public static void displayTotalStatistics() {
        System.out.println("\n--- Library Total Accumulated Statistics ---");
        System.out.printf(" * Total Revenue Generated (All Accounts): $%.2f%n", TotalRevenue);
        System.out.println(" * Total View Borrowed Operation Used (All Accounts): " + TotalViewBorrowed);
        System.out.println(" * Total Borrows Operation Used (All Accounts): " + TotalBorrows);
        System.out.println(" * Total Returns Operation Used (All Accounts): " + TotalReturns);

        System.out.print(" * Most Frequent Operation: ");
        if (TotalBorrows > TotalReturns)
            System.out.println("Borrow");
        else if (TotalReturns > TotalBorrows)
            System.out.println("Return");
        else
            System.out.println("Equally frequent (Borrow and Return)");

        System.out.println("--------------------------------------------");
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}



