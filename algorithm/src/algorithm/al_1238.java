package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class al_1238 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		HashMap<Integer, ArrayList<Edge>> graph = new HashMap<Integer, ArrayList<Edge>>();
		for(int i=1;i<=N;i++) {
			ArrayList<Edge> list = new  ArrayList<Edge>();
			graph.put(i, list);
		}
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			ArrayList<Edge> list = new  ArrayList<Edge>();
			list = graph.get(a);
			list.add(new Edge(c, b));
		}
		HashMap<Integer, Integer> des = dijkstraFunc(graph,X);
		int max = 0;
		for(int i=1;i<=N;i++) {
			if(max < des.get(i)+dijkstraFunc(graph,i).get(X)) {
				max = des.get(i)+dijkstraFunc(graph,i).get(X);
			}
		}
		System.out.println(max);
	}
	
	public static HashMap<Integer, Integer> dijkstraFunc(HashMap<Integer, ArrayList<Edge>> graph, int start) {
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
            for (int index = 0; index < nodeList.size(); index++) {
                adjacentNode = nodeList.get(index);
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;
                
                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }
            }
        }
        return distances;
    }

}
