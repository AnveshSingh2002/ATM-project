package oops;

import java.util.HashMap;
import java.util.Scanner;

// Class representing the ATM operations
public class ATm {
	public static void main(String[] args) {
		// Create an instance of the ATM operations class
		ATMop obj = new ATMop();
	}
}

// Class to hold account data (balance)
class Data {
	float balance; // Balance associated with an account
}

// Class representing ATM operations
class ATMop {
	Scanner sc = new Scanner(System.in); // Scanner for user input
	HashMap<Integer, Data> map = new HashMap<>(); // Map to store account information using pincode

	// Constructor
	ATMop() {
		System.out.println("**************************");
		System.out.println("Welcome to our ATM");
		op(); // Call the main operation method
	}

	// Main operation method
	public void op() {
		System.out.println("***************************");
		System.out.println("Enter your pincode");
		System.out.println("***************************");
		int pincode = sc.nextInt();

		// Check if the pincode is already in the map
		if (map.containsKey(pincode)) {
			Data obj = map.get(pincode);
			menu(obj); // If account exists, show the menu
		} else {
			System.out.println("***********************");
			System.out.println("Please create account first");
			System.out.println("Set your pincode");
			int pin = sc.nextInt();
			Data obj = new Data();
			map.put(pin, obj); // If account doesn't exist, create a new account
			menu(obj); // Show the menu
		}
	}

	// Method to display the menu
	public void menu(Data obj) {
		System.out.println("Please enter valid number");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit Money");
		System.out.println("3. Withdraw Money");
		System.out.println("4. Check Another Account");
		System.out.println("5. Exit");

		int x = sc.nextInt();

		// Perform the selected operation based on user input
		if (x == 1) {
			check_balance(obj);
		} else if (x == 2) {
			deposit(obj);
		} else if (x == 3) {
			withdraw(obj);
		} else if (x == 4) {
			op(); // Check another account
		} else if (x == 5) {
			System.out.println(" Thank you !");
		} else {
			System.out.println("Please enter valid ");
			menu(obj); // Invalid input, show the menu again
		}
	}

	// Method to check the account balance
	public void check_balance(Data obj) {
		System.out.println("***********************");
		System.out.println("your balance " + obj.balance);
		System.out.println("***********************");
		menu(obj); // Show the menu
	}

	// Method to deposit money into the account
	public void deposit(Data obj) {
		System.out.println("Enter your amount");
		float a = sc.nextFloat();

		obj.balance = obj.balance + a; // Update the balance
		System.out.println("Amount deposited successfully");
		System.out.println("*************************");
		menu(obj); // Show the menu
	}

	// Method to withdraw money from the account
	public void withdraw(Data obj) {
		System.out.println("Enter your amount");
		float a = sc.nextFloat();

		// Check if there is sufficient balance to withdraw
		if (obj.balance >= a) {
			obj.balance = obj.balance - a; // Update the balance
			System.out.println("Amount withdraw successfully");
		} else {
			System.out.println("Insufficient Balance");
		}
		menu(obj); // Show the menu
	}
}
