package bronze;

import java.util.Scanner;

public class Main2605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			int k = sc.nextInt();
			for(int j = i; j > i-k; j--) {
				arr[j] = arr[j-1];
			}
			arr[i-k] = i+1;
		}
		for(int i : arr) {
			System.out.print(i + " ");
		}
		sc.close();
	}
}
