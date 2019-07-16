package Sorted;
/*
快速排序（Quicksort）的基本思想是：
通过一趟排序将要排序的数据分割成独立的两部分，
其中一部分的所有数据都比另外一部分的所有数据都要小，
然后再按此方法对这两部分数据分别进行快速排序，
整个排序过程可以递归进行，以此达到整个数据变成有序序列。
*/
public class QuikSorted {
	public static void main(String[] args) {
		int[] arr = {1,3,4,5,2,6,9,7,8};
		int n = arr.length;
		Sorted(arr, 0, n-1);
		for(int i:arr){
			System.out.println(i);
		}
	}
	static void Sorted(int[] arr,int low,int high){
		if(low < high){
			int pos = Find(arr,low,high);
			Sorted(arr, low, pos-1);
			Sorted(arr, pos+1, high);
		}
	}
	
	static int Find(int[] arr,int left,int right){
		int val = arr[left];
		while(left<right){
	        while(left<right && arr[right] >= val){
	            right--;
	        }
	        arr[left] = arr[right];
	        
	        while(left<right && arr[left] <= val){
	            left++;
	        }
	        arr[left] = arr[right];
		}
	    arr[left] = val;
	    return left;
	}
}
