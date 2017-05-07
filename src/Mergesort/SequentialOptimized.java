package Mergesort;

import java.util.Arrays;

public class SequentialOptimized {
//optimize will happen in one array initialized in the class, rather than creating a new array (combined) in every single merge
	static int[] arrayformerge;
	public static int[] sort(int[] aList, int start, int end) {
	    int length = end-start;
	    if (length == 0) return aList; // when it is an array of 1, then we know that it is ready to merge
	    int midpoint = start + (end-start)/ 2;
	    
	    //int[] left = Arrays.copyOfRange(aList, 0, midpoint);
	    /*System.out.println("left " + Arrays.toString(left));
	    int[] right = Arrays.copyOfRange(aList, midpoint, length);
	    System.out.println("right " + Arrays.toString(right));
	    */
	    sort(aList, start, midpoint); 
	    sort(aList, midpoint+1, end); 
	    return merge(aList, start, midpoint, end);
	  }
	  
	  public static int[] merge(int[] list, int start, int mid, int end) {
		int leftlen = mid-start + 1; //not really the length, but the number of times we'll increment the counter
		int rightlen = end-(mid+1);  //not really the length, but the number of times we'll increment the counter
	    //int[] combined = new int[leftl + rightl]; don't need this since we have arrayformerge
		int length = leftlen + rightlen; 
	    int leftc = 0;
	    int rightc = 0;
	    for (int combinedc = 0; combinedc <= length; combinedc++) {
	    	if(rightc ==rightlen) {
	    		arrayformerge[start + combinedc] = list[start+leftc]; 
	    		leftc++;
	    	}
	    		else if(leftc == leftlen) {
	    			arrayformerge[start + combinedc] = list[(mid + 1) + rightc];
	    		leftc++; 
	    		}
	    	
	    else if (list[start + leftc] <= list[(mid + 1) + rightc]) {
	    	  arrayformerge[start + combinedc] = list[start + leftc];
	    	  leftc++; 
	      }else{
	    	  arrayformerge[start+combinedc] = list[(mid + 1) + rightc]; 
	    	  rightc++; 
	      }
	      
	  }
	    
	    System.arraycopy(arrayformerge, start, list, start, length); //http://stackoverflow.com/questions/7882074/how-do-you-set-one-arrays-values-to-another-arrays-values-in-java
	    return list; 
	  }

	  public static void main(String args[]) {
		  int[] test = {
				  1, 5, 2, 4, 3, 6, 7, 9
		  };
		  test = SequentialOptimized.sort(test, 0, test.length-1);
		  System.out.println("test " + Arrays.toString(test));
	}

	
}
