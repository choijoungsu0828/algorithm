package com.ssafy.day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_9205_맥주마시면서걸어가기_최종수_bfs {

	static int dist = 50;
	static int beer;
	
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
			Pos start = null, end = null;
			int n = Integer.parseInt(br.readLine());
			Pos[] martList = new Pos[n];
			for(int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				if(i == 0) {
					start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}
				else if(i == n+1) {
					end = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}
				else {
					martList[i-1] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}
			}
			beer = 20;
			if(calc(start, end) <= (beer * dist)) {
				System.out.println("happy");
				break;
			}
			else {
//				visit = new boolean[n];
				boolean can = false;
				for(int i = 0; i < n; i++) {
					if(calc(start, martList[i]) <= (beer * dist)) {
						can = bfs(i, martList, end);
					}
					if(can) {
						System.out.println("happy");
						break;
					}
				}
				if(!can) {
					System.out.println("sad");
				}
			}
		}
	}
	
	public static boolean bfs(int num, Pos[] martList, Pos end) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[martList.length];
		q.offer(num);
		visit[num] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(calc(end, martList[cur]) <= (beer * dist)) {
				return true;
			}
			for(int i = 0; i < martList.length; i++) {
				if(visit[i]) {
					continue;
				}
				if(calc(martList[i], martList[cur]) <= (beer * dist)) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
		
		
		return false;
	}
	
	public static int calc(Pos p1, Pos p2) {
		return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
	}
}
