package Bitonic;
import java.util.Arrays;
import java.util.Random;

import Bitonic.SequentialBitonic;
import Bitonic.ConcurrentBitonic; 

public class BitonicTests {
	
	public static void main(String[] args){
	String testtype = "Concurrent"; 
	//String testtype = "Sequential"; 
	int total = 64; 
	int[] a = new int[total]; 
	int val = total; 
	for(int i = 0; i<total; i++){
		if(i%2 == 0){
			int temp = (val*2)-15; 
			a[i] = temp; 
			val--; 
		}else{
		a[i] = val; 
		val--;
		}
	}
	//System.out.println(Arrays.toString(a));// from https://www.mkyong.com/java/java-how-to-print-an-array/
	if(testtype == "Sequential"){
	System.out.println("Running sequential test"); 
	int max = 2000; 
	for(int i = 2000; i<=max; i = i + 10000){
		Random number = new Random();
	  
		int[] test1 = new int[i];
       for (int j = 0; j < i; j++) {
           test1[j] = number.nextInt(1000);
       }
       SequentialBitonic Bit = new SequentialBitonic(test1); 
       SequentialBitonic.sort(Bit, true); 
       Bit.print(); 
	}
	}
	
	else if(testtype == "Concurrent"){
	System.out.println("Running concurrent test");
	int max = 1000000; 
	for(int i = 50000; i<=max; i = i + 50000){
		Random number = new Random();
	  
		int[] test1 = new int[i];
       for (int j = 0; j < i; j++) {
           test1[j] = number.nextInt(1000);
       }
       ConcurrentBitonic Bit = new ConcurrentBitonic(test1); 
       Bit.sort(true); 
       //Bit.print(); 
	}
	
	}
	}
}
