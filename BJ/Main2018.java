import java.util.Scanner;

public class Main2018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		int start = 0;
		int end = 0;
		int sum = arr[0];
		int count = 0;
		while(true) {
			if(sum < N) {
				end++;
				sum += arr[end];
			}
			else if(sum > N) {
				sum -= arr[start];
				start++;
			}
			else {
				count++;
				end++;
				if(end == N) {
					break;
				}
				sum += arr[end];
			}
		}
		System.out.println(count);
	}
}
