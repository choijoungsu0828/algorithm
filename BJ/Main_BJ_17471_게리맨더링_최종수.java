package com.ssafy.day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17471_게리맨더링_최종수 {
	
	public static int N, Min = Integer.MAX_VALUE;
	
	public static int[] arr, people;
	
	static class Node {
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}
	
	public static Node[] AdjMatrix;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		AdjMatrix = new Node[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cnt; j++) {
				int to = Integer.parseInt(st.nextToken()) - 1;
				AdjMatrix[i] = new Node(to, AdjMatrix[i]);
				AdjMatrix[to] = new Node(i, AdjMatrix[to]);
			}
		}
		for(int i = 1; i <= N/2; i++) {
			combine(0, i, 0, 0);
		}
		if(Min == Integer.MAX_VALUE) {
			Min = -1;
		}
		System.out.println(Min);
		
		
	}
	
	public static void combine(int cnt, int r, int idx, int start) {
		if(cnt == r) {
			int idx_1 = 0;
			int idx_2 = 0;
			int sum_1 = 0;
			int sum_2 = 0;
			int start_1 = 0;
			int start_2 = 0;
			for(int i = 0; i < N; i++) {
				if((idx & 1 << i) != 0) {
					idx_1 = idx_1 | 1 << i;
					if(sum_1 == 0) {
						start_1 = i;
					}
					sum_1 += people[i];
				}
				else {
					idx_2 = idx_2 | 1 << i;
					if(sum_2 == 0) {
						start_2 = i;
					}
					sum_2 += people[i];
				}
			}
			if(bfs(start_1, idx_1) && bfs(start_2, idx_2)) {
				Min = Math.min(Min, Math.abs(sum_2 - sum_1));
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			idx = idx | 1 << i;
			combine(cnt + 1, r, idx, i + 1);
			idx = idx & ~(idx & 1 << i);
		}
	}
	
	public static boolean bfs(int start, int idx) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		int idx_origin = idx;
		q.offer(start);
		while(!q.isEmpty()) {
			int n = q.poll();
			visited[n] = true;
			idx = idx & ~(idx & 1 << n);
			for(Node temp = AdjMatrix[n]; temp != null; temp = temp.link) {
				if(visited[temp.vertex] || (idx_origin & 1 << temp.vertex) == 0) {
					continue;
				}
				q.offer(temp.vertex);
			}
		}
		if(idx != 0) {
			return false;
		}
		return true;
	}
}
