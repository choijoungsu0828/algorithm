package com.ssafy.day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_D4_1233_사직연산유효성검사_최종수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			int answer = 1;
			for(int i = 0; i < n; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				st.nextToken();
				switch(st.nextToken()) {
				case "-":
				case "+":
				case "*":
				case "/":
					if(!st.hasMoreTokens()) {
						answer = 0;
					}
					break;
				default :
					if(st.hasMoreTokens()) {
						answer = 0;
						break;
					}
				}
			}
			System.out.println("#" + (tc+1) + " " + answer);
		}
		
	}
}
