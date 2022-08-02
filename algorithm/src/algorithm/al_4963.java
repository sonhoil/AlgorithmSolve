package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class al_4963 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = 1;
		int h = 1;
		boolean [][] map = null;
		ArrayList<Integer> answers = new ArrayList<Integer>();
		while(w>0 && h >0) {
			h = sc.nextInt();
			w = sc.nextInt();
			if(w == 0 && h == 0) {
				break;
			}
			map = new boolean [w][h];
			for(int i=0;i<w;i++) {
				for(int j=0;j<h;j++) {
					int k = sc.nextInt();
					if(k>0) {
						map[i][j] = true;
					}else {
						map[i][j] = false;
					}
					
				}
			}
			answers.add(solve(map,w,h));
		}
		for(int i=0;i<answers.size();i++) {
			System.out.println(answers.get(i));
		}
	}
	public static int solve(boolean [][] map,int w,int h) {
		int answer = 0;
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(map[i][j]) {
					answer++;
					dfs(map,i,j,w,h);
				}
				
			}
		}
		return answer;
	}
	public static void dfs(boolean [][] map,int i,int j,int w,int h) {
			if(map[i][j]) {
				map[i][j] = false;
			}
			if(i+1<w && map[i+1][j] ) {
				dfs(map,i+1,j,w,h);
			}
			if(i-1>=0 && map[i-1][j] ) {
				dfs(map,i-1,j,w,h);
			}
			if(j-1>=0 && map[i][j-1] ) {
				dfs(map,i,j-1,w,h);
			}
			if(j+1 <h && map[i][j+1] ) {
				dfs(map,i,j+1,w,h);
			}
			if(i+1<w && j+1 < h && map[i+1][j+1]) {
				dfs(map,i+1,j+1,w,h);
			}
			if(i-1>=0 && j-1 >=0 && map[i-1][j-1]) {
				dfs(map,i-1,j-1,w,h);
			}
			if(i+1<w && j-1 >= 0 && map[i+1][j-1]) {
				dfs(map,i+1,j-1,w,h);
			}
			if(i-1>=0 && j+1 < h && map[i-1][j+1]) {
				dfs(map,i-1,j+1,w,h);
			}
	}
}
