import java.util.Scanner;

class Product 
{
    String name;
    int code;
    double amount;

    public Product(String n, int c, double p) 
    {
        name = n;
        code = c;
        amount = p;
    }

    void show() 
    {
        System.out.println("Product Name: " + name);
        System.out.println("Product Code: " + code);
        System.out.println("Sale Amount: " + amount);
    }
}

class Sales extends Product 
{
    int day;
    double tax;
    double totamt;

    public Sales(String n, int c, double p, int d) 
    {
        super(n, c, p);
        day = d;
    }

    void compute() 
    {
        
        tax = 0.124 * amount;

        if (day > 30) {
            double fine = 0.025 * amount;
            amount += fine;
        }
        totamt = amount + tax;
    }

    @Override
    void show() 
    {
        super.show(); 
        System.out.println("Number of Days: " + day);
        System.out.println("Service Tax: " + tax);
        System.out.println("Total Amount Paid: " + totamt);
    }
}

public class Main_Productsales 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Product Name: ");
        String name = input.nextLine();

        System.out.print("Enter Product Code: ");
        int code = input.nextInt();

        System.out.print("Enter Sale Amount: ");
        double amount = input.nextDouble();

        System.out.print("Enter Number of Days: ");
        int days = input.nextInt();

        Sales sales = new Sales(name, code, amount, days);
        sales.compute();
        sales.show();

        input.close();
    }
}