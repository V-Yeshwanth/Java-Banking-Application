package Project;

import java.util.Scanner;

public class BankingApplicationProject {

	public static void main(String[] args) {
	
		Scanner input  = new Scanner(System.in);
		System.out.println("Enter the Customer Name: ");
		String cname = input.nextLine();
		System.out.println("Enter the Customer Id: ");
		int cid = input.nextInt();
		BankingApplication obj = new BankingApplication(cname, cid);
		obj.ShowMenu();
	}
	
}

class BankingApplication{
	
	int perArr[] = new int[10];
	String Customername;
	int CustomerId;
	int Balance;
	int amount;
//	int PreviousTrans;
	
	int p = 0;
	void deposit(int amount) {
		if(amount != 0) {
			Balance = Balance + amount;
			perArr[p] = amount;
			p++;
		}
	}
	
	void withdraw(int amount) {
		if(amount > 0) {
			Balance = Balance - amount;
			perArr[p] = -amount;
			p++;
		}
	}
	
	public BankingApplication(String Cname, int Cid) {
		Customername = Cname;
		CustomerId = Cid;
		System.out.println("Welcome To The Apna Bank!....");
		System.out.println("Mr."+Customername);
		System.out.println();
	}
	
	public void ShowMenu() {
		
//	do {
		String opt = "";
		Scanner input = new Scanner(System.in);
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println();
		System.out.println("Select The Relevant Options Below:");
		System.out.println();
		System.out.println("A : Check Balance");
		System.out.println("B : Cash Deposit");
		System.out.println("C : Cash Withdrawal");
		System.out.println("D : Previous Transaction");
		System.out.println("E : Exit");
		
		do {
		System.out.println();	
		System.out.println("Enter Option: ");
		String option = input.next();
			
		switch (option) {
		case "A": {
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println();
			if(Balance == 0) {
				Balance = 0;
			}
			System.out.println("Bank Balance of Mr."+Customername+" is "+" : ");
			System.out.println(Balance);
			System.out.println();
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		}
		break;
		
		case "B": {
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println();
			System.out.println("Enter the Amount To Be Deposited: ");
			int amt = input.nextInt();
			deposit(amt);
			System.out.println("Successfully !.. Deposited.");
			System.out.println();
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		}
		break;
		
		case "C": {
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println();
			System.out.println("Enter the Amount To WithDraw: ");
			int amt = input.nextInt();
			if(Balance > 0) {
				withdraw(amt);
				System.out.println("Successfully !.. Withdrawed.");	
			} else {
				System.out.println("You Don't Have Sufficient Balance.");
			}
			System.out.println();
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		}
		break;
		
		case "D": {
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println();
			System.out.println("Enter the Number of Previous Transactions: ");
			int num = input.nextInt();
			if(num < 10 && num > 0) {
				for(int i=0; i<num; i++) {
					if(perArr[i] > 0) {
						System.out.println("Deposited: "+perArr[i]);
					} else if(perArr[i] < 0) {
						System.out.println("Withdrawed: "+Math.abs(perArr[i]));
					}
				}
			} else if(num > 10){
				System.out.println("Can Only Display Minimum of Last 10 Transactions.");
			} else {
				System.out.println("NO Transactions Yet!...");
			}
			System.out.println();
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		}
		break;
		
		case "E": {
			opt = "E";
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println();
			System.out.println("Thanks For Using Apna BankingApplication.");
			System.out.println();
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		}
		break;
		
		default:
			System.out.println("Please: Enter A Relevant Option!...");
		}
	  } while(opt != "E");
		System.out.println("Come Again Next Time!..");
	}
	
}