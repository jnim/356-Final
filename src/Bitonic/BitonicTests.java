package Bitonic;
import java.util.Arrays;

import Bitonic.SequentialBitonic;
import Bitonic.ConcurrentBitonic; 

public class BitonicTests {
	
	public static void main(String[] args){
	String testtype = "Concurrent"; 
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
	System.out.println(Arrays.toString(a));// from https://www.mkyong.com/java/java-how-to-print-an-array/
	if(testtype == "Sequential"){
	System.out.println("Running sequential test"); 
	SequentialBitonic Bit = new SequentialBitonic(a); 
	SequentialBitonic.sort(Bit, true); 
	Bit.print(); 
	//Bit.correct(); 
	}
	
	else if(testtype == "Concurrent"){
	System.out.println("Running concurrent test"); 
	ConcurrentBitonic Bit = new ConcurrentBitonic(a); 
	ConcurrentBitonic.sort(Bit, true); 
	Bit.print(); 
	}
	
	}	
}
