import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMSimulation {
private static double balance = 5000.0; // Initial balance

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
boolean running = true;

System.out.println("Welcome to the ATM Machine!");

while (running) {
System.out.println("\nChoose an option:");
System.out.println("1. Check Balance");
System.out.println("2. Deposit");


System.out.println("3. Withdraw");
System.out.println("4. Exit");

try {
System.out.print("Enter choice (1-4): ");
int choice = scanner.nextInt();

switch (choice) {
case 1:
checkBalance();
break;
case 2:
deposit(scanner);
break;
case 3:
withdraw(scanner);
break;
case 4:
System.out.println("Thank you for using the ATM. Goodbye!");
running = false;
break;
default:
throw new IllegalArgumentException("Invalid choice. Please select between

1 and 4.");
}
} catch (InputMismatchException e) {
System.out.println("Error: Please enter numeric input only.");
scanner.nextLine(); // Clear invalid input

} catch (IllegalArgumentException | ArithmeticException e) {
System.out.println("Exception: " + e.getMessage());
} finally {
System.out.println("Returning to main menu...");
}
}

scanner.close();
}

private static void checkBalance() {
System.out.printf("Your current balance is: $%.2f%n", balance);
}

private static void deposit(Scanner scanner) {
System.out.print("Enter amount to deposit: ");
double amount = scanner.nextDouble();

if (amount <= 0) {
throw new IllegalArgumentException("Deposit amount must be greater than
zero.");
}

balance += amount;
System.out.printf("Successfully deposited $%.2f. New balance: $%.2f%n", amount,
balance);
}

private static void withdraw(Scanner scanner) {

System.out.print("Enter amount to withdraw: ");
double amount = scanner.nextDouble();

if (amount <= 0) {
throw new IllegalArgumentException("Withdrawal amount must be greater than
zero.");
}

if (amount > balance) {
throw new ArithmeticException("Insufficient funds. Withdrawal denied.");
}

balance -= amount;
System.out.printf("Successfully withdrew $%.2f. New balance: $%.2f%n", amount,
balance);
}
}