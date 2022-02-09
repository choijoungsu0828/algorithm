package com.ssafy.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SW_D4_1223_계산기2_최종수 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		Stack<Integer> stackInt = new Stack<>();
		for(int tc = 0; tc < 1; tc++) {
			int num = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < num; i++) {
				char c = str.charAt(i);
				switch(c) {
				case '+' :
					while(!stack.empty()) {
						sb.append(stack.pop());
					}
					stack.push(c);
					break;
				case '*' :
//					/*
					while(!stack.empty() && stack.peek() == '*') {
						sb.append(stack.pop());
					}
//					*/
					stack.push(c);
					break;
				default :
					sb.append(c);
				}
				if(i == (num - 1)) {
					while(!stack.empty()) {
						sb.append(stack.pop());
					}
				}
			}
			System.out.println(sb);
			for(int i = 0; i < num; i++) {
				char c = sb.charAt(i);
				switch(c) {
				case '+' : 
					int sum = stackInt.pop() + stackInt.pop();
					stackInt.push(sum);
					break;
				case '*' :
					int prod = stackInt.pop() * stackInt.pop();
					stackInt.push(prod);
					break;
				default :
					stackInt.push((int)c - '0');
					break;
				}
			}
			System.out.println("#" + (tc+1) + " " + stackInt.pop());
		}
	}
}
