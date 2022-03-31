package com.ssafy.day0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1149_RGB거리_최종수 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		int[][] house = new int[n+1][3];
		int[][] dp = new int[n+1][3];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[1][0] = house[1][0];
		dp[1][1] = house[1][1];
		dp[1][2] = house[1][2];
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < 3; j++) {
				int min = Integer.MAX_VALUE;
				for(int k = 0; k < 3; k++) {
					if(j == k) {
						continue;
					}
					min = min > dp[i-1][k] ? dp[i-1][k] : min;
				}
				dp[i][j] = house[i][j] + min;
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			min = min > dp[n][i] ? dp[n][i] : min;
		}
		System.out.println(min);
	}
	
}
