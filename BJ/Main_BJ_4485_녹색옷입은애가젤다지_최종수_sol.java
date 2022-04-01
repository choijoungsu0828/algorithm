package com.ssafy.day0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_4485_녹색옷입은애가젤다지_최종수_sol {
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static class Pos implements Comparable<Pos> {
		
		int r;
		int c;
		int k;		
		
		public Pos(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}

		@Override
		public int compareTo(Pos o) {
			// TODO Auto-generated method stub
			return this.k - o.k;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n;
		int [][] map, distance;
		boolean [][] visited;
		int tc = 1;
		PriorityQueue<Pos> pq;
		while(true) {
			pq = new PriorityQueue<>();
			n = Integer.parseInt(br.readLine());
			if(n == 0) {
				break;
			}
			map = new int[n][n];
			distance = new int[n][n];
			visited = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			pq.offer(new Pos(0, 0, map[0][0]));
			while(!pq.isEmpty()) {
				Pos p = pq.poll();
				distance[p.r][p.c] = Math.min(distance[p.r][p.c], p.k);
				visited[p.r][p.c] = true;
				for(int i = 0; i < 4; i++) {
					if(p.r + dr[i] < 0 || p.c + dc[i] < 0 || p.r + dr[i] >= n || p.c + dc[i] >= n || visited[p.r + dr[i]][p.c + dc[i]]) {
						continue;
					}
					if(distance[p.r + dr[i]][p.c + dc[i]] > distance[p.r][p.c] + map[p.r + dr[i]][p.c + dc[i]]) {
						distance[p.r + dr[i]][p.c + dc[i]] = distance[p.r][p.c] + map[p.r + dr[i]][p.c + dc[i]];
						pq.offer(new Pos(p.r + dr[i], p.c + dc[i], p.k + map[p.r + dr[i]][p.c + dc[i]]));
					}
				}
			}
			System.out.println("Problem " + tc + ": " + distance[n-1][n-1]);
		}
	}
}
