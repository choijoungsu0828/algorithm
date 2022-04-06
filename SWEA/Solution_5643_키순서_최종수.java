package com.ssafy.day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서_최종수 {
	
	static int N, M, Result, sum;
	
	static	Node[] adjMatrix;
	
	static int[] result;
	
	static boolean[] visited;
	
	static class Node {
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adjMatrix = new Node[N + 1];
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from] = new Node(to, adjMatrix[from]);
			}
			result = new int[N + 1];
			int cnt = 0;
			for(int i = 1; i <= N; i++) {
				sum = 0;
				visited = new boolean[N + 1];
				visited[i] = true;
				dfs(i);
				result[i] += sum;
			}
			for(int i = 1; i <= N; i++) {
				if(result[i] == N) {
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
		
	}
	
	public static void dfs(int current) {
		sum++;
		for(Node temp = adjMatrix[current]; temp != null; temp = temp.link) {
			if(visited[temp.vertex]) {
				continue;
			}
			visited[temp.vertex] = true;
			result[temp.vertex]++;
			dfs(temp.vertex);
		}
	}
}