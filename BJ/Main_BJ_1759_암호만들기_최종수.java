package com.ssafy.day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1759_암호만들기_최종수 {
	
	static int L, C;
	static char[] alp,answer;
	static boolean[] isSelected;
	static String mostr = "aeiou";
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		alp = new char[C];
		answer = new char[L];
		isSelected = new boolean[C];
		for(int i = 0; i < C; i++) {
			alp[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alp);
		combine(0, 0);
	}
	
	public static void combine(int cnt, int start) {
		if(cnt == L) {
			int monum = 0;
			int janum = 0;
			for(int i = 0; i < L; i++) {
				switch(answer[i]) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					monum++;
					break;
				default:
					janum++;
				}
			}
			if(monum > 0 && janum > 1) {
				System.out.println(answer);
			}
			return;
		}
		for(int i = start; i < C; i++) {
			answer[cnt] = alp[i];
			combine(cnt+1, i+1);
		}
	}
}
