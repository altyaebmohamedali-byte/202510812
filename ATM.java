import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

       
        final int CORRECT_PIN = 33333;
        int attempts = 0;
        final int MAX_ATTEMPTS = 5;
        boolean isAuthenticated = false;

        double balance = 300.0; // Initial default balance
        String[] transactions = new String[100]; // Array to store transaction history
        int transactionCount = 0; // Counter to track stored transactions

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your PIN: ");
            int enteredPin = input.nextInt();

            if (enteredPin == CORRECT_PIN) {
                isAuthenticated = true;
                System.out.println("Login successful!\n");
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }

        if (!isAuthenticated) {
            System.out.println("Maximum attempts reached. Card blocked. Exiting...");
            input.close();
            return;
        }

        // 3. Main Menu loop
        int choice = 0;
        while (choice != 5) {
            System.out.println("== ATM MAIN MENU ====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();

            switch (choice) {
                case 1: // Check balance
                    System.out.println("Current Balance: $" + balance + "\n");
                    break;

                case 2: // Deposit money
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        transactions[transactionCount] = "Deposited: $" + depositAmount;
                        transactionCount++;
                        System.out.println("Deposit successful! New Balance: $" + balance + "\n");
                    } else {
                        System.out.println("Invalid amount!\n");
                    }
                    break;

                case 3: // Withdraw money
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        transactions[transactionCount] = "Withdrew: $" + withdrawAmount;
                        transactionCount++;
                        System.out.println("Withdrawal successful! New Balance: $" + balance + "\n");
                    } else if (withdrawAmount > balance) {
                        System.out.println("Error: Insufficient balance!\n");
                    } else {
                        System.out.println("Invalid amount!\n");
                    }
                    break;

                case 4: // View transaction history using a for loop
                    System.out.println("--- Transaction History ---");
                    if (transactionCount == 0) {
                        System.out.println("No transactions yet.");
                    } else {
                        for (int i = 0; i < transactionCount; i++) {
                            System.out.println((i + 1) + ". " + transactions[i]);
                        }
                    }
                    System.out.println();
                    break;

                case 5: // Exit program
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }

        input.close();
    }
}