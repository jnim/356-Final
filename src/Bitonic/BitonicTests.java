package Bitonic;
import java.util.Arrays;

import Bitonic.SequentialBitonic;
import Bitonic.ConcurrentBitonic; 

public class BitonicTests {
	
	public static void main(String[] args){
	int total = 64; 
	int[] a = new int[total]; 
	int val = total; 
	for(int i = 0; i<total; i++){
		if(i%2 == 0){
			int temp = val + 30; 
			a[i] = temp; 
			val--; 
		}else{
		a[i] = val; 
		val--;
		}
	}
	System.out.println(Arrays.toString(a));// from https://www.mkyong.com/java/java-how-to-print-an-array/
	SequentialBitonic Bit = new SequentialBitonic(a); 
	SequentialBitonic.sort(Bit, true); 
	Bit.print(); 
	//Bit.correct(); 
	}
	
}
