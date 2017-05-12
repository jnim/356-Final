package Mergesort;

import java.util.Arrays;

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
		//System.out.println("left " + Arrays.toString(left));
		int[] right = Arrays.copyOfRange(aList, midpoint, length);
		//System.out.println("right " + Arrays.toString(right));

		return merge(mergeSort(left), mergeSort(right)); // changed to mergeSort

	}

	public static int[] mergeSort(int[] aList) {
		int length = aList.length;
		if (length == 1) return aList;
		//if (length > 1) {
			int midpoint = length / 2; 
		

			Thread firstHalf = new Thread (new Runnable () {
				public void run () {

					int[] left = Arrays.copyOfRange(aList, 0, midpoint);
					//System.out.println("left " + Arrays.toString(left));
					left = mergeSort(left);
				}
			});


			Thread secondHalf = new Thread (new Runnable () {
				public void run () {

					int[] right = Arrays.copyOfRange(aList, midpoint, length);
					//System.out.println("right " + Arrays.toString(right));
					right = mergeSort(right);
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

		//}
			
			int[] left = Arrays.copyOfRange(aList, 0, midpoint);
			int[] right = Arrays.copyOfRange(aList, midpoint, length);
		
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

	public static void main(String args[]) throws InterruptedException {

		Random number = new Random();
		int[] test1 = new int[100];
		for (int i = 0; i < test1.length; i++) {
			test1[i] = number.nextInt(1000);
		}

		int[] test2 = new int[500];
		for (int i = 0; i < test2.length; i++) {
			test2[i] = number.nextInt(1000);
		}

		int[] test3 = new int[1000];
		for (int i = 0; i < test3.length; i++) {
			test3[i] = number.nextInt(1000);
		}

		int[] test4 = new int[1500];
		for (int i = 0; i < test4.length; i++) {
			test4[i] = number.nextInt(1000);
		}

		long tStart = System.currentTimeMillis();
		//System.out.println("original " + Arrays.toString(test1));
		test1 = ConcurrentMerge.sort(test1);
		
		System.out.println("finished " + Arrays.toString(test1));
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		double elapsedSeconds = tDelta / 1000.0;
		System.out.println(elapsedSeconds);

	
		tStart = System.currentTimeMillis();
		// System.out.println("original " + Arrays.toString(test2));
		test2 = ConcurrentMerge.sort(test2);
		 System.out.println("finished " + Arrays.toString(test2));
		tEnd = System.currentTimeMillis();
		tDelta = tEnd - tStart;
		elapsedSeconds = tDelta / 1000.0;
		System.out.println(elapsedSeconds);

		tStart = System.currentTimeMillis();
		// System.out.println("original " + Arrays.toString(test3));
		test3 = ConcurrentMerge.sort(test3);
		 System.out.println("finished " + Arrays.toString(test3));
		tEnd = System.currentTimeMillis();
		tDelta = tEnd - tStart;
		elapsedSeconds = tDelta / 1000.0;
		System.out.println(elapsedSeconds);

		tStart = System.currentTimeMillis();
		// System.out.println("original " + Arrays.toString(test4));
		test4 = ConcurrentMerge.sort(test4);
		System.out.println("finished " + Arrays.toString(test4));
		tEnd = System.currentTimeMillis();
		tDelta = tEnd - tStart;
		elapsedSeconds = tDelta / 1000.0;
		System.out.println(elapsedSeconds);


		//	 	System.out.println("Running concurrent test");
		//		int max = 1000000; 
		//		for(int i = 50000; i<=max; i = i + 50000){
		//			Random number = new Random();
		//		  
		//			int[] test1 = new int[i];
		//	       for (int j = 0; j < i; j++) {
		//	           test1[j] = number.nextInt(1000);
		//	       }
		//	       test1 = ConcurrentMerge.sort(test1);
		//		}

		System.out.println("DONE");
		//        long tEnd = System.currentTimeMillis();
		//        long tDelta = tEnd - tStart;
		//        double elapsedSeconds = tDelta / 1000.0;
		//        System.out.println(elapsedSeconds);

	}

}
