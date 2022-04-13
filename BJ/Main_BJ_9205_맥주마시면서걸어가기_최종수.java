package com.ssafy.day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_9205_맥주마시면서걸어가기_최종수 {
	
//	static boolean[] visit;
	
	static class Pos {
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
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			Pos[] martList = new Pos[n+2];
			for(int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				martList[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			int[][] dist = new int[n+2][n+2];
			for(int i = 0; i < n+2; i++) {
				for(int j = 0; j < n+2; j++) {
					if(i == j) {
						dist[i][j] = 0;
					}
					else if(calc(martList[i], martList[j]) > 1000) {
						dist[i][j] = Integer.MAX_VALUE;
					}
					else {
						dist[i][j] = calc(martList[i], martList[j]);
					}
				}
			}
			
			for(int k = 0; k < n + 2; k++) {
				for(int i = 0; i < n + 2; i++) {
					for(int j = 0; j < n + 2; j++) {
						if(i == k || k == j || i == j) {
							continue;
						}
						if(dist[i][k] == Integer.MAX_VALUE ||
								dist[k][j] == Integer.MAX_VALUE) {
							continue;
						}
						if(dist[i][j] > dist[i][k] + dist[k][j]) {
							dist[i][j] = dist[i][k] + dist[k][j];
						}
					}
				}
			}
			if(dist[0][n+1] != Integer.MAX_VALUE) {
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
			
		}
	}
	
	public static int calc(Pos p1, Pos p2) {
		return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
	}
}
