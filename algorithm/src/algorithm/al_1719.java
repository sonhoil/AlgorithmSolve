package algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class al_1719 {
	static int N;
	static int M;
	static int [][] dest;
	static int [][] from;
	public static void main(String[] args) throws IOException, NumberFormatException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		dest = new int[N][N];
		from = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) {
					dest[i][j] = 0;
				}else {
					dest[i][j] = 1000000000;
				}
			}
		}
		for(int i=0;i<M;i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int c = sc.nextInt();
			dest[a][b] = c;
			dest[b][a] = c;
			from[a][b] = b;
			from[b][a] = a;
		}
		solve();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j) {
						System.out.print("- ");
					}else {
						System.out.print(from[i][j]+1+" ");
					}
					
				}
				System.out.println();
			}
	}
	public static void solve() {
		for(int K=0;K<N;K++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(dest[i][j] > dest[i][K]+dest[K][j]) {
						dest[i][j] = dest[i][K]+dest[K][j];
						from[i][j] = from[i][K];
					}
				}
			}
		}
	}
}