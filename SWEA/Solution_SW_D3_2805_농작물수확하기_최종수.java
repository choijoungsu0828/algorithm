package com.ssafy.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SW_D3_2805_농작물수확하기_최종수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] farm = new int[n][n];
			for(int i = 0; i < n; i++) {
				String str = br.readLine();
				for(int j = 0; j < n; j++) {
					farm[i][j] = (int)(str.charAt(j) - '0');
				}
			}
			int sum = 0;
			for(int i = 0; i < (n/2)+1; i++) {
				for(int j = i,cnt = 0; cnt < n-(2*i); j++,cnt++) {
					sum += farm[(n/2)-i][j];
					sum += farm[(n/2)+i][j];
				}
			}
			for(int i = 0; i < n; i++) {
				sum -= farm[(n/2)][i];
			}
			System.out.println("#" + tc + " " + sum);
		}
		
	}
}
