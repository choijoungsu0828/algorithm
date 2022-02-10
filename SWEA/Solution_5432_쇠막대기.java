package com.ssafy.day0208;

import java.util.Scanner;

public class Solution_5432_쇠막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int tc = 0; tc < t; tc++) {
			String str = sc.nextLine();
			int num = 0;
			int sum = 0;
			for(int i = 0; i < str.length()-1; i++) {
				switch (str.charAt(i)) {
				case '(' :
					if(str.charAt(i+1) == ')') {
						sum += num;
					}
					else if(str.charAt(i+1) == '(') {
						num++;
					}
					break;
				case ')' :
					if(str.charAt(i+1) == ')') {
						num--;
						sum++;
					}
					break;
				}
			}
			System.out.println("#" + (tc+1) + " " + sum);
		}
		sc.close();
	}
}
