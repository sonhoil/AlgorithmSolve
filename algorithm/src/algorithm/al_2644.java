package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class al_2644 {
	
	static int N;
	static int A,B;
	static int M;
	static HashMap<Integer,ArrayList<Integer>> graph = new HashMap<Integer,ArrayList<Integer>>();
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 A = sc.nextInt();
		 B = sc.nextInt();
		 M = sc.nextInt();
		 
		 for(int i=1;i<=N;i++) {
			 ArrayList<Integer> list = new ArrayList<Integer>();
			 graph.put(i, list);
		 }
		 for(int i=0;i<M;i++) {
			 ArrayList<Integer> list = new ArrayList<Integer>();
			 int X = sc.nextInt();
			 int Y = sc.nextInt();
			 list = graph.get(X);
			 list.add(Y);
			 list = graph.get(Y);
			 list.add(X);
		 }
		 System.out.println(graph);
		int answer1 = bfs(A,B);
		System.out.println(answer1);
		/*
		 * int answer2 = bfs(B,A); if(answer1 == -1) { System.out.println("-1"); }else
		 * if(answer1 > answer2) { System.out.println(answer2); }else {
		 * System.out.println(answer1); }
		 */
	}
	static public int bfs(int start,int find) {
		ArrayList<Integer> visit = new ArrayList<Integer>();
		ArrayList<Integer> needVisit = new ArrayList<Integer>();
		ArrayList<Integer> needVisitSub = new ArrayList<Integer>();
		needVisitSub.add(start);
		boolean check = false;
		int dept = 0;
		int node = 0;
		while(true) {
			while(needVisitSub.size() > 0) {
				node =needVisitSub.remove(needVisitSub.size()-1);
				if(!visit.contains(node)) {
					visit.add(node);
					needVisit.add(node);
					System.out.println("node =>"+node);
					System.out.println("visit =>"+visit);
					System.out.println("needVisitSub =>"+needVisitSub);
					System.out.println("find =>"+find);
					if(node == find) {
						check = true;
						break;
					}		
				}
			}
			if(node == find) {
				check = true;
				break;
			}
			//System.out.println("visit =>"+visit);
			//needVisit.clear();
			dept++;
			if(dept > M) {
				break;
			}
			for(int i=0;i<needVisit.size();i++) {
				needVisitSub.addAll(graph.get(needVisit.get(i)));
			}
			
			//System.out.println("graph.get(node) =>"+graph.get(node));
			//needVisit.addAll(graph.get(node));
		}
		
		System.out.println("dept =>"+dept);
		System.out.println(visit);
		if(check) {
			return dept;
		}else {
			return -1;
		}
	}
}
