package com.ssafy.day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1260_DFS와BFS_인접리스트_최종수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Node[] graph = new Node[n+1];
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from] = new Node(to, graph[from]);
			graph[to] = new Node(from, graph[to]);
		}
		bfs(graph, new boolean[n+1], v);
		dfs(graph, new boolean[n+1], v);
	}
	
	public static void bfs(Node[] graph, boolean[] visit, int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visit[start] = true;
		while(!queue.isEmpty()) {
			int i = queue.poll();
			System.out.print(i + " ");
			for(Node temp = graph[i]; temp != null; temp = temp.link) {
				if(!visit[temp.vertex]) {
					queue.offer(temp.vertex);
					visit[temp.vertex] = true;
				}
			}
		}
		System.out.println();
	}
	
	public static void dfs(Node[] graph, boolean[] visit, int current) {
		visit[current] = true;
		System.out.print(current + " ");
		for(Node temp = graph[current]; temp != null; temp = temp.link) {
			if(!visit[temp.vertex]) {
				dfs(graph,visit,temp.vertex);
			}
		}
	}
}

class Node {
	int vertex;
	Node link;
	public Node(int vertex, Node link) {
		this.vertex = vertex;
		this.link = link;
	}
	@Override
	public String toString() {
		return "Node [vertex=" + vertex + ", link=" + link + "]";
	}
	
}