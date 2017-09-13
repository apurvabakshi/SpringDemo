package com.demo.spring;

/**
 * Hello world!
 *
 */
public class App 
{
	private String message;

	   public void setMessage(String message){
	      this.message  = message;
	   }
	   public void getMessage(){
	      System.out.println("Your Message : " + message);
	   }
}
