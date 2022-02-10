package com.ssafy.day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2563_색종이_최종수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[100][100];
		int cnt =0;
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 왼쪽 변과 거리
			int y = Integer.parseInt(st.nextToken()); // 아래 변과 거리
			
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					arr[x+j][y+k] = 1; 
				}
			}
		}
		for(int j = 0; j < 100; j++) {
			for(int k = 0; k < 100; k++) {
				if(arr[j][k]==1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}
}
