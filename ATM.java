import java.util.Scanner;

public class ATM {
    private double balance;
    private int pin;
    private boolean cardValid;

    public ATM(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
        this.cardValid = true;
    }

    public void displayBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("$" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public boolean verifyPIN(int enteredPIN) {
        return enteredPIN == pin;
    }

    public boolean isCardValid() {
        return cardValid;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose Language (1 for English, 2 for Hindi): ");
        int languageChoice = scanner.nextInt();

        String language = (languageChoice == 1) ? "English" : "Hindi";
        System.out.println("Selected language: " + language);

        System.out.print("Enter PIN: ");
        int enteredPIN = scanner.nextInt();

        ATM atm = new ATM(1000.0, 1234);

        if (atm.verifyPIN(enteredPIN) && atm.isCardValid()) {
            while (true) {
                System.out.println("\nATM Operations:");
                System.out.println("1. Display Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        atm.displayBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        atm.withdraw(withdrawalAmount);
                        break;
                    case 4:
                        System.out.println("Exiting ATM. Thank you!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid PIN or Card not valid. Exiting.");
        }
    }
}
