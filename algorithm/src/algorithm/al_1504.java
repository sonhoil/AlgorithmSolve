package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    public int distance;
    public int vertex;
    
    public Edge(int distance, int vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }
    // System.out.println() 으로 객체 자체 출력시, 
    public String toString() {
        return "vertex: " + this.vertex + ", distance: " + this.distance;
    }
    @Override
    public int compareTo(Edge edge) {
        return this.distance - edge.distance;
    }
}

class DijkstraPath {
    public HashMap<Integer, Integer> dijkstraFunc(HashMap<Integer, ArrayList<Edge>> graph, int start) {
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




public class al_1504 {
			
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
			list = graph.get(B);
			list.add(new Edge(C, A));
		}
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		DijkstraPath dObject = new DijkstraPath();
		
		HashMap<Integer, Integer> dist1 = dObject.dijkstraFunc(graph, v1);
		HashMap<Integer, Integer> dist2 = dObject.dijkstraFunc(graph, v2);
		
		int dist_v12 = dist1.get(v2);
		System.out.println(dist1);
		System.out.println(dist2);
		System.out.println(dist_v12);
		int answer = -1;
		 if (dist1.get(1) != Integer.MAX_VALUE && 
	        		dist_v12 != Integer.MAX_VALUE && dist2.get(1) != Integer.MAX_VALUE)
	        {
	            answer = dist_v12 + Math.min(dist1.get(1) + dist2.get(N), dist1.get(N) + dist2.get(1));
	        }
		System.out.println(answer);
		
	}
}	
	