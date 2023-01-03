import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10986 {
	public static void main(String[] args) throws IOException {
		int N, M;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		long[] sum_arr = new long[N+1];
		long[] same_num = new long[M];
		long answer = 0l; // 답의 경우의 수 long형
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum_arr[i] = sum_arr[i - 1] + arr[i];
		}
		for(int i = 1; i <= N; i++) {
			sum_arr[i] = sum_arr[i] % M;
			same_num[(int)sum_arr[i]]++;
			if(sum_arr[i] == 0) {
				answer++;
			}
		}
		for(int i = 0; i < M; i++) {
			if(same_num[i] > 1) {
				answer += (same_num[i] * (same_num[i] - 1) / 2); // 이부분 때문에  long 필요
			}
		}
		System.out.println(answer);
	}
}