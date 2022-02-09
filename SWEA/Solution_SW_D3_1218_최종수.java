package com.ssafy.day0207;

import java.util.Scanner;
import java.util.Stack;
//{ [ ( } ] ) 의 경우 유효하지 않다고 가정하고 문제풀기

public class Solution_SW_D3_1218_최종수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <= 10; i++) {
			int cnt = Integer.parseInt(sc.nextLine());
			Stack<Character> stack = new Stack<>();
			String str = sc.nextLine();
			int answer = 0;
			for (int j = 0; j < cnt; j++) {
				if (closeChar(str.charAt(j))) {
					if(stack.empty()) {
						break;
					}
					if((charPair(str.charAt(j)) == stack.peek())) {
						stack.pop();
						if(j == (cnt-1) && stack.empty()) {
							answer = 1;
							break;
						}
						else {
							continue;
						}
					}
				}
				stack.push(str.charAt(j));
			}
			System.out.println("#" + i + " " + answer);
		}
		sc.close();
	}
	public static boolean closeChar(char c) {
		if(c == '}' || c == ']' || c == ')' || c == '>') {
			return true;
		}
		return false;
	}
	public static char charPair(char c) {
		switch(c) {
		case '}' :
			return '{';
		case ']' :
			return '[';
		case '>' :
			return '<';
		case ')' :
			return '(';
		default :
			return ' ';
		}
	}
}
