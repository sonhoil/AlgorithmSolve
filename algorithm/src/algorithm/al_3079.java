package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class al_3079 {
	static long N, M;
	static long v_max;
	static long line[];
	static ArrayList list = new ArrayList<>();
	static boolean solve(long mid) {
		long count = 0;
		for(int i=0;i<line.length;i++) {
			count = count + mid/line[i];
		}
		System.out.println("count =>"+count);
		if(count >= M) {
			return true;
		}else {
			return false;
		}
		
	}
	
	static long bs() {
		long right = v_max * M;
		long left = 0;
		long mid = 0;
		while(left < right) {
			mid = (left+right)/2;
			System.out.println("mid =>"+mid);
			System.out.println("right =>"+right);
			System.out.println("left =>"+left);
			if(solve(mid)) {
				right = mid;
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
		M = Integer.parseInt(st.nextToken());
		line = new long[(int) N];
		for(int i=0;i<N;i++) {
			line[i] = Integer.parseInt(br.readLine());
			v_max = Math.max(v_max, line[i]);
		}
		Arrays.sort(line);
		long answer = bs();
		System.out.println(answer);
	}

}
