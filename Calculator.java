import java.util.Scanner;

public class Calculator {
public static void main(String[] args) {
Scanner Scanner = new Scanner (System.in);
System.out.println("select operation :\n +,-,*,/");
int opp = Scanner.nextInt();
System.out.println("enter first number");
int a= Scanner.nextInt();
System.out.println("enter second number");
int b= Scanner.nextInt();
try {
switch(opp){
case 1 :System.out.println(a=b); break;
case 2 :System.out.println(a-b); break;
case 3 :System.out.println(a*b); break;

case 4 :System.out.println(a/b); break;
default:
throw new AssertionError();

}
} catch (Exception e) {

}

}

}