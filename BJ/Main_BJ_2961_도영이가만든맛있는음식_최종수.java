package com.ssafy.day0215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_BJ_2961_도영이가만든맛있는음식_최종수 {
	
	static int N, Min = Integer.MAX_VALUE;
	static boolean[] isSelected;
	static List<food> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		isSelected = new boolean[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		subSet(0);
		System.out.println(Min);
	}
	
	private static void subSet(int cnt) {
		if(cnt == N) {
			int sinProd = 1;
			int ssenSum = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sinProd *= list.get(i).sin;
					ssenSum += list.get(i).ssen;
				}
			}
			if (sinProd == 1 && ssenSum == 0) {
				return;
			}
			int result = (sinProd - ssenSum >= 0) ? sinProd - ssenSum : ssenSum - sinProd;
			if(result < Min) {
				Min = result;
			}
			return;
		}
		isSelected[cnt] = true;
		subSet(cnt+1);
		isSelected[cnt] = false;
		subSet(cnt+1);
	}
}

class food {
	public int sin;
	public int ssen;
	public food(int sin, int ssen) {
		this.sin = sin;
		this.ssen = ssen;
	}
}
