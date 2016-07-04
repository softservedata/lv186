package edu;
import java.io.*;
public class task325 {
	public static void main(String[ ] args) throws Exception    
	{
	    try{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 System.out.println("Введить число n:");
	 String n=br.readLine();
	 long nn = Long.parseLong(n); 
	 long i=nn;
	 System.out.println("Дільники числа n:");
	 while(i>0)
	 {
	     if(nn%i==0)
	         System.out.println(i);
	     i--;
	 }
	    }
	    catch (Exception e)
	     {
	     System.out.println(e);
	     }

	  
	  
	     
	   
	}
}
