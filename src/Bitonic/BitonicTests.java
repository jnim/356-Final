package Bitonic;
import java.util.Arrays;
import java.util.Random;

import Bitonic.SequentialBitonic;
import Bitonic.ConcurrentBitonic; 

public class BitonicTests {
	
	public static void main(String[] args){
	//String testtype = "Both"; 
	String testtype = "Concurrent"; 
	//String testtype = "Sequential"; 
	//System.out.println(Arrays.toString(a));// from https://www.mkyong.com/java/java-how-to-print-an-array/
	int max = 1330000000; // 1024*1024*1024; 
	if(testtype == "Sequential" || testtype == "Both"){
	System.out.println("\nRunning sequential test\n"); 
	for(Integer i = 2; i<=max; i = i*2){
		Random number = new Random();
	  
		int[] test1 = new int[i];
       for (int j = 0; j < i; j++) {
           test1[j] = (j*(i/2+13))%i; // number.nextInt(1000);
       }
       SequentialBitonic Bit = new SequentialBitonic(test1); 
       SequentialBitonic.sort(Bit, true); 
       if(Bit.correct()){
    	   System.out.println("Correct!");
       }else{
    	   System.out.println("Bad job! ============================================="); 
    	   Bit.print(); 
       }
       //Bit.print(); 
	}
	}
	
	if(testtype == "Concurrent" || testtype == "Both"){
	System.out.println("\nRunning concurrent test\n");
	for(Integer i = 2; i<=max; i = i*2){
		Random number = new Random();
	  
		int[] test1 = new int[i];
       for (int j = 0; j < i; j++) {
           test1[j] = (j*(i/2+13))%i; // number.nextInt(1000);
       }
       ConcurrentBitonic Bit = new ConcurrentBitonic(test1); 
       System.out.println("Starting sort");
       Bit.sort(true); 
       System.out.println("All done sort");
       if(Bit.correct()){
    	   System.out.println("Correct!");
       }else{
    	   System.out.println("Bad job! =============================================");
    	   if(i<1025)
    		   Bit.print(); 
       }
       //Bit.print(); 
	}
	
	}
	}
}
