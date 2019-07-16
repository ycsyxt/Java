package Sorted;

public class InsertSorted {
	public static void main(String[] args) {
		int[] arr = {1,3,4,5,2,6,9,7,8};
		int n = arr.length;
		for(int i = 1;i<n;i++){
			if(arr[i] < arr[i-1]){
				int j = i - 1;
				int t = arr[i];
				while( j>=0 && arr[j]>t){
					arr[j+1] = arr[j];
					j--;
				}
				arr[j+1] = t;
				
			}
		}
		for(int i:arr){
			System.out.print(i+"\t");
		}
	}
}
