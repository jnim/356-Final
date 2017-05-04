package Bitonic; 

class SequentialBitonic{
	int[] array; 
	
	public SequentialBitonic(int[] arraytosort){
		array = arraytosort; 
	}
	
	
	static int sort(SequentialBitonic a, boolean increasing){
		BitonicSort(a.array, 0, (a.array.length -1), (a.array.length/2), increasing); //call bitonicsort of the whole thing
		//a.print(); 
		return 0; 
	}
	
	static int BitonicSort(int[] array, int start, int end, int increment, boolean increasing){
		if (increment>=1){
			BitonicSort(array, start, start+(increment), increment/2, increasing); 
			BitonicSort(array, start+(increment), end, increment/2, !increasing);
			BitonicMerge(array, start, end, increment, increasing); 
			
		}
		
		return 0; 
	}
	static int BitonicMerge(int[] array, int start, int end, int count, boolean increasing){
		while(count>=1){
			int i = start; 
			while((i + count)<= end){
				if((array[i]>array[i+count]&&increasing) ||(array[i]<array[i+count]&&!increasing)){
					int temp = array[i]; 
					array[i] = array[i + count]; 
					array[i+count] = temp; 
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
	public void main(){
		int[] a = {4, 3, 2, 1};
		SequentialBitonic Bit = new SequentialBitonic(a); 
		sort(Bit, true); 
		Bit.print(); 
		}
}