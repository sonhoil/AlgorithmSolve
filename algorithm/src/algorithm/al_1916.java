package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class al_1916 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashMap<Integer, ArrayList<Edge>> graph = new HashMap<Integer, ArrayList<Edge>>();
		for(int i=1;i<=N;i++) {
			ArrayList<Edge> list = new  ArrayList<Edge>();
			graph.put(i, list);
		}
		for(int i=0;i<M;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			ArrayList<Edge> list = new  ArrayList<Edge>();
			list = graph.get(A);
			list.add(new Edge(C, B));
			//list = graph.get(B);
			//list.add(new Edge(C, A));
		}
		
		DijkstraPath dObject = new DijkstraPath();
		int start = sc.nextInt();
		int end = sc.nextInt();
		System.out.println(dObject.dijkstraFunc(graph, start).get(end));
	}

}
