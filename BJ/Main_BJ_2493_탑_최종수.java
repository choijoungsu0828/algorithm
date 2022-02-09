package com.ssafy.day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_2493_탑_최종수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] height = new int[n][2];
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			height[i][0] = i;
			height[i][1] = Integer.parseInt(st.nextToken());		
		}
		for (int i = n; i > 0; i--) {
			while(true) {
				if(!stack.empty() && stack.peek()[1] < height[i-1][1]) {
					answer[stack.pop()[0]] = i;
				}
				else {
					stack.push(height[i-1]);
					break;
				}
			}
		}
		for(int i : answer) {
			System.out.print(i + " ");
		}
	}
}
