package Mergesort;

import java.util.Arrays;

public class SequentialMerge {
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
      System.out.println("left[] " + Arrays.toString(left));
      System.out.println("right[] " + Arrays.toString(right));
      System.out.println("comb1 " + Arrays.toString(combined));
	 // System.out.println(right[0]);
	  //System.out.println(right[rightc]);
	  //System.out.println(left[0]);
	  //System.out.println(left[rightc]);
      if (leftc >= (left.length - 1)) {
    	  int assign = right[rightc];
    	  System.out.println("1! " + assign);
          combined[combinedc] = assign;
          rightc++;
          System.out.println("comb2 " + Arrays.toString(combined));
      } else if (rightc >= (right.length - 1)) {
    	  int assign = left[leftc];
    	  System.out.println("2! " + assign);
    	  combined[combinedc] = assign;
          leftc++;
          System.out.println("comb2 " + Arrays.toString(combined));
      } else if (left[leftc] <= right[rightc]) {
    	  int assign = left[leftc];
    	  System.out.println("3! " + assign);
	      combined[combinedc] = assign;
	      leftc++;
	      System.out.println("comb2 " + Arrays.toString(combined));
      } else {
    	int assign = right[rightc];
    	System.out.println("4! " + assign);
        combined[combinedc] = assign;
        rightc++;
        System.out.println("comb2 " + Arrays.toString(combined));
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
