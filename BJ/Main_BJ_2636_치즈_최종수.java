package com.ssafy.day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2636_치즈_최종수 {	
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int R;
	static int C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int[][] pan = new int[R][C];
		int cnt = 0;
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
				if(pan[i][j] == 1) {
					cnt++;
				}
			}
		}
		boolean[][] melt = new boolean[R][C];
		int time = 0;
		int cnt_before = 0;
		while(true) {
			cnt_before = cnt;
			dfs(0, 0, pan, melt);
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(melt[i][j]) {
						pan[i][j] = 0;
						cnt--;
					}
					if(pan[i][j] == 3) {
						pan[i][j] = 0;
					}
					melt[i][j] = false;
				}
			}
			time++;
			if(cnt == 0) {
				break;
			}
		}
		System.out.println(time);
		System.out.println(cnt_before);
	}
	
	public static void dfs(int r, int c, int[][] pan, boolean[][] melt) {
		pan[r][c] = 3;
		for(int i = 0; i < 4; i++) {
			if(isAvailable(r + dr[i], c + dc[i], pan)) {
				if(pan[r + dr[i]][c + dc[i]] == 0) {
					dfs(r + dr[i], c + dc[i], pan, melt);	
				}
				else if(pan[r + dr[i]][c + dc[i]] == 1) {
					melt[r + dr[i]][c + dc[i]] = true;
				}
			}
		}
	}
	
	public static boolean isAvailable(int r, int c, int[][] pan) {
		if(r < 0 || r >= R || c < 0 || c >= C) {
			return false;
		}
		return true;
	}
}
