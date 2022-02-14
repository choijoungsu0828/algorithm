package com.ssafy.day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16926_배열돌리기1_최종수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < r; i++) {
			
			int cnt = 1;
			while(true) {
				int x = m - cnt;
				int y = n - cnt;
				int temp1 = arr[y][x];
				int temp2 = 0;
				
				if(x == m-cnt && y == n-cnt) {
					while(true) {
						temp2 = arr[y-1][x];
						arr[y-1][x] = temp1;
						temp1 = temp2;
						y--;
						if(y == -1+cnt) {
							break;
						}
					}
				}
				if(x == m-cnt && y == -1+cnt) {
					while(true) {
						temp2 = arr[y][x-1];
						arr[y][x-1] = temp1;
						temp1 = temp2;
						x--;
						if(x == -1+cnt) {
							break;
						}
					}
				}
				if(x == -1+cnt && y == -1+cnt) {
					while(true) {
						temp2 = arr[y+1][x];
						arr[y+1][x] = temp1;
						temp1 = temp2;
						y++;
						if(y == n-cnt) {
							break;
						}
					}
				}
				if(x == -1+cnt && y == n-cnt) {
					while(true) {
						temp2 = arr[y][x+1];
						arr[y][x+1] = temp1;
						temp1 = temp2;
						x++;
						if(x == m-cnt) {
							break;
						}
					}
				}
				cnt++;
				if(cnt > ((n>m ? m : n)/2)) {
					break;
				}
				
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
