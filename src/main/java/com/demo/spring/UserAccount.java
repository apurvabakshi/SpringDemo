package com.demo.spring;

import java.util.HashMap;
import java.util.Map;

public class UserAccount {

	String cardNumber="";
	HashMap<Integer,Integer> acc=new HashMap<Integer, Integer>();
	String userPin="";
	
	
	public UserAccount() {

	}


	public UserAccount(String cardNumber, HashMap<Integer, Integer> acc_info, String userPin) {

		this.cardNumber=cardNumber;
		for (Map.Entry<Integer, Integer> entry : acc_info.entrySet()) {
		    acc.put(entry.getKey(), entry.getValue()) ;
		}
		this.userPin=userPin;
	}


	public String getUserPin() {
		return userPin;
	}

	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public HashMap<Integer, Integer> getAcc() {
		return acc;
	}


	public void setAcc(HashMap<Integer, Integer> acc) {
		this.acc = acc;
	}


	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}
}
