package Mergesort;

import java.util.Arrays;

public class SequentialMerge{

  /* 
  split an array into two: left and right
  recursively sorted via the algorithm
  then combine the result, smallest to largest
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
  
  public static int[] merge(int[] left, int[] right) {
	int leftl = left.length; 
	int rightl = right.length; 
    int[] combined = new int[leftl + rightl];
    int leftc = 0;
    int rightc = 0;
    for (int combinedc = 0; combinedc < combined.length; combinedc++) {
      if (leftc >= leftl) {
    	  int assign = right[rightc];
          combined[combinedc] = assign;
          rightc++;
      } else if (rightc >= rightl) {
    	  int assign = left[leftc];
    	  combined[combinedc] = assign;
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
    return combined;
}

  public static void main(String args[]) {
	  int[] test = {
			  1, 5, 2, 4, 3, 6, 7, 9
	  };
	  test = SequentialMerge.sort(test);
	  System.out.println("test " + Arrays.toString(test));
}
}
