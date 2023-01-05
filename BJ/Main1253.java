import java.util.Arrays;
import java.util.Scanner;

public class Main1253 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] arr = new long[N];
		int count = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		for(int i = N - 1; i >= 0; i--) {
			int start = 0;
			int end = N - 1;
			while(true) {
				if(start == i) {
					start++;
				}
				if (end == i) {
					end--;
				}
				if(start >= end) {
					break;
				}
				long sum = arr[start] + arr[end];
				if(sum == arr[i]) {
					count++;
					break;
				}
				else if(sum < arr[i]) {
					start++;
				}
				else {
					end--;
				}
			}
		}
		System.out.println(count);
	}
}
