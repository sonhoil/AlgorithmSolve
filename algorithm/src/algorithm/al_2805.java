package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class al_2805 {

	static int N, M;
	static int v_max;
	static int tree[];
	
	static boolean solve(int mid) {
		long count = 0;
		for(int i=0;i<tree.length;i++) {
			if(tree[i] - mid > 0)
			count = count + tree[i] - mid;
		}
		System.out.println("count =>"+count);
		if(count >= M) {
			return true;
		}else {
			return false;
		}
	}
	
	static int bs() {
		int left = 0;
		int right = v_max;
		int mid = 0;
		while(right >= left) {
			 mid = (right + left) / 2;
			 System.out.println("right=>"+right);
			 System.out.println("left=>"+left);
			 System.out.println("mid=>"+mid);
			 if(solve(mid)) {
				 left = mid + 1;
			 }else {
				 right = mid -1;
			 }
		}
		return right;
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		tree = new int[N];
		v_max = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			v_max = Math.max(v_max, tree[i]);
		}
		
		int answer = bs();
		
		System.out.println(answer);
		
		
	}

}
