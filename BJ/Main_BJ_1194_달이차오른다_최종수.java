package com.ssafy.day0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1194_달이차오른다_최종수 {
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static boolean[][][] visited;
	
	static int N, M;
	
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int rs = 0, cs = 0;
		char[][] miro = new char[N][M];
		visited = new boolean[N][M][64];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				miro[i][j] = str.charAt(j);
				if(miro[i][j] == '0') {
					rs = i; 
					cs = j;
				}
			}
		}
		
		// 길찾기
		Queue<Pos> q = new LinkedList<>();
		visited[rs][cs][0] = true;
		q.offer(new Pos(rs, cs, 0));
		int cnt = 0;
		while(true) {
			int size = q.size();
			if(size == 0) {
				System.out.println("-1");
				break;
			}
			for(int j = 0; j < size; j++) {
				Pos p = q.poll();
				int r = p.r;
				int c = p.c;
				int k = p.k;
				if(miro[r][c] == '1') {
					System.out.println(cnt);
					return;
				}
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					int nk = k;
					if(!isAvailable(nr, nc) || 
							visited[nr][nc][nk] || 
							miro[nr][nc] == '#') {
						continue;
					}
					else if(miro[nr][nc] - 'A' >= 0 && miro[nr][nc] - 'A' < 6) {
						if((nk & (1 << (miro[nr][nc] - 'A'))) == 0) {
							continue;
						}
						q.add(new Pos(nr, nc, nk));
						visited[nr][nc][nk] = true;
					}
					else if(miro[nr][nc] - 'a' >= 0 && miro[nr][nc] - 'a' < 6) {
						nk = nk | (1 << (miro[nr][nc] - 'a'));
						q.add(new Pos(nr, nc, nk));
						visited[nr][nc][nk] = true;
					}
					else {
						q.add(new Pos(nr, nc, nk));
						visited[nr][nc][nk] = true;
					}
				}
			}
			cnt++;
		}
	}
	
	public static boolean isAvailable(int nr, int nc) {
		if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
			return false;
		}
		return true;
	}
}
