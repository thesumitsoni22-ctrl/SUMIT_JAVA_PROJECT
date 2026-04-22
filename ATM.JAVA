import java.util.Scanner;

class ATMSystem {

    double balance = 1000;
    final int correctPin = 1234;

    boolean authenticate(Scanner sc) {
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter your PIN: ");
            int pin = sc.nextInt();

            if (pin == correctPin) {
                return true;
            } else {
                attempts--;
                System.out.println("Wrong PIN! Attempts left: " + attempts);
            }
        }
        return false;
    }

    void showMenu(Scanner sc) {
        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance 💰");
            System.out.println("2. Deposit 💵");
            System.out.println("3. Withdraw 💸");
            System.out.println("4. Exit 🚪");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    if (dep > 0) {
                        balance += dep;
                        System.out.println("Deposited successfully!");
                    } else {
                        System.out.println("Invalid amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double wit = sc.nextDouble();
                    if (wit > 0 && wit <= balance) {
                        balance -= wit;
                        System.out.println("Please collect your cash 💸");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using ATM 😊");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }
}

public class ATM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ATMSystem atm = new ATMSystem();

        System.out.println("====== WELCOME TO SMART ATM ======");

        if (atm.authenticate(sc)) {
            atm.showMenu(sc);
        } else {
            System.out.println("Card Blocked! Try later.");
        }

        sc.close();
    }
}
