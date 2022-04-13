package com.ssafy.day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석_최종수 {
	
	static class Magnet {
		int[] nal;
		int sc;
		int left;
		int right;
		public Magnet(int[] nal, int sc, int left, int right) {
			super();
			this.nal = nal;
			this.sc = sc;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			Magnet[] magnet = new Magnet[4];
			for(int i = 0; i < 4; i++) {
				magnet[i] = new Magnet(new int[8], 0, 6, 2);
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j++) {
					magnet[i].nal[j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				boolean[] turn = bfs(num-1, magnet);
				int oddeven = (num-1)%2;
				for(int j = 0; j < 4; j++) {
					if(turn[j]) {
						if(j%2 == oddeven) {
							move(dir, magnet[j]);
						}
						else {
							move(-dir, magnet[j]);
						}
					}
				}
			}
			int score = 0;
			for(int i = 0; i < 4; i++) {
				score += magnet[i].nal[magnet[i].sc] * (1 << i); 
			}
			System.out.println("#" + tc + " " + score);
		}
	}
	
	public static boolean[] bfs(int num, Magnet[] magnet) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[4];
		q.offer(num);
		visit[num] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur - 1 >= 0 && !visit[cur-1]) {
				if(magnet[cur].nal[magnet[cur].left] != magnet[cur-1].nal[magnet[cur-1].right]) {
					visit[cur-1] = true;
					q.offer(cur-1);
				}
			}
			if(cur + 1 < 4 && !visit[cur+1] ) {
				if(magnet[cur].nal[magnet[cur].right] != magnet[cur+1].nal[magnet[cur+1].left]) {
					visit[cur+1] = true;
					q.offer(cur+1);
				}
			}
		}
		return visit;
	}
	
	public static void move(int dir, Magnet mg) {
		if(dir == 1) {
			mg.sc = (mg.sc - 1 + 8) % 8;
			mg.left = (mg.left - 1 + 8) % 8;
			mg.right = (mg.right - 1 + 8) % 8;
		}
		else {
			mg.sc = (mg.sc + 1 + 8) % 8;
			mg.left = (mg.left + 1 + 8) % 8;
			mg.right = (mg.right + 1 + 8) % 8;
		}
	}
}
