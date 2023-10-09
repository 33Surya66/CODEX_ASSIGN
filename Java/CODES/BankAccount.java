public class BankAccount {
    int ACNumber;
    double balance;

    public BankAccount() {
        ACNumber = 10011;
        balance = 0;
    }

    public BankAccount(int num) {
        ACNumber = 10011;
        balance = num;
    }

    public BankAccount(int acc, int num) {
        ACNumber = acc;
        balance = num;
    }

    public static void main(String[] args) {
        BankAccount x = new BankAccount();
        System.out.print("Default: ");
        System.out.println(x.ACNumber + " " + x.balance);
        System.out.print("1 Parameter: ");
        BankAccount y = new BankAccount(100);
        System.out.println(y.ACNumber + " " + y.balance);
        System.out.print("2 Parameters: ");
        BankAccount z = new BankAccount(10101, 200);
        System.out.println(z.ACNumber+" " +z.balance);
    }
    
}