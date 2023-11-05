import java.util.Scanner;

class Bank {
    String name;
    int accno;
    double p;

    public Bank(String name, int accno, double principal) {
        this.name = name;
        this.accno = accno;
        this.p = principal;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accno);
        System.out.println("Principal Amount: " + p);
    }
}

class Account extends Bank {
    public Account(String name, int accno, double principal) {
        super(name, accno, principal);
    }

    public void deposit(double amt) {
        p += amt;
    }

    public void withdraw(double amt) {
        if (amt > p) {
            System.out.println("INSUFFICIENT BALANCE");
        } else {
            p -= amt;
            if (p < 500) {
                // Apply penalty if the balance is less than 500
                double penalty = (500 - p) / 10;
                p -= penalty;
            }
        }
    }

    @Override
    public void display() {
        super.display();
    }
}

public class Main_Bank {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = input.nextLine();

        System.out.print("Enter account number: ");
        int accno = input.nextInt();
        input.nextLine(); // Consume the newline character

        System.out.print("Enter principal amount: ");
        double principal = input.nextDouble();
        input.nextLine(); // Consume the newline character

        Account account = new Account(name, accno, principal);

        // Display initial details
        System.out.println("Initial Details:");
        account.display();

        System.out.print("Enter transaction amount: ");
        double transactionAmount = input.nextDouble();
        input.nextLine(); // Consume the newline character

        // Deposit money
        account.deposit(transactionAmount);
        System.out.println("After Deposit:");
        account.display();

        System.out.print("Enter withdrawal amount: ");
        double withdrawalAmount = input.nextDouble();
        input.nextLine(); // Consume the newline character

        // Withdraw money
        account.withdraw(withdrawalAmount);
        System.out.println("After Withdraw:");
        account.display();

        input.close();
    }
}