package bronze;

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2605_LinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new LinkedList<>();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int k = sc.nextInt();
			list.add(i-k, i+1);
		}
		for(int i : list) {
			System.out.print(i + " ");
		}
		sc.close();
	}
}
