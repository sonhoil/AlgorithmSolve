package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class al_1920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] A = new long[N];
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		long[] B = new long[M];
		for(int i=0;i<M;i++) {
			B[i] = sc.nextInt();
		}
		Arrays.sort(A);
		for(int i=0;i<B.length;i++) {
			int result = binarySearch(B[i],A);
			System.out.println(result);
		}
		
		
		
	}
	
	public static int binarySearch(long iKey, long arr[]) {
        int mid;
        int left = 0;
        int right = arr.length - 1;
 
        while (right >= left) {
            mid = (right + left) / 2;
 
            if (iKey == arr[mid]) {
                return 1;
            }
            if (iKey < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }


}
