package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class al_3273 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		int X = sc.nextInt();
		Arrays.sort(A);
		int point1 = 0;
		int point2 = N-1;
		int count = 0;
		while(point1 < point2) {
			if(A[point1]+A[point2] == X) {
				count++;
				point2--;
				point1++;
			}
			if(A[point1]+A[point2] < X) {
				point1++;
			}
			if(A[point1]+A[point2] > X) {
				point2--;
			}
		}
		
		System.out.println(count);
	}

}
