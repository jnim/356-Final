package Mergesort;

import java.util.Arrays;

public class SequentialOptimized {
//optimize will happen in one array initialized in the class, rather than creating a new array (combined) in every single merge
	static int[] arrayformerge;
	public SequentialOptimized(int[] alist) {
		SequentialOptimized.arrayformerge = new int[alist.length]; 
	}
	public int[] startsort(int[] list, int start, int end){
		sort(list, start, end); 
		return list; 
	}
	public static int[] sort(int[] list, int start, int end) {
	    int length = end-start;
	    if (length == 0) return list; // when it is an array of 1, then we know that it is ready to merge
	    int midpoint = start + (end-start)/ 2;
	    
	    //int[] left = Arrays.copyOfRange(aList, 0, midpoint);
	    /*System.out.println("left " + Arrays.toString(left));
	    int[] right = Arrays.copyOfRange(aList, midpoint, length);
	    System.out.println("right " + Arrays.toString(right));
	    */
	    sort(list, start, midpoint); 
	    sort(list, midpoint+1, end); 
	    return merge(list, start, midpoint, end);
	}
	  ;
	  public static int[] merge(int[] list, int start, int mid, int end) {
		int leftlen = mid-start+1; //not really the length, but the number of times we'll increment the counter
		int rightlen = end-(mid);  //not really the length, but the number of times we'll increment the counter
	    //int[] combined = new int[leftl + rightl]; don't need this since we have arrayformerge
		int length = leftlen + rightlen;   
	    int leftc = 0;
	    int rightc = 0;
	    for (int combinedc = 0; combinedc < length; combinedc++) {
	    	if(rightc ==rightlen) {
	    		arrayformerge[start + combinedc] = list[start+leftc]; 
	    		leftc++;
	    	}
	    		else if(leftc == leftlen) {
	    			arrayformerge[start + combinedc] = list[(mid + 1) + rightc];
	    		rightc++; 
	    		}
	    	
	    else if (list[start + leftc] <= list[(mid + 1) + rightc]) {
	    	  arrayformerge[start + combinedc] = list[start + leftc];
	    	  leftc++; 
	      }else{
	    	  arrayformerge[start+combinedc] = list[(mid + 1) + rightc]; 
	    	  rightc++; 
	      }
	      
	  }
	    
	    //https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/slice?v=control
	    for(int i = start; i<=end; i++){
	    	list[i] = arrayformerge[i]; 
	    }
	    return list; 
	  }

	  public static void main(String args[]) {
		  int[] array = {
				  1, 5, 2, 4, 3, 6, 7, 9, 4, 6, 1, 2, 0, 20, 5
		  };
		   
		  SequentialOptimized test = new SequentialOptimized(array); 
		  int[] answer = test.startsort(array, 0, array.length-1); 
		  System.out.println("test " + Arrays.toString(answer));
	}

	
}
