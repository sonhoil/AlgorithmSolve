package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class al_7576 {
	
   static Scanner sc = new Scanner(System.in);
   static int N;
   static int M;
   static int [][] map;
   static Deque<int[]> box = new LinkedList<int[]>();
   static Deque<int[]> needvisited = new LinkedList<>(); 
  
   static int cnt = 0;
   public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	   StringTokenizer st = new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken());
	   M = Integer.parseInt(st.nextToken());
	   map = new int[M][N];

      for(int i=0;i<M;i++) {
    	  st = new StringTokenizer(br.readLine());
         for(int j=0;j<N;j++) {
            map[i][j] =  Integer.parseInt(st.nextToken());
            if(map[i][j] == 1) {
               int[] loc = new int[2];
               loc[0] = i;
               loc[1] = j;
               box.offer(loc);
            }
            if(map[i][j] ==-1) {
              cnt++;
             }
         }
      }
      int answer = solve()-1;
      

      for(int i=0;i<M;i++) {
         for(int j=0;j<N;j++) {
            if(map[i][j] == 0) {
            	answer = -1;
            	break;
            }
         }
      }
      System.out.println(answer);
   }
   public static int solve() {

      int answer = 0;
      boolean flag = true;
    
    //  while(flag) {
         while(!box.isEmpty()) {
        	 cnt++;
           //  int [] loc = box.poll();
          //  int x = loc[0];
          //  int y = loc[1];
        	 System.out.println("box1 =>"+box);
            dfs(box);
            answer++;
         }
         
       //  box.addAll(needvisited);
       //  needvisited.clear();
       
 //     }
      return answer;
   }
   public static void dfs(Deque<int[]> boxs) {
	  boxs = new LinkedList<int[]>();
	  boxs.addAll(box);
	   while(!boxs.isEmpty()) {
		   System.out.println("box =>"+box);
	       System.out.println("boxs =>"+boxs);
	   int [] loc = boxs.poll();
	   box.poll();
	   int i = loc[0];
       int j = loc[1];
       
      if(M > i+1 && map[i+1][j] == 0) {
         map[i+1][j] = 1;
         int[] location = {i+1,j};
         box.offer(location);
      }
      if(0 <= i-1 && map[i-1][j] == 0) {
         map[i-1][j] = 1;
         int[] location = {i-1,j};
         box.offer(location);
      }
      if(N > j+1 && map[i][j+1] == 0) {
         map[i][j+1] = 1;
         int[] location = {i,j+1};
         box.offer(location);
      }
      if(0 <= j-1 && map[i][j-1] == 0) {
         map[i][j-1] = 1;
         int[] location = {i,j-1};
         box.offer(location);
      }
     
   }
	/*
	 * if(needvisited.isEmpty() && box.isEmpty()) { return false; }else { return
	 * true; }
	 */
   }

}