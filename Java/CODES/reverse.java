import java.util.Scanner;  
public class reverse {  
    public static void main(String args[]){  
    String s; 
    Scanner scan = new Scanner(System.in);  
    System.out.print("Enter a String: ");  
    s=scan.nextLine();  
    System.out.print("Reverse of string is: ");  
    for(int i=s.length();i>0;--i) 
    {  
    System.out.print(s.charAt(i-1));
    }  
}  
}  