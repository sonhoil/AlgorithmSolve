package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class al_5567 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashMap<Integer,ArrayList<Integer>> graph = new HashMap<Integer,ArrayList<Integer>>();
		
		for(int i=0;i<N;i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			graph.put(i+1,list);
		}
		for(int i=0;i<M;i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int A = sc.nextInt();
			int B = sc.nextInt();
			list = graph.get(A);
			list.add(B);
			graph.put(A,list);
			list = graph.get(B);
			list.add(A);
			graph.put(B,list);
		}
		bfs(graph,1);
	}
	public static void bfs(HashMap<Integer,ArrayList<Integer>> graph,int start) {
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> needvisit = new ArrayList<Integer>();
		ArrayList<Integer> check = new ArrayList<Integer>();
		check.addAll(graph.get(1));
		needvisit.add(start);
	
		while(needvisit.size() > 0) {
			boolean flag = true;
			int node = needvisit.remove(0);
			if(node > 1) {
					if(!check.contains(node) && !visited.contains(node)) {
						visited.add(node);
						flag = false;
					}
			}
			if(!visited.contains(node) && flag) {
				visited.add(node);
				needvisit.addAll(graph.get(node));
			}
		}
		System.out.println(visited.size()-1);
	}
}
