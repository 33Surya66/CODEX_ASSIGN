public class MathOperations {
    static int sum(int i, int j) {
        int a = i;
        int b = j;
        return(a+b);
    }

    static double sum(double i, double j) {
        return(i+j);
    }

    static double sum(int i, double j) {
        return (i + j);
    }

    public static void main(String[] args) {
        System.out.println(sum(5, 6));
        System.out.println(sum(2.5, 3.1));
        System.out.println(sum(1,11.9));
    }
}