package com.ssafy.day0210;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_1158_요세푸스_문제_최종수_큐 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		
		// 숫자 세팅
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		// 출력
		sb.append("<");
		
		// i - 작업 횟수 의미
		// 숫자 1개를 꺼내기 위해 K만큼의 작업 필요 - N개 숫자 꺼내려면 N*K만큼의 작업 필요
		for (int i =1; i <=N*K; i++) {
			//deQ 큐에 담긴 숫자 꺼내기
			int num = queue.poll();
			
			//현재 작업 횟수(i)가 K의 배수번째라면 담지않고 제거
			if(i%K == 0) {
				sb.append(num+", ");
				continue;
			}
			
			//enQ 큐에 담긴 숫자 다시 뒤에 붙이기
			queue.offer(num);
		}
		//뒤에 붙은 , 제거
		sb.setLength(sb.length()-2);
		
		sb.append(">");
		
		System.out.println(sb);
	}
}

