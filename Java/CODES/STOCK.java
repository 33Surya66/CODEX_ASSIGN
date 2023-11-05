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