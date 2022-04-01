package com.ssafy.day0401;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_4485_녹색옷입은애가젤다지_최종수_fail {
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static int N;
	
	public static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int cnt = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) {
				break;
			}
			int[][] map = new int[N][N];
			int[][] dp = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(map, dp);
			cnt ++;
			System.out.println("Problem " + cnt + ": " + dp[N-1][N-1]);
		}
	}
	public static void bfs(int[][] map, int[][] dp) {
		Pos p = new Pos(0, 0);
		dp[0][0] = map[0][0];
		Queue<Pos> q = new LinkedList<>();
		q.offer(p);
		while(!q.isEmpty()) {
			Pos p_cur = q.poll();
			for(int i = 0; i < 4; i++) {
				if(p_cur.r + dr[i] < 0 || 
						p_cur.c + dc[i] < 0 || 
						p_cur.r + dr[i] >= N || 
						p_cur.c + dc[i] >= N ) {
					continue;
				}
				if(dp[p_cur.r + dr[i]][p_cur.c + dc[i]] != 0) {
					if(dp[p_cur.r + dr[i]][p_cur.c + dc[i]] > 
					dp[p_cur.r][p_cur.c] + map[p_cur.r + dr[i]][p_cur.c + dc[i]]) {
						dp[p_cur.r + dr[i]][p_cur.c + dc[i]] = dp[p_cur.r][p_cur.c] + map[p_cur.r + dr[i]][p_cur.c + dc[i]];
						q.add(new Pos(p_cur.r + dr[i], p_cur.c + dc[i]));
					}
				}
				else if(dp[p_cur.r + dr[i]][p_cur.c + dc[i]] == 0) {
					dp[p_cur.r + dr[i]][p_cur.c + dc[i]] = dp[p_cur.r][p_cur.c] + map[p_cur.r + dr[i]][p_cur.c + dc[i]];
					q.add(new Pos(p_cur.r + dr[i], p_cur.c + dc[i]));
				}
			}
		}
	}
}
