package Sorted;

import yxt.ycs.test_import;

public class SelectSorted {
	public static void main(String[] args) {
		int[] arr = {1,3,4,5,2,6,9,7,8};
		int n = arr.length;
		for(int i=0;i<n;i++){
			int min = i;
			for(int j=i+1;j<n;j++){
				if(arr[j]<arr[min]){
					min=j;
				}
			}
			if(i != min){
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		for(int i:arr){
			System.out.println(i);
		}
	}
}
