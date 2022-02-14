package com.ssafy.day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6808_규영이와인영이의카드게임_최종수_NextPermutation {
	
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
			for(int i = 0; i < 9; i++) {
				arr[i] = i;
			}
			do {
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
			} while(np());
			System.out.println("#" + (tc+1) + " " + Win + " " + Lose);
		}
	}
	private static boolean np() {	
		int i = 8;
		while(i > 0 && arr[i-1] >= arr[i]) {
			i--;
		}
		if(i == 0) {
			return false;
		}
		int j = 8;
		while(arr[i-1]>=arr[j]) {
			j--;
		}
		swap(i-1, j);
		int k = 8;
		while(k > i) {
			swap(k--, i++);
		}
		return true;
	}
	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}