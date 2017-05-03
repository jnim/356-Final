package Bitonic;
import Bitonic.SequentialBitonic;
import Bitonic.ConcurrentBitonic; 

public class BitonicTests {
	public void main(String[] args){
	int[] a = {4, 3, 2, 1};
	SequentialBitonic Bit = new SequentialBitonic(a); 
	SequentialBitonic.sort(Bit, true); 
	Bit.print(); 
	}
	
}
