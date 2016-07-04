package edu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class task332 {
	static String result(long temp,long nnn)
	{
	  double temp1 = (new Long(temp)).doubleValue();
	  long masNumber[ ] = { 0,0,0,0 };
	  long sum = 0;
	  String res = null;
	  
	    int j = 0;
	   do{
	     long x1 = (new Double(Math.sqrt(temp1))).longValue();
	     for( int i = 0; i < 4; i++) {
	    	 sum += ( masNumber[i] * masNumber[i] );
	     }
	     if( ( sum+x1*x1 <= nnn ) && ( j<4 ) ) {
	     masNumber[j] = x1;
	     sum = 0;
	     for( int i = 0; i < 4; i++) {
	    	 sum += ( masNumber[i] * masNumber[i] );
	     }
	     temp = nnn - sum;
	     temp1 = (new Long(temp)).doubleValue();
	     
	     j++;
	     sum = 0;
	     } else {
	    	 break;     
	     }
	   }
	   while( ( temp != 0 ) || ( j == 3 ) );
	   if( temp == 0 ) {
	    return res = masNumber[0] +" "+ masNumber[1] +" "+
		         masNumber[2] +" "+ masNumber[3];
	   }
	   else {
		   return res="null";
	   }
	    
	}
	public static void main(String[ ] args) throws Exception    
	{
	    try{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 String answer = null;
	 do{
	 System.out.println("Введіть число n:");
	 String n = br.readLine();
	 double nn = Double.parseDouble(n); 
	 long nnn = Long.parseLong(n);
	 
	 List <String> result = new ArrayList<String>();;
	 for( int i = 1; i <= nnn; i++) {
		 String res1 = result(nnn/i,nnn); 
		 if (!res1.equals("null")) {
			 if(result.isEmpty()) {
				 result.add(res1); 
			 } else {
				 int count = 0;
				 for(int j=0;j<result.size();j++) {
					 if( result.get(j).equals(res1) ) {
						 count++;
					 } 
				 }
				 if( count == 0 ) {
					 result.add(res1);
					 System.out.println(res1);
				 }
			 }
		}
	 }
	
	 System.out.println("Для ще однієї ітерації натисніть 1:");
	 answer=br.readLine();
	 }while(answer.equals("1"));
	    }
	    catch (Exception e)
	     {
	     System.out.println(e);
	     }

	  
	  
	     
	   
	}
}
