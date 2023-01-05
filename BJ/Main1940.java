import java.util.Scanner;

public class Main1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[100001];
		int count = 0;
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			arr[x]++;
		}
		for(int i = 1; i <= 100000; i++) {
			if(arr[i] == 0 || (M - i) > 100000 || (M - i) <= 0) {
				continue;
			}
			while(arr[M-i] > 0 && arr[i] > 0) {
				if(M - i == i && arr[i] < 2) {
					break;
				}
				count++;
				arr[i]--;
				arr[M-i]--;
			}
		}
		System.out.println(count);
	}
}
