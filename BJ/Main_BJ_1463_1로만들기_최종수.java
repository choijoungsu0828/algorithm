package com.ssafy.day0331;

import java.util.Scanner;

public class Main_BJ_1463_1로만들기_최종수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n + 1];
		dp[1] = 0;
		if(n >= 2) {
			dp[2] = 1;
		}
		if(n >= 3) {
			dp[3] = 1;
		}
		for(int i = 4; i <= n; i++) {
			long min = Long.MAX_VALUE;
			min = min > dp[i-1] + 1 ? dp[i-1] + 1 : min;
			if(i%2 == 0) {
				min = min > dp[i/2] + 1 ? dp[i/2] + 1 : min;
			}
			if(i%3 == 0) {
				min = min > dp[i/3] + 1 ? dp[i/3] + 1 : min;
			}
			dp[i] = min;
		}
		System.out.println(dp[n]);
	}
}
