class Bank 
{
    String name;
    int accno;
    double p;

    public Bank(String name, int accno, double principal) 
    {
        this.name = name;
        this.accno = accno;
        this.p = principal;
    }

    public void display() 
    {
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accno);
        System.out.println("Principal Amount: " + p);
    }
}

class Account extends Bank 
{
    public Account(String name, int accno, double principal) 
    {
        super(name, accno, principal);
    }

    public void deposit(double amt) 
    {
        p += amt;
    }

    public void withdraw(double amt) 
    {
        if (amt > p) 
        {
            System.out.println("INSUFFICIENT BALANCE");
        } 
        else 
        {
            p -= amt;
            if (p < 500) {
                // Apply penalty if the balance is less than 500
                double penalty = (500 - p) / 10;
                p -= penalty;
            }
        }
    }

    @Override
    public void display() 
    {
        super.display();
    }
}