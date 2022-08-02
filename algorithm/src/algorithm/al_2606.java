package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class al_2606 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0;i<N;i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			graph.put(i+1, list);
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
		int answer = bfs(graph,1);
		System.out.println(answer-1);
	}
	public static int bfs(HashMap<Integer, ArrayList<Integer>> graph ,int start) {
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> needvisit = new ArrayList<Integer>();
		needvisit.add(start);
		while(needvisit.size() > 0) {
			int node = needvisit.remove(0);
			if(!visited.contains(node)) {
				visited.add(node);
				needvisit.addAll(graph.get(node));
			}
		}
		return visited.size();
	}
}
