import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1018_S4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = null;
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] map = new char[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(sc.nextLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		for(int i = 0; i < N-7; i++) {
			for(int j = 0; j < M-7; j++) {

			}
		}
	}
}
