package com.ssafy.day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1600_말이되고픈원숭이_최종수 {
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[] dr_h = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dc_h = {2, 1, -1, -2, -2, -1, 1, 2};
	
	static int K, W, H, Cnt = -1;
	
	static int[][] map;
	
	static boolean[][][] visited;
	
	static class Pos {
		int r;
		int c;
		int k;
		
		public Pos(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(new Pos(0, 0, K));
	}
	
	public static void bfs(Pos p) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(p);
		visited[p.r][p.c][p.k] = true;
		while(!q.isEmpty()) {
			Cnt++;
			int size = q.size();
			for(int j = 0; j < size; j++) {
				Pos cur_p = q.poll();
				int r = cur_p.r;
				int c = cur_p.c;
				int k = cur_p.k;
				if(r == H - 1 && c == W -1) {
					System.out.println(Cnt);
					return;
				}
				for(int i = 0; i < 4; i++) {
					if(isAvailable(r + dr[i], c + dc[i]) 
							&& map[r + dr[i]][c + dc[i]] != 1 
							&& !visited[r + dr[i]][c + dc[i]][k]) {
						q.offer(new Pos(r + dr[i], c + dc[i], k));
						visited[r + dr[i]][c + dc[i]][k] = true;
					}
				}
				if(k > 0) {
					for(int i = 0; i < 8; i++) {
						if(isAvailable(r + dr_h[i], c + dc_h[i]) 
								&& map[r + dr_h[i]][c + dc_h[i]] != 1 
								&& !visited[r + dr_h[i]][c + dc_h[i]][k - 1]) {
							q.offer(new Pos(r + dr_h[i], c + dc_h[i], k - 1));
							visited[r + dr_h[i]][c + dc_h[i]][k-1] = true;
						}
					}
				}
			}
		}
		System.out.println("-1");
	}
	
	public static boolean isAvailable(int r, int c) {
		if(r < 0 || r >= H || c < 0 || c >= W) {
			return false;
		}
		return true;
	}
}
