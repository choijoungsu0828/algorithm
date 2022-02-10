package com.ssafy.day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 자료구조 : 리스트, 큐
 * 리스트 : 인덱스 관리 필요
 * 큐 : 인덱스 관리 필요 없음.
 * @author joung
 *
 */

public class Main_BJ_1158_요세푸스_문제_최종수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int idx = 0; //현재 인덱스
		// 1번부터 N번까지의 사람 삽입
		for (int i = 1; i < n+1; i++) {
			list.add(i);
		}
		sb.append("<");
		while (true) {
			for(int i = 0; i < k; i++) {
				if(i == k-1) { // k번째 마다 삭제
					sb.append(list.get(idx));
					list.remove(idx);
					if(!(list.size()==0)) {
						sb.append(", ");
					}
				}
				else {
					idx++;
				}
				if(idx == list.size()) { // idx가  리스트 사이즈를 넘어가면 0으로 초기화
					idx = 0;
				}
			}
			if(list.size() == 0) { // 한명도 없다면 종료
				sb.append(">");
				break;
			}
		}
		System.out.println(sb);
	}
}
