package Mergesort;

import java.util.Arrays;
import java.util.Random;

public class ConcurrentMerge extends Thread{
	
	private int[] array;
	
	public ConcurrentMerge(int[] anArray) {
		array = anArray;
	}
	 /* 
	  similar to sequential merge sort, but when calling
	  mergesort, we need to create new thrads then join 
	  at the end when we are merging
	  */

	 public static int[] sort(int[] aList) {
		 
		    int length = aList.length;
		    if (length == 1) return aList; // when it is an array of 1, then we know that it is ready to merge
		    int midpoint = length / 2;
		    
		    int[] left = Arrays.copyOfRange(aList, 0, midpoint);
		    System.out.println("left " + Arrays.toString(left));
		    int[] right = Arrays.copyOfRange(aList, midpoint, length);
		    System.out.println("right " + Arrays.toString(right));
		    
		    return merge(sort(left), sort(right));
		    
		  }
	 
	  public void mergeSort() {
		 int length = array.length;
		 if (length > 1) {
		 int midpoint = length / 2; 
		  
		 Thread firstHalf = new Thread (new Runnable () {
				public void run () {
		 
		int[] left = Arrays.copyOfRange(array, 0, midpoint);
	    System.out.println("left " + Arrays.toString(left));
	    left = sort(left);
				}
		 });
		 
		 Thread secondHalf = new Thread (new Runnable () {
				public void run () {
					
	    int[] right = Arrays.copyOfRange(array, midpoint, length);
	    System.out.println("right " + Arrays.toString(right));
	    right = sort(right);
		 }
		 });
		
	    
	    firstHalf.start();
	    secondHalf.start();
	    
	    try {
			firstHalf.join();
			secondHalf.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	  }
	  }
	  
	  public static int[] merge(int[] left, int[] right) {
		int leftl = left.length; 
		int rightl = right.length; 
	    int[] combined = new int[leftl + rightl];
	    int leftc = 0;
	    int rightc = 0;
	    for (int combinedc = 0; combinedc < combined.length; combinedc++) {
	      //System.out.println("left[] " + Arrays.toString(left));
	      //System.out.println("right[] " + Arrays.toString(right));
	      //System.out.println("comb1 " + Arrays.toString(combined));
		  //System.out.println(right[0]);
		  //System.out.println(right[rightc]);
		  //System.out.println(left[0]);
		  //System.out.println(left[rightc]);
	      if (leftc >= leftl) {
	    	  int assign = right[rightc];
	    	  //System.out.println("1! " + assign);
	          combined[combinedc] = assign;
	          rightc++;
	          //System.out.println("comb2 " + Arrays.toString(combined));
	      } else if (rightc >= rightl) {
	    	  int assign = left[leftc];
	    	  //System.out.println("2! " + assign);
	    	  combined[combinedc] = assign;
	          leftc++;
	          //System.out.println("comb2 " + Arrays.toString(combined));
	      } else if (left[leftc] <= right[rightc]) {
	    	  int assign = left[leftc];
	    	  //System.out.println("3! " + assign);
		      combined[combinedc] = assign;
		      leftc++;
		      //System.out.println("comb2 " + Arrays.toString(combined));
	      } else {
	    	  int assign = right[rightc];
	    	  //System.out.println("4! " + assign);
	          combined[combinedc] = assign;
	          rightc++;
	          //System.out.println("comb2 " + Arrays.toString(combined));
	    }
	   
	  }
	    return combined;
	}
	  
	  public static void main(String args[]) throws InterruptedException {
//		  int[] test = {
//				  1, 5, 2, 4, 3, 6, 7, 9
//		  };
		 Random number = new Random();
	     int[] test = new int[100];
	        for (int i = 0; i < test.length; i++) {
	            test[i] = number.nextInt(1000);
	        }
	      
	     long tStart = System.currentTimeMillis();
	     System.out.println("orginal " + Arrays.toString(test));
		 test = ConcurrentMerge.sort(test);
	     
	     System.out.println("finished " + Arrays.toString(test));
	     
        System.out.println("DONE");
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        System.out.println(elapsedSeconds);
	        
	}

}

