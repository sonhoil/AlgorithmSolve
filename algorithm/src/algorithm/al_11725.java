package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class al_11725 {
	static public int N;
	static public HashMap<Integer,ArrayList<Integer>> graph = new HashMap<Integer,ArrayList<Integer>>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ArrayList<Integer> list = null;
		for(int i=1;i<=N;i++) {
			list = new ArrayList<Integer>();
			graph.put(i, list);
		}
		for(int i=0;i<N-1;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			list = graph.get(A);
			list.add(B);
			list = graph.get(B);
			list.add(A);
		}
		dfs(1);
		
	}
	public static void dfs(int start) {
		ArrayList<Integer> visit = new ArrayList<Integer> ();
		ArrayList<Integer> needVisit = new ArrayList<Integer> ();
		HashMap<Integer,Integer> checkGraph = new HashMap<Integer,Integer>();

		needVisit.add(start);
		while(needVisit.size() > 0) {
			int node = needVisit.remove(needVisit.size()-1);
			if(!visit.contains(node)) {
				visit.add(node);
				ArrayList<Integer> list = new ArrayList<Integer> ();
				list = graph.get(node);
				needVisit.addAll(list); 
				for(int i=0;i<list.size();i++) {
					if(visit.contains(list.get(i))) {
						checkGraph.put(node, list.get(i));
					}
				}
			}
		}
		for(Entry<Integer,Integer> elem : checkGraph.entrySet()){ 
			System.out.println(elem.getValue()); 
		}

	}

}
