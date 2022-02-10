package bronze;

public class Test15596 {
	long sum(int[] a) {
		long ans = 0l;
		for(int i = 0; i < a.length; i++) {
			ans+= a[i];
		}
		return ans;
	}
}
