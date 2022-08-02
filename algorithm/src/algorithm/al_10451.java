package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class al_10451 {
	static int N;
	static int M;
	static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
	static ArrayList<Integer> result = new ArrayList<Integer>();
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 for(int T=0;T<N;T++) {
		 M = sc.nextInt();
		
		 ArrayList<Integer> list = null;
		 for(int i=1;i<=M;i++) {
			 list = new ArrayList<Integer>();
			 graph.put(i,list);
		 }
		 for(int i=1;i<=M;i++) {
			 int H = sc.nextInt();
			 list = graph.get(i);
			 list.add(H);
			 list = graph.get(H);
			 list.add(i);
		 }
		 bfs(1);
		 }
		 for(int k=0;k<result.size();k++) {
			 System.out.println(result.get(k));
		 }
	}
	public static void bfs(int start) {
		ArrayList<Integer> visit = new ArrayList<Integer>();
		ArrayList<Integer> needVisit = new ArrayList<Integer>();
		ArrayList<Integer> check = new ArrayList<Integer>();
		for(int i=0;i<M;i++) {
			check.add(i+1);
		}
		int cnt = 0;
		while(check.size() > 0) {
			needVisit.add(check.get(0));
			while(needVisit.size() > 0) {
				int node = needVisit.remove(0);
				if(!visit.contains(node)) {
					visit.add(node);
					needVisit.addAll(graph.get(node));
					for(int i=0;i<check.size();i++) {
						if(check.get(i) == node) {
							check.remove(i);
						}
					}
				}
			}
			cnt++;
		}
		result.add(cnt);
	}
}
