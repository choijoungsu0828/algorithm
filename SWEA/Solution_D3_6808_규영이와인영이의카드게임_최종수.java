package com.ssafy.day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6808_규영이와인영이의카드게임_최종수 {
	
	static boolean[] isSelectedP = new boolean[9];
	static int[] arr = new int[9];
	static int[] arrG = new int[9];
	static int[] arrI = new int[9];
	static int Win,Lose,scoreG,scoreI;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isSelected = new boolean[18];
 		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++) {
			Win = 0;
			Lose = 0;
			scoreG = 0;
			scoreI = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				int k = Integer.parseInt(st.nextToken());
				arrG[i] = k;
				isSelected[k-1] = true;
			}
			int cnt = 0;
			for(int i = 0; i < 18; i++) {
				if(!isSelected[i]) {
					arrI[cnt++] = i+1;
				}
				isSelected[i] = false;
			}
			permutation(0);
			System.out.println("#" + (tc+1) + " " + Win + " " + Lose);
		}
	}
	public static void permutation(int cnt) {
		if(cnt == 9) {
			scoreG = 0;
			scoreI = 0;
			for(int i = 0; i < 9; i++) {
				if(arrG[i] > arrI[arr[i]]) {
					scoreG += (arrG[i] + arrI[arr[i]]);
				}
				else {
					scoreI += (arrG[i] + arrI[arr[i]]);
				}
			}
			if(scoreG > scoreI) {
				Win++;
			}
			else if(scoreG < scoreI) {
				Lose++;
			}
			return;
		}
		for(int i = 0; i < 9; i++) {
			if(isSelectedP[i]) {
				continue;
			}
			arr[cnt] = i;
			isSelectedP[i] = true;
			permutation(cnt+1);
			isSelectedP[i] = false;
		}
	}
}
