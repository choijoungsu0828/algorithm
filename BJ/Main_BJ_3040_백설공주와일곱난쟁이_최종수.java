package com.ssafy.day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_3040_백설공주와일곱난쟁이_최종수 {
	
	static int[] Num = new int[9];
	static int[] Idx = new int[7];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++) {
			Num[i] = Integer.parseInt(br.readLine());
		}
		combine(0,0);
	}
	public static void combine(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += Num[Idx[i]];
			}
			if(sum == 100) {
				for(int i = 0; i < 7; i++) {
					System.out.println(Num[Idx[i]]);
				}
			}
			return;
		}
		for(int i = start; i < 9; i++) {
			Idx[cnt] = i;
			combine(cnt+1, i+1);
		}
	}
}
