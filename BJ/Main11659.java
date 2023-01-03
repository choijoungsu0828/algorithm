import java.util.Scanner;

public class Main11659 {
	public static void main(String[] args) {
		int N, M;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] num = new int[N + 1];
		int[] sum_arr = new int[N + 1];
		num[0] = 0;
		sum_arr[0] = 0;
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			num[i] = sc.nextInt();
			sum += num[i];
			sum_arr[i] = sum;
		}
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt();
			System.out.println(sum_arr[b] - sum_arr[a]);
		}
	}
}
