package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge2 implements Comparable<Edge2> {
    public int distance;
    public int vertex;
    
    public Edge2(int distance, int vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }
    // System.out.println() 으로 객체 자체 출력시, 
    public String toString() {
        return "vertex: " + this.vertex + ", distance: " + this.distance;
    }
    @Override
    public int compareTo(Edge2 edge) {
        return this.distance - edge.distance;
    }
}

class DijkstraPath2 {
    public HashMap<Integer, Integer> dijkstraFunc(HashMap<Integer, ArrayList<Edge2>> graph, int start) {
        Edge2 edgeNode;
		Edge2 adjacentNode;
        ArrayList<Edge2> nodeList;
        int currentDistance, weight, distance;
        int currentNode;
		int adjacent;
        HashMap<Integer, Integer> distances = new HashMap<Integer, Integer>();
        for (Integer key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        
        PriorityQueue<Edge2> priorityQueue = new PriorityQueue<Edge2>();
        priorityQueue.add(new Edge2(distances.get(start), start));
        
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
                    priorityQueue.add(new Edge2(distance, adjacent));
                }
            }
        }
        return distances;
    }
}




public class al_10282 {
			
	public static void main(String[] args) {
		ArrayList<int []> answer = new ArrayList<int []>();
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int p=0;p<T;p++) {
		int N = sc.nextInt();
		int D = sc.nextInt();
		int C = sc.nextInt();
		int [] result = new int [2];		
		HashMap<Integer, ArrayList<Edge2>> graph = new HashMap<Integer, ArrayList<Edge2>>();
		for(int i=1;i<=N;i++) {
			ArrayList<Edge2> list = new  ArrayList<Edge2>();
			graph.put(i, list);
		}
		for(int i=0;i<D;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int S = sc.nextInt();
			ArrayList<Edge2> list = new  ArrayList<Edge2>();
			list = graph.get(B);
			list.add(new Edge2(S, A));
		}
		
		DijkstraPath2 dObject = new DijkstraPath2();
		
		HashMap<Integer, Integer> dist1 = dObject.dijkstraFunc(graph, C);
		int cnt = 0;
		int max = 0;
		for(Entry<Integer, Integer> elem : dist1.entrySet()){ 
			if(elem.getValue() != Integer.MAX_VALUE ) {
				cnt++;
				if(max < elem.getValue() ) {
					max = elem.getValue() ;
				}
			}
		}
		result[0] = cnt;
		result[1] = max;
		answer.add(result);
		}
		for(int w=0;w<answer.size();w++) {
			System.out.println(answer.get(w)[0]+" "+answer.get(w)[1]);
		}
		
	}
}	
	