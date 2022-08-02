package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class al_2512 {

	static long N, M;
	static long v_max;
	static long budget[];
	static boolean solve(long mid,long sum) {
		long count = 0;
		for(int i=0;i<budget.length;i++) {
			if(budget[i]>mid) {
				count = count + mid;
			}else {
				count = count + budget[i];
			}
		}
		System.out.println("count =>"+count);
		if(count > M) {
			return true;
		}else {
			//list.add(mid);
			return false;
		}
	}
	
	static long bs() {

		long right = M;
	
		long left = 0;
		long mid = 0;
		while(left <= right) {
			mid = (right+left)/2;
			System.out.println("left =>"+left);
			System.out.println("right =>"+right);
			System.out.println("mid =>"+mid);
			if(solve(mid,right)) {
				right = mid -1;
			}else {
				left = mid +1;
			}
		}
		return right;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		budget = new long[(int)N];
		long sum = 0;
		for(int i=0;i<N;i++) {
			budget[i] =  Integer.parseInt(st.nextToken());
			sum = sum + budget[i];
		}
		Arrays.sort(budget);
		M = Integer.parseInt(br.readLine());
		long answer = 0;
		if(sum <= M) {
			answer =budget[budget.length-1];
		}else {
			answer = bs();
		}
		
		System.out.println(answer);
	}

}
