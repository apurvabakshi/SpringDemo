package com.demo.spring;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.demo.spring.*;

public class AtmDemo {
public static void main(String args[]){
	/*HashMap<Integer, Integer> acc_info=new HashMap<Integer, Integer>();
	acc_info.put(123, 10000);
	acc_info.put(456, 20000);
	UserAccount user=new UserAccount("1111", acc_info, "0000");*/
	
	 ApplicationContext context = new ClassPathXmlApplicationContext("com/demo/spring/beans.xml");
   
	 UserAccount user = (UserAccount) context.getBean("useraccount");
     BankOperations bank= (BankOperations) context.getBean("bankoperations");
     String choice="1";
     Scanner scan=new Scanner(new InputStreamReader(System.in));
	
	System.out.println("Enter operation you want to perform:\n1. Withdraw\n2. Deposit\n3. Transfer\n4. Check balance\n5. Exit");
	choice=scan.next();
		switch (Integer.parseInt(choice)) {
		case 1:
			System.out.println("Enter amount to withdraw:");
			String amt = scan.next();
			user = bank.Withdraw(user, amt);
			break;
		case 2:
			System.out.println("Enter amount to deposit:");
			amt = scan.next();
			user = bank.Deposit(user, amt);
			break;
		case 3:
			System.out.println("Enter amount to transfer:");
			amt = scan.next();
			user=bank.Transfer(user,amt);
			break;
		case 4:	
				bank.CheckBalance(user);
		case 5: 
				break;
		}
	
	scan.close();
}
}
