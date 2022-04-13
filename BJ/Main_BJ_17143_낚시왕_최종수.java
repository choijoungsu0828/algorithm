package com.ssafy.day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17143_낚시왕_최종수 {
	
	static int R, C;
	
	static class Shark{
		int r;
		int c;
		int s;
		int d;
		int z;
		int idx;
		public Shark(int r, int c, int s, int d, int z, int idx) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Shark[] sharkList = new Shark[M];
		Shark[][] sea = new Shark[R+1][C+1];
		int answer = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Shark s = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
			sea[s.r][s.c] = s;
			sharkList[i] = s;
		}
		for(int i = 1; i <= C; i++) {
			// 낚시꾼이 상어 잡기
			for(int j = 1; j <= R; j++) {
				if(sea[j][i] != null) {
					Shark s = sea[j][i];
					sharkList[s.idx] = null;
					sea[j][i] = null;
					answer += s.z;
					break;
				}
			}
			// 상어 이동
			for(int j = 0; j < M; j++) {
				if(sharkList[j] == null) {
					continue;
				}
				Shark s = sharkList[j];
				move(s);
			}
			sea = new Shark[R+1][C+1];
			
			for(int j = 0; j < M; j++) {
				if(sharkList[j] == null) {
					continue;
				}
				Shark s = sharkList[j];
				if(sea[s.r][s.c] != null) {
					if(s.z > sea[s.r][s.c].z) {
						sharkList[sea[s.r][s.c].idx] = null;
						sea[s.r][s.c] = s;
					}
					else {
						sharkList[s.idx] = null;
					}
				}
				else {
					sea[s.r][s.c] = s;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void move(Shark s) {
		if((s.d == 1 && s.r == 1) || (s.d == 2 && s.r == R)) {
			s.d = 3 - s.d;
		}
		if((s.d == 3 && s.c == C) || (s.d == 4 && s.c == 1)) {
			s.d = 7 - s.d;
		}
		for(int i = 0; i < s.s; i++) {
			switch(s.d) {
			case 1:
				s.r--;
				if(s.r == 1) {
					s.d = 3 - s.d;
				}
				break;
			case 2:
				s.r++;
				if(s.r == R) {
					s.d = 3 - s.d;
				}
				break;
			case 3:
				s.c++;
				if(s.c == C) {
					s.d = 7 - s.d;
				}
				break;
			case 4:
				s.c--;
				if(s.c == 1) {
					s.d = 7 - s.d;
				}
				break;
			}
		}
	}
}
