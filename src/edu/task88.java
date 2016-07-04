
package edu;
import java.io.*;
public class task88 {
	public static void main(String[ ] args) throws Exception    
	{
	    try{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 System.out.println("Please, write the number: ");
	 String n=br.readLine();
	 StringBuffer nn=new StringBuffer(n);
	 char temp =nn.charAt(0);
	 nn.setCharAt(0, nn.charAt(nn.length()-1));
	 nn.setCharAt(nn.length()-1,temp); 
	 String n0 = "0";
	 for(int i = 0; i<nn.length(); i++) {
		 if(nn.charAt(i) == n0.charAt(0)) {
			 nn.deleteCharAt(i);
			 i--;
		 }
		 else break;
			 
	 }
		 
	 System.out.println(nn);
	    }
	    catch (Exception e)
	     {
	     System.out.println(e);
	     }
   
	}

}
