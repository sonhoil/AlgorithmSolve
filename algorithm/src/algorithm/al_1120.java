package algorithm;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class al_1120 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		char[] Aarr = A.toCharArray();
		char[] Barr = B.toCharArray();
		//if(Aarr.length != Barr.length) {
			int cnt = ckeckdiff(Aarr,Barr);
	//	}
		System.out.println(cnt);
		
		
	}
	public static int ckeckdiff(char[] N,char[] M) {
		char[] check1 = new char[M.length];
		
		ArrayList<Integer> diff = new ArrayList<Integer>();
		Arrays.fill(check1, '0');
		
		int diffLength = M.length - N.length;
		int cnt1 = 0;
		
		
		for(int k=0;k<=diffLength;k++) {
			Arrays.fill(check1, '0');
			cnt1 = 0;
			int q = k;
			for(int j=0;j<N.length;j++) {
				check1[q] = N[j];
				q++;
			}
			System.out.println(Arrays.toString(check1));
			for(int i=0;i<M.length;i++) {
				if(M[i] != check1[i] &&  check1[i] != '0') {
					cnt1++;
				}
			}
			diff.add(cnt1);
		}
		int min = Collections.min(diff);

	
		return min;
		
		
	}
}
