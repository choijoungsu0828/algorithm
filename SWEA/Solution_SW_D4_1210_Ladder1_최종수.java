package com.ssafy.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_D4_1210_Ladder1_최종수 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] data = new int[100][100];
		for(int i = 0; i < 1; i++) {
			int tc = Integer.parseInt(br.readLine());
			boolean right = false;
			boolean left = false;
			int answer = 0;
			// 사다리 입력 (2차원 배열)
			for(int j = 0; j < 100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0; k < 100; k++) {
					data[j][k] = Integer.parseInt(st.nextToken()); 
				}
			}
			// 출발점 서치
			int x = 0, y = 0;
			for(int start = 0; start < 100; start++) { 
				if(data[99][start] == 2) { 
					x = 99;
					y = start;
					break;
				}
			}
			// 길따라 쭉 진행
			while(true) {
				if(x == 0) { // 맨 위 도착하면
					answer = y;
					break;
				}
				if(y-1 >= 0 && !right) { // 왼쪽으로 갈것인가
					if(data[x][y-1] == 1) {
						left = true;
						y = y-1;
						continue;
					}
				}
				if(y+1 < 100 && !left) { // 오른쪽으로 갈것인가
					if(data[x][y+1] == 1) {
						right = true;
						y = y+1;
						continue;
					}
				}
				// 왼쪽 오른쪽이 아니라면 위로 진행
				left = false;
				right = false;
				x = x-1;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
