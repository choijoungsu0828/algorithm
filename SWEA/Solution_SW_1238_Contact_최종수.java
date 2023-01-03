// package com.ssafy.day0221;
//
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.StringTokenizer;
//
// public class Solution_SW_1238_Contact_최종수 {
//
// 	static int Data_Max,Dep_Max;
//
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st;
// 		for(int tc = 0; tc < 10; tc++) {
// 			Data_Max = 0;
// 			Dep_Max = -1;
// 			Node[] graph = new Node[101];
//  			st = new StringTokenizer(br.readLine());
// 			int num = Integer.parseInt(st.nextToken());
// 			int start = Integer.parseInt(st.nextToken());
// 			st = new StringTokenizer(br.readLine());
// 			for(int i = 0; i < num/2; i++) {
// 				int from = Integer.parseInt(st.nextToken());
// 				int to = Integer.parseInt(st.nextToken());
// 				graph[from] = new Node(to, graph[from]);
// 			}
// 			bfs(graph,new boolean[101], start);
// 			System.out.println("#" + (tc+1) + " " + Data_Max);
// 		}
// 	}
//
// 	public static void bfs(Node[] graph, boolean[] visit, int start) {
// 		Queue<Data> queue = new LinkedList<Data>();
// 		queue.offer(new Data(start, 0));
// 		while(!queue.isEmpty()) {
// 			Data dat = queue.poll();
// 			int i = dat.data;
// 			int idx = dat.dep;
// 			if(idx > Dep_Max) {
// 				Dep_Max = idx;
// 				Data_Max = 0;
// 			}
// 			if(i > Data_Max) {
// 				Data_Max = i;
// 			}
// 			for(Node temp = graph[i]; temp != null; temp = temp.link) {
// 				if(!visit[temp.vertex]) {
// 					queue.offer(new Data(temp.vertex, idx + 1));
// 					visit[temp.vertex] = true;
// 				}
// 			}
// 		}
// 	}
// }
//
// class Node{
// 	int vertex;
// 	Node link;
// 	public Node(int vertex, Node link) {
// 		this.vertex = vertex;
// 		this.link = link;
// 	}
// }
//
// class Data{
// 	int data;
// 	int dep;
// 	public Data(int data, int dep) {
// 		super();
// 		this.data = data;
// 		this.dep = dep;
// 	}
// }
