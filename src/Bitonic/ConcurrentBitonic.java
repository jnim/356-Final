package Bitonic;
import Bitonic.SequentialBitonic; 
import java.util.Arrays;
import java.util.Random;

import Mergesort.ConcurrentMerge;



public class ConcurrentBitonic {
	int[] array; 

	public ConcurrentBitonic(int[] arraytosort){
		array = arraytosort; 
	}


	int sort(boolean increasing){
		ConcurrentBitonic a = this; 
		Thread Start = new Thread (new Runnable () {
			public void run () {
				BitonicSort(a, 0, (array.length -1), (array.length/2), increasing); //call bitonicsort of the whole thing
			}
		}); 
		long tStart = System.currentTimeMillis(); 
		Start.start(); 
		//a.print();

		try{
			Start.join(); 
		}catch(InterruptedException e){
			e.printStackTrace(); 
		}
		long tEnd = System.currentTimeMillis();
		long time = (tEnd - tStart); 
		//print(); 
		System.out.println(array.length + "\t" + time); 
		return 0; 
	}

	static int BitonicSort(ConcurrentBitonic a, int start, int end, int increment, boolean increasing){ 
		if (increment>1){
			if((end-start)>10000000){
				Thread First_Half = new Thread (new Runnable () {
					public void run () {
						BitonicSort(a, start, start+(increment)-1, increment/2, true); 
					}

				});
				Thread Second_Half = new Thread (new Runnable () {
					public void run () {
						BitonicSort(a, start+(increment), end, increment/2, false);
					}	
				});
				First_Half.start(); 
				Second_Half.start(); 
				try {
					; 
					First_Half.join();
					Second_Half.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else{
				BitonicSort(a, start, start+(increment)-1, increment/2, true);
				BitonicSort(a, start+(increment), end, increment/2, false);

			}
		}
		BitonicMerge(a, start, end, increment, increasing); 
		return 0; 
	}

	static int BitonicMerge(ConcurrentBitonic a, int start, int end, int count, boolean increasing){
		while(count>=1){
			int i = start; 
			while((i + count)<= end){
				if((a.array[i]>a.array[i+count]&&increasing) ||(a.array[i]<a.array[i+count]&&!increasing)){
					int temp = a.array[i]; 
					a.array[i] = a.array[i + count]; 
					a.array[i+count] = temp; 
				}
				i++; //move index up 1 to compare next pair

			}
			count = count/2; //at this point, we have reached the end of the segment we want to compare with the previous increment 
			//e.g. - we have compared all pairs in a given segment that are 2 apart. so we decrease the increment and move on. 

		}


		return 0; 
	}

	public void print(){
		System.out.println("test returned:\n"); 
		for (int i=0; (i<=(array.length-1)); i++){
			System.out.println((array[i])+ "\n"); 

		}
	}

	public boolean correct(){
		int errors = 0; 
		for (int i=1; (i<=(array.length-1)); i++){
			if(array[i]<array[i-1])
				errors++; 
		}
		if(errors==0){
			return true;
		}else{
			return false; 
		}

	}
	/*public void main(){
			int[] a = {4, 3, 2, 1};
			ConcurrentBitonic Bit = new ConcurrentBitonic(a); 
			sort(Bit, true); 
			Bit.print(); 
		}*/
	public static void main(String args[]) throws InterruptedException {

		Random number = new Random();

		int[] test1 = new int[16384];
		for (int i = 0; i < test1.length; i++) {
			test1[i] = number.nextInt(1000);
		}
		ConcurrentBitonic One = new ConcurrentBitonic(test1); 

		int[] test2 = new int[20000];
		for (int i = 0; i < test2.length; i++) {
			test2[i] = number.nextInt(1000);
		}
		ConcurrentBitonic Two = new ConcurrentBitonic(test2);

		int[] test3 = new int[30000];
		for (int i = 0; i < test3.length; i++) {
			test3[i] = number.nextInt(1000);
		}
		ConcurrentBitonic Three = new ConcurrentBitonic(test3);

		int[] test4 = new int[40000];
		for (int i = 0; i < test4.length; i++) {
			test4[i] = number.nextInt(1000);
		}
		ConcurrentBitonic Four = new ConcurrentBitonic(test4);

		int[] test5 = new int[50000];
		for (int i = 0; i < test5.length; i++) {
			test5[i] = number.nextInt(1000);
		}
		ConcurrentBitonic Five = new ConcurrentBitonic(test5);

		int[] test6 = new int[60000];
		for (int i = 0; i < test6.length; i++) {
			test6[i] = number.nextInt(1000);
		}
		ConcurrentBitonic Six = new ConcurrentBitonic(test6);

		int[] test7 = new int[70000];
		for (int i = 0; i < test7.length; i++) {
			test7[i] = number.nextInt(1000);
		}
		ConcurrentBitonic Seven = new ConcurrentBitonic(test7);

		System.out.println("Starting test \n"); 
		One.sort(true);
		//Two.sort(true); 
		//Three.sort(true);
		//Four.sort(true);
		//Five.sort(true);
		//Six.sort(true);
		//Seven.sort(true); 
		//long tEnd1 = System.currentTimeMillis();  

		/*System.out.println("orginal " + Arrays.toString(test2));
			 test2 = ConcurrentMerge.sort(test2);
		     System.out.println("finished " + Arrays.toString(test2));

		     System.out.println("orginal " + Arrays.toString(test3));
			 test3 = ConcurrentMerge.sort(test3);
		     System.out.println("finished " + Arrays.toString(test3));

		     System.out.println("orginal " + Arrays.toString(test4));
			 test4 = ConcurrentMerge.sort(test4);
		     System.out.println("finished " + Arrays.toString(test4));

		     System.out.println("orginal " + Arrays.toString(test5));
			 test5 = ConcurrentMerge.sort(test5);
		     System.out.println("finished " + Arrays.toString(test5));

		     System.out.println("orginal " + Arrays.toString(test6));
			 test6 = ConcurrentMerge.sort(test6);
		     System.out.println("finished " + Arrays.toString(test6));

	        System.out.println("DONE");
	        long tEnd = System.currentTimeMillis();
	        //long tDelta = tEnd - tStart;
	        double elapsedSeconds = tDelta / 1000.0;
	        System.out.println(elapsedSeconds);*/

	}

}
