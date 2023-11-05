import java.util.Scanner;

class Stock 
{
    String item;
    int qt;
    double rate;
    double amt;

    public Stock(String item, int qt, double rate) 
    {
        this.item = item;
        this.qt = qt;
        this.rate = rate;
        this.amt = qt * rate;
    }

    void display() 
    {
        System.out.println("Item: " + item);
        System.out.println("Quantity: " + qt);
        System.out.println("Rate: " + rate);
        System.out.println("Net Value: " + amt);
    }
}

class Purchase extends Stock 
{
    int pqty;
    double prate;

    public Purchase(String item, int qt, double rate, int pqty, double prate) 
    {
        super(item, qt, rate);
        this.pqty = pqty;
        this.prate = prate;
    }

    void update() 
    {
        
        qt += pqty;

        
        if (rate != prate) {
            rate = prate;
        }

        // Update the current stock value
        amt = qt * rate;
    }

    @Override
    void display() 
    {
        super.display();
        System.out.println("Purchased Quantity: " + pqty);
        System.out.println("Purchase Rate: " + prate);
    }
}

public class Main_stockpurchase
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Item Name: ");
        String item = input.nextLine();

        System.out.print("Enter Initial Quantity: ");
        int quantity = input.nextInt();

        System.out.print("Enter Initial Rate: ");
        double rate = input.nextDouble();

        System.out.print("Enter Purchased Quantity: ");
        int purchasedQuantity = input.nextInt();

        System.out.print("Enter Purchase Rate: ");
        double purchaseRate = input.nextDouble();

        Purchase purchase = new Purchase(item, quantity, rate, purchasedQuantity, purchaseRate);
        System.out.println("Stock Details Before Update:");
        purchase.display();

        purchase.update();
        System.out.println("Stock Details After Update:");
        purchase.display();

        input.close();
    }
}