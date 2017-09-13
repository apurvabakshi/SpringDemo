package com.demo.spring;

import java.io.InputStreamReader;
import java.util.Scanner;

public class BankOperations {
	Scanner scan=new Scanner(new InputStreamReader(System.in));
	
	public UserAccount Withdraw(UserAccount user, String amt) {
		
		int userBalance=user.getAcc().get(123);
		
		int amtInt=Integer.parseInt(amt);
			if(getApproval()==1){
				System.out.println("Withdrawn:"+amt);
				userBalance=userBalance-amtInt;
				user.acc.put(123, userBalance);
			}
		return user;
	}

public UserAccount Deposit(UserAccount user, String amt){
	int userBalance=user.getAcc().get(123);
	
	int amtInt=Integer.parseInt(amt);
		if(getApproval()==1){
			System.out.println("Deposited:"+amt);
			userBalance=userBalance+amtInt;
			user.acc.put(123, userBalance);
		}
	return user;
}

public UserAccount Transfer(UserAccount user, String amt){
int userBalance1=user.getAcc().get(123);
int userBalance2=user.getAcc().get(456);
		int amtInt=Integer.parseInt(amt);
		
		if(getApproval()==1){
			System.out.println("Deposited to second account:"+amt);
			userBalance2=userBalance2+amtInt;
			userBalance1=userBalance1-amtInt;
			user.acc.put(123, userBalance1);
			user.acc.put(456, userBalance2);
		}
	return user;
}

public void CheckBalance(UserAccount user){
	System.out.println("Acc no.123 Balance:"+user.getAcc().get(123));
	System.out.println("Acc no.456 Balance:"+user.getAcc().get(456));
}

public static int getApproval(){
	return 1;
}
}
