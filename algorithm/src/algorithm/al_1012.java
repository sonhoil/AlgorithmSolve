package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class al_1012 {
	static Scanner sc = new Scanner(System.in);
	public static int T = sc.nextInt();	
	
	public static void main(String[] args) {
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		for(int h=0;h<T;h++) {
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int [][] land = new int [M][N];
		boolean [][] landCheck = new boolean [M][N];
		for(boolean check[] : landCheck) {
			Arrays.fill(check, false);
		}
		for(int i=0;i<K;i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			landCheck[X][Y] = true;
		}
		int answer = solve(M, N,landCheck);
		answerList.add(answer);
		}
		for(int s=0;s<answerList.size();s++) {
			System.out.println(answerList.get(s));
		}
		
	}
	public static void dfs(int i,int j,int N,int M,boolean [][] landCheck) {
			if(landCheck[i][j]) {
				landCheck[i][j] = false;
			}
			if(i+1 < M && landCheck[i+1][j]) {
					dfs(i+1,j,N,M,landCheck);
			}
			if(i-1 >= 0 && landCheck[i-1][j]) {
					dfs(i-1,j,N,M,landCheck);
			}
			if(j+1 < N && landCheck[i][j+1]) {
					dfs(i,j+1,N,M,landCheck);
			}
			if(j-1 >=0 && landCheck[i][j-1]) {
					dfs(i,j-1,N,M,landCheck);
			}	
	}
	public static int solve(int M,int N,boolean [][] landCheck) {
		int answer = 0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(landCheck[i][j]) {
					answer++;
					dfs(i,j,N,M,landCheck);
				}
			}
		}
		return answer;
	}
}
