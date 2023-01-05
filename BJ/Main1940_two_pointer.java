import java.util.Scanner;

public class Main1940_two_pointer {
	private static void quickSort(int[] arr,int start, int end) {
		int part=partition(arr,start,end);
		if(start<part-1) quickSort(arr,start,part-1);
		if(end>part) quickSort(arr,part,end);
	}

	private static int partition(int[] arr,int start,int end) {
		int pivot=arr[(start+end)/2];
		while(start<=end) {
			while(arr[start]<pivot) start++;
			while(arr[end]>pivot) end--;
			if(start<=end) {
				swap(arr,start,end);
				start++;
				end--;
			}
		}
		return start;
	}

	private static void swap(int[] arr,int start,int end) {
		int tmp=arr[start];
		arr[start]=arr[end];
		arr[end]=tmp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort(arr, 0, arr.length - 1);
		int start = 0;
		int end = N - 1;
		int count = 0;
		while(start < end) {
			int sum = arr[start] + arr[end];
			if(sum == M) {
				count++;
				start++;
				end--;
			}
			else if (sum > M) {
				end--;
			}
			else {
				start++;
			}
		}
		System.out.println(count);
	}
}
