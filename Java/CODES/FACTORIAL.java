class Number 
{
    int n;

    public Number(int nn) {
        this.n = nn;
    }

    int factorial(int a) {
        if (a == 0) {
            return 1;
        } else {
            return a * factorial(a - 1);
        }
    }

    void display() {
        System.out.println("Number: " + n);
    }
}

class Series extends Number 
{
    int sum;
    int[] factorials;

    public Series(int nn) 
    {
        super(nn);
        this.sum = 0;
        this.factorials = new int[nn];
    }

    void calsum() 
    {
        for (int i = 1; i <= n; i++) 
        {
            factorials[i - 1] = factorial(i); // Store factorial in the array
            sum += factorials[i - 1];
        }
    }

    @Override
    void display() 
    {
        super.display();
        System.out.println("Sum of the series: " + sum);
        System.out.print("Factorials: ");
        for (int i = 0; i < n; i++) 
        {
            System.out.print(factorials[i] + " ");
        }
        System.out.println();
    }
}

public class Main_Factorial_SumSeries 
{
    public static void main(String[] args) 
    {
        Series series = new Series(5);
        series.calsum();
        series.display();
    }
}