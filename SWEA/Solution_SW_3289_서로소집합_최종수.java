package com.ssafy.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_3289_서로소집합_최종수 {
	
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			makeset(n+1);
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(c == 0) {
					union(a,b);
				}
				if(c == 1) {
					if(findset(a) == findset(b)) {
						sb.append(1);
					}
					else {
						sb.append(0);
					}
				}
			}
			System.out.println("#" + (tc + 1) + " " + sb);
		}
	}
	
	public static void makeset(int n) {
		parents = new int[n];
		for(int i = 1 ; i < n; i++) {
			parents[i] = i;
		}
	}
	
	public static int findset(int a) {
		if(a == parents[a]) {
			return a;
		}
		return parents[a] = findset(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int rootA = findset(a);
		int rootB = findset(b);
		if(rootA == rootB) {
			return false;
		}
		parents[rootB] = rootA;
		return true;
		
	}
}
