public class Prime 
{
    public static void main(String[] args) {
        int count = 0;
        int number = 2; // Start checking for prime numbers from 2
        
        System.out.println("First 10 prime numbers:");

        while (count < 10) {
            if (isPrime(number)) {
                System.out.println(number);
                count++;
            }
            number++;
        }
    }
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i ++) {
            if (num % i == 0) 
            {
                return false;
            }
        }
        return true;
    }
}
