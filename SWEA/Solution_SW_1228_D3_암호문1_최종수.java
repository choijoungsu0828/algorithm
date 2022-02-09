package com.ssafy.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SW_1228_D3_암호문1_최종수 {
	public static void main(String[] args) throws IOException {
		List<String> list = new LinkedList<>(); // 암호문 담을 공간
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 0; tc < 10; tc++) {
			list.clear(); // 공간 초기화
			int n = Integer.parseInt(br.readLine()); // 암호문 길이
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				list.add(st.nextToken()); // 원본 암호문 입력
			}
			int num = Integer.parseInt(br.readLine()); //명령어 개수
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < num; i++) {
				switch(st.nextToken()) {
				case "I" : // 삽입
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; j++) {
						list.add(x, st.nextToken()); // 암호문 삽입
						x++;
					}
					break;
				}
			}
			System.out.print("#" + (tc+1));
			for(int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
	}
}
