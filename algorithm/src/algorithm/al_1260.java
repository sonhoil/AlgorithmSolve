package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class al_1260 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0;i<N;i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			graph.put(i+1,list);
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
		dfs(graph , V , N);
		System.out.println();
		bfs(graph , V , N);
	}
	public static void bfs(HashMap<Integer, ArrayList<Integer>> graph , int start, int N) {
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> needvisit= new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		needvisit.add(start);
		while(needvisit.size() > 0) {
			int node = needvisit.remove(0);
			if(!visited.contains(node)) {
				visited.add(node);
				 list = graph.get(node);
				 Collections.sort(list, new Comparator<Integer>() {
					  @Override
					    public int compare(Integer a, Integer b) {
						  return a.compareTo(b);
					    }
					});
				needvisit.addAll(list);
			}
		}
		for(int i=0;i<visited.size();i++) {
			System.out.print(visited.get(i)+" ");
		}
	}
	public static void dfs(HashMap<Integer, ArrayList<Integer>> graph , int start, int N) {
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> needvisit= new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		needvisit.add(start);
		while(needvisit.size() > 0) {
			int node = needvisit.remove(needvisit.size()-1);
			if(!visited.contains(node)) {
				visited.add(node);
				list = graph.get(node);
				/*
				 * Collections.sort(list, new Comparator<Integer>() {
				 * 
				 * @Override public int compare(Integer a, Integer b) { return b.compareTo(a); }
				 * });
				 */
			Collections.sort(list, Collections.reverseOrder());
				needvisit.addAll(list);
			}
		}
		for(int i=0;i<visited.size();i++) {
			System.out.print(visited.get(i)+" ");
		}
	}
}
