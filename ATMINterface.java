
package BasicPrg;

import java.util.Scanner;

interface User {
	void withdraw();

	void deposit();

	void balance();
}

class Atm_Interface{
	Scanner sc = new Scanner(System.in);

	Bank bank = new Bank();

	void displayOptions() {
		System.out.println("Select the  Options");
		System.out.println("1.Withdraw \n 2.Deposit \n 3.balance ");

		int pin;

		String option = sc.next();
		switch (option) {
		case "1":
			System.out.println("Enter pin number");
			pin = sc.nextInt();
			if (pin == 4312) {
				bank.withdraw();

				bank.balance();
			} else {
				System.out.println("Invalid pin number");
			}

			break;

		case "2":
			System.out.println("Please Enter a 4-digit pin");
			pin = sc.nextInt();
			if (pin == 8753) {

				bank.deposit();
				bank.balance();

			} else {
				System.out.println("Invalid pin number");
			}

			break;

		case "3":
			System.out.println("Enter pin number");
			pin = sc.nextInt();
			if (pin == 8753) {

				bank.balance();

			} else {
				System.out.println("Invalid pin number");
			}

			break;

		default:
			System.out.println("Invalid Option");

		}
	}
}

class Bank implements User {

	Scanner sc = new Scanner(System.in);
	int limit = 50000;
	int Amt = 100000;

	public void withdraw() {
		System.out.println("enter the amount to withdraw and limit is upto 50000 ");

		int withdrawAmount = sc.nextInt();
		if (withdrawAmount > Amt && limit == 50000) {
			System.out.println("Insufficient Balance");
		}

		if (withdrawAmount <= limit) {
			Amt -= withdrawAmount;
			System.out.println(" Successfully withdrawn your amount");
		} else {
			System.out.println("Limit exceeded");
		}
	}

	public void deposit() {
		System.out.println("enter the amount to deposit");
		int deposit = sc.nextInt();
		Amt += deposit;
		System.out.println("your amount is successfully deposited");
	}

	public void balance() {
		System.out.println("the balance amount is: " + Amt);
	}
}

public class ATMINterface {
	public static void main(String[] args) {

		System.out.println("Welcome!");

		Atm_Interface atm = new Atm_Interface();
		atm.displayOptions();
		System.out.println("Thank you!");

	}
}