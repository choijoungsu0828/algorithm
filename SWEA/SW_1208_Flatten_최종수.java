package com.ssafy.day0207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_1208_Flatten_최종수 {
	public static void main(String[] args) throws IOException {
		int cnt = 0;
		int[] arr = new int[100];
		int result = 0;
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i < 11; i++) {
			result = 0;
			cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 100; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for (int j = 0; j < cnt; j++) {
				arr[99]--;
				arr[0]++;
				Arrays.sort(arr);
				result = arr[99] - arr[0];
				if (result == 1 || result == 0) {
					break;
				}
			}
			System.out.println("#" + i + " " + result);
		}
		
	}
}
