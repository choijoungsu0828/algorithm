import java.util.Scanner;

public class Main11660 {
	public static void main(String[] args) {
		int N, M;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] arr = new int[N + 1][N + 1];
		int[][] sum_arr= new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i = 1; i <= N; i++) {
			if(i == 1) {
				sum_arr[1][i] = arr[1][i];
			}
			else {
				sum_arr[1][i] = arr[1][i] + sum_arr[1][i-1];
				sum_arr[i][1] = arr[i][1] + sum_arr[i-1][1];
			}
		}
		sum_arr[1][1] = arr[1][1];
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j<= N; j++) {
				if(i == 0 || j == 0) {
					sum_arr[i][j] = 0;
				}
				else {
					sum_arr[i][j] = sum_arr[i - 1][j] + sum_arr[i][j - 1] - sum_arr[i - 1][j - 1] + arr[i][j];
				}
			}
		}
		for(int i = 0; i < M; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			System.out.println(sum_arr[x2][y2] - sum_arr[x1-1][y2] - sum_arr[x2][y1 - 1] + sum_arr[x1 - 1][y1 - 1]);
		}
	}
}
