package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class al_1743 {
	static public int N;
	static public int M;
	static public int K;
	static public int[][] map;
	static public boolean[][] mapCheck;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int [N][M];
		mapCheck = new boolean [N][M];
		for(int i=0;i<N;i++) {
			Arrays.fill(map[i], 0);
			Arrays.fill(mapCheck[i], false);
		}
		for(int j=0;j<K;j++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			map[r-1][c-1] = 1;
		}
		solve();
	}
	public static void solve() {
		int answer = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(map[i][j] > 0 && !mapCheck[i][j]) {
					answer = Math.max(bfs(i,j,1),answer);
				}
			}
		}
		System.out.println(answer);
	}
	public static int bfs(int i,int j,int cnt) {
		System.out.println("I =>"+i);
		System.out.println("J =>"+j);
		System.out.println(cnt);

		mapCheck[i][j] = true;
		if(i+1 < N && map[i+1][j] == 1 && !mapCheck[i+1][j] ) {
			cnt += bfs(i+1,j,1);
		}
		if(i-1 >= 0 && map[i-1][j] == 1 && !mapCheck[i-1][j] ) {
			cnt += bfs(i-1,j,1);
		}
		if(j+1 < M && map[i][j+1] == 1 && !mapCheck[i][j+1] ) {
			cnt +=bfs(i,j+1,1);
		}
		if(j-1 >= 0  && map[i][j-1] == 1 && !mapCheck[i][j-1] ) {
			cnt += bfs(i,j-1,1);
		}
		return cnt;
	}
}
