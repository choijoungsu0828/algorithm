package com.ssafy.day0215;

import java.util.Scanner;

public class Main_BJ_2839_설탕배달_최종수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = -1;
		for(int i = n/5; i >= 0; i--) {
			int num = 0;
			num = n-(5*i);
			if(num%3 == 0) {
				k++;
				k += (num/3 + i);
				break;
			}
		}
		System.out.println(k);
		sc.close();
	}
}
