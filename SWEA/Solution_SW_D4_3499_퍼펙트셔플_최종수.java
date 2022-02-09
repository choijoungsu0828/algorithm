package com.ssafy.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_D4_3499_퍼펙트셔플_최종수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] deck = new String[num];
			for(int i = 0; i < num; i++) {
				deck[i] = st.nextToken();
			}
			String[] shuffleDeck = new String[num];
			if(num%2 == 1) {
				for(int i = 1; i <= num/2; i++) {
					
					shuffleDeck[(2*i)-2] = deck[i-1];
					shuffleDeck[(2*i)-1] = deck[(i-1)+(num/2)+1];
				}
				shuffleDeck[num-1] = deck[num/2];
			}
			else {
					for(int i = 1; i <= num/2; i++) {
					shuffleDeck[(2*i)-2] = deck[i-1];
					shuffleDeck[(2*i)-1] = deck[(i-1)+(num/2)];
				}
			}
			System.out.print("#" + (tc+1));
			for(String str : shuffleDeck) {
				System.out.print(" " + str);
			}
			System.out.println();
		}
	}
}
