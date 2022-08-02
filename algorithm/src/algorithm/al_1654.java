package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class al_1654 {
	static long N, M;
	static long v_max;
	static long line[];
	static ArrayList list = new ArrayList<>();
	static boolean solve(long mid) {
		long count = 0;
		if(mid == 0) {
			mid = 1;
		}
		for(int i=0;i<line.length;i++) {
			long cut = 0;
			
			if(line[i] >= mid) {
				cut = line[i]/mid;
			}
			count = count + cut;
		}
		if(count >= M){
			list.add(mid);
			return true;
		}else {
			return false;
		}
	}
	
	static long bs() {
		long left = 0;
		long right = v_max;
		long mid = 0 ;
		while(left <= right) {
			mid = (left + right)/2;
			System.out.println("left =>"+left);
			System.out.println("right =>"+right);
			System.out.println("mid =>"+mid);
			if(solve(mid)) {
				left = mid +1;
			}else {
				right = mid -1;
			}
		}
		return right;
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		line = new long[(int) N];
		v_max = 0;
		for (int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(br.readLine());
			v_max = Math.max(v_max, line[i]);
		}
		
		long answer = bs();
		System.out.println("list =>"+list);
		if(list.size()>0) {
			long max = (long) Collections.max(list);
			System.out.println(max);
		}else {
			System.out.println(0);
		}
		
		
	}

}
