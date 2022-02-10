package silver;

public class Main4673 {
	public static void main(String[] args) {
		boolean[] arr = new boolean[10000];
		for(int i = 1; i <= 10000; i++) {
			int k = i;
			int sum = 0;
			sum = sum +k;
			while(true) {
				sum = sum + (k%10);
				k = k / 10;
				if (k == 0) {
					break;
				}
			}
			if(sum > 10000) {
				continue;
			}
			arr[sum-1] = true;
		}
		for(int i = 1; i <= 10000; i++) {
			if(!(arr[i-1])) {
				System.out.println(i);
			}
		}
	}
}