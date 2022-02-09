package com.ssafy.day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_D3_9229_한빈이와SpotMart_최종수 {
	
	public static int N, g, max;
	public static int[] numbers,kg;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 개수 입력받기
		int tc = Integer.parseInt(br.readLine());
		// 테스트 케이스 입력받기
		for(int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 과자 봉지 개수
			numbers = new int[N];
			g = Integer.parseInt(st.nextToken()); // 들 수 있는 무게 제한
			kg = new int[N]; // 주어진 과자 봉지의 무게들이 담겨있는 배열
			st = new StringTokenizer(br.readLine());
			max = -1;
			for(int j = 0; j < N; j++) { // 주어진 과자 봉지의 무게를 배열에 담는중
				kg[j] = Integer.parseInt(st.nextToken());
			}
			combination(0, 0); //nC2 실행
			System.out.println("#" + (i+1) + " " + max);
		}
	}
	public static void combination(int cnt, int start) {
		if(cnt == 2) {
			int gSum = kg[numbers[0]] + kg[numbers[1]];
			if(!(gSum > g) && gSum > max) {
				max = gSum;
			}
			return;
		}
		for(int i = start; i < N; i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
}
