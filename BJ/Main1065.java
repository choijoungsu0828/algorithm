package silver;

import java.util.Scanner;

public class Main1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = 0;
		for(int i = 1; i <= n; i++) {
			if(i < 100) {
				num++;
			}
			else {
				int k = i;
				int a = 0;
				int b = 0;
				int num1 = k%10;
				k = k/10;
				int num2 = k%10;
				a = num1-num2;
				while(true) {
					num1 = k%10;
					k = k/10;
					num2 = k%10;
					b = num1-num2;
					if(a != b) {
						break;
					}
					else if(k < 10) {
						num++;
						break;
					}
				}
			}
		}
		System.out.println(num);
		sc.close();
	}
}
