package com.ssafy.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;



public class Solution_SW_7465_창용마을마을무리의개수_최종수 {
	
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			makeset(n+1);
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				if(st.hasMoreTokens()) {
					int b = Integer.parseInt(st.nextToken());
					union(a,b);
				}
			}
			HashSet<Integer> answer = new HashSet<>();
			for(int i = 1; i < n+1; i++) {
				answer.add(findset(i));
			}
			System.out.println("#" + (tc + 1) + " " + answer.size());
			answer.clear();
		}
	}
	
	public static void makeset(int n) {
		parents = new int[n+1];
		for(int i = 1; i < n+1; i++) {
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
		int aRoot = findset(a);
		int bRoot = findset(b);
		if(aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
}
