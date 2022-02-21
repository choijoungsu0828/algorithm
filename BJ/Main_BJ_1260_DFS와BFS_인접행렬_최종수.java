package com.ssafy.day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1260_DFS와BFS_인접행렬_최종수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[n+1][n+1];
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			matrix[from][to] = matrix[to][from] = 1;
		}
		dfs(matrix, new boolean[n+1], v);
		System.out.println();
		bfs(matrix, new boolean[n+1], v);
	}
	
	public static void bfs(int[][] matrix, boolean[] visit, int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visit[start] = true;
		while(!queue.isEmpty()) {
			int i = queue.poll();
			System.out.print(i + " ");
			for(int j = 1; j < matrix[i].length; j++) {
				if(!visit[j] && matrix[i][j] > 0) {
					queue.offer(j);
					visit[j] = true;
				}
			}
		}
		System.out.println();
	}
	
	public static void dfs(int[][] matrix, boolean[] visit, int current) {
		visit[current] = true;
		System.out.print(current + " ");
		for(int i = 1; i < matrix[current].length; i++) {
			if(!visit[i] && matrix[current][i] > 0) {
				dfs(matrix, visit, i);
			}
		}
	}
}