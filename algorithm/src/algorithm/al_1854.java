package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class al_1854 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
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
		}
		
		
		HashMap<Integer, Integer> dist1 = dijkstraFunc(graph, 1,5);
		//HashMap<Integer, Integer> dist2 = dijkstraFunc(graph, 2);
		//HashMap<Integer, Integer> dist3 = dijkstraFunc(graph, 3);
		//HashMap<Integer, Integer> dist4 = dijkstraFunc(graph, 4);
		//HashMap<Integer, Integer> dist5 = dijkstraFunc(graph, 5);
		System.out.println(dist1);
	//	System.out.println(dist2);
	//	System.out.println(dist3);
	//	System.out.println(dist4);
	//	System.out.println(dist5);
	}
	public static HashMap<Integer, Integer> dijkstraFunc(HashMap<Integer, ArrayList<Edge>> graph, int start,int k) {
        Edge edgeNode, adjacentNode;
        ArrayList<Edge> nodeList;
        int currentDistance, weight, distance;
        int currentNode;
		int adjacent;
        HashMap<Integer, Integer> distances = new HashMap<Integer, Integer>();
        for (Integer key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        priorityQueue.add(new Edge(distances.get(start), start));
        
        // 알고리즘 작성
        while (priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;
            
            if (distances.get(currentNode) < currentDistance) {
                continue;
            }
            
            nodeList = graph.get(currentNode);
            System.out.println("currentNode =>"+currentNode);
            System.out.println("nodeList =>"+nodeList);
            for (int index = 0; index < nodeList.size(); index++) {
                adjacentNode = nodeList.get(index);
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;
                
                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }
                System.out.println("distances =>"+distances);
            }
        }
        return distances;
    }
}
