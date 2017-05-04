package Mergesort;

import java.util.Arrays;

public class SequentialOptimized {
//optimize will happen in one array initialized in the class, rather than creating a new array (combined) in every single merge
	static int[] arrayformerge;
	public static int[] sort(int[] aList, int start, int end) {
	    int length = aList.length;
	    if (length == 1) return aList; // when it is an array of 1, then we know that it is ready to merge
	    int midpoint = length / 2;
	    
	    //int[] left = Arrays.copyOfRange(aList, 0, midpoint);
	    /*System.out.println("left " + Arrays.toString(left));
	    int[] right = Arrays.copyOfRange(aList, midpoint, length);
	    System.out.println("right " + Arrays.toString(right));
	    */
	    sort(aList, start, midpoint); 
	    sort(aList, midpoint, end); 
	    return merge(aList, start, midpoint, end);
	  }
	  
	  public static int[] merge(int[] list, int start, int mid, int end) {
		int leftl = mid-start+1; 
		int rightl = end-mid; 
	    //int[] combined = new int[leftl + rightl]; don't need this since we have arrayformerge
		int length = leftl + rightl; 
	    int leftc = 0;
	    int rightc = 0;
	    for (int combinedc = 0; combinedc < length; combinedc++) {
	      if (leftc > leftl) {
	    	 
	          rightc++;
	      } else if (rightc >= rightl) {
	    	 
	          leftc++;
	      } else if (left[leftc] <= right[rightc]) {
	    	  int assign = left[leftc];
		      combined[combinedc] = assign;
		      leftc++;
	      } else {
	    	  int assign = right[rightc];
	          combined[combinedc] = assign;
	          rightc++;
	    }
	   
	  }
	    arraycopy(arrayformerge, start, list, start, length);
	    return combined;
	}

	  public static void main(String args[]) {
		  int[] test = {
				  1, 5, 2, 4, 3, 6, 7, 9
		  };
		  test = SequentialOptimized.sort(test, 0, test.length-1);
		  System.out.println("test " + Arrays.toString(test));
	}

	
}
