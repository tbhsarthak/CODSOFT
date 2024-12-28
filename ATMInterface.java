import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance;  // Store the balance of the account

    // Constructor to create a bank account with an initial balance
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;  // Set the initial balance
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;  // Deposit must be greater than 0
        }
        balance += amount;  // Add the deposit to the balance
        return true;
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;  // Cannot withdraw more than available balance or non-positive amounts
        }
        balance -= amount;  // Deduct the withdrawal amount from the balance
        return true;
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;  // The bank account that the ATM will interact with

    // Constructor that takes a BankAccount to interact with
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the menu options
    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    // Method to check the current balance
    public void checkBalance() {
        System.out.printf("Your current balance is: %.2f\n", account.getBalance());
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (account.deposit(amount)) {
            System.out.printf("Successfully deposited %.2f.\n", amount);
        } else {
            System.out.println("Deposit failed. Amount must be greater than 0.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.printf("Successfully withdrew %.2f.\n", amount);
        } else {
            System.out.println("Withdrawal failed. Either insufficient balance or invalid amount.");
        }
    }

    // Method to run the ATM system
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();  // Show the menu
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();  // Read the user's choice

            switch (choice) {
                case 1:
                    checkBalance();  // Check balance
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();  // Get deposit amount
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();  // Get withdrawal amount
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();  // Close the scanner to prevent memory leaks
                    return;  // Exit the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();  // Print a blank line for readability
        }
    }
}

// Main class to run the ATM system
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00);  // Create an account with a starting balance of 1000.00
        ATM atm = new ATM(userAccount);  // Create an ATM connected to that account
        atm.run();  // Start the ATM system
    }
}