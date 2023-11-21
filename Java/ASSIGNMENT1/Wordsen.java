import java.util.Scanner;
public class Wordsen {
    public static void main (String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter word: ");
        String word = scan.nextLine();
        System.out.println("Enter sentence: ");
        String line = scan.nextLine();
        System.out.println("Word + Sentence = " + word + " " + line);
        scan.close();
    }
}