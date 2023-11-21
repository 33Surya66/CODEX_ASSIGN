import java.util.Scanner;  
public class spy 
{  
public static void main(String args[])  
{   
int num, product=1, sum=0, lastdigit;  
Scanner scan = new Scanner(System.in);  
System.out.print("Enter the number: " );  
num=scan.nextInt();    
while(num>0)  
{        
lastdigit=num%10;   
sum=sum+lastdigit;  
product=product*lastdigit;  
num=num/10;  
}   
if(sum==product)    
System.out.println("It is a spy number.");  
else  
System.out.println("It is not a spy number.");  
}  
}