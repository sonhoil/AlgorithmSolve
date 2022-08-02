package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class al_11724 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		for(int i=0;i<N;i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			graph.put(i+1, list);
			nodes.add(i+1);
		}

		for(int i=0;i<M;i++) {
			int K = sc.nextInt();
			int P = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();

			if(graph.containsKey(K)) {
				list = graph.get(K);
				list.add(P);
				list = graph.get(P);
				list.add(K);
			}
		}
		int cnt = 0;
		while(nodes.size() > 0) {
			cnt++;
			int start = nodes.get(0);
			ArrayList<Integer> node = bfs(graph,start);
			for(int i=0;i<node.size();i++) {
				if(nodes.contains(node.get(i))) {
					nodes.remove(node.get(i));
				}
				if(graph.containsKey(node.get(i))) {
					graph.remove(node.get(i));
				}
			}
			if(nodes.contains(start)) {
				nodes.remove(start);
			}
			if(graph.containsKey(start)) {
				graph.remove(start);
			}
			
		}
		System.out.println(cnt);
	}
	public static ArrayList<Integer> bfs (HashMap<Integer, ArrayList<Integer>> graph ,int start) {
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> needvisit = new ArrayList<Integer>();
		needvisit.add(start);
		while(needvisit.size() > 0) {
			int node = needvisit.remove(needvisit.size()-1);
			if(!visited.contains(node)) {
				visited.add(node);
				needvisit.addAll(graph.get(node));
			}
		}
		return visited;
	}
}
