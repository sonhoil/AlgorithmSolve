package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class al_5576 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] N = new int[10];
		int[] M = new int[10];
		int count1 = 0;
		int count2 = 0;
		for(int i=0;i<20;i++) {
			if(i<10) {
				N[i] =  sc.nextInt();
			}else {
				M[i-10] =  sc.nextInt();
			}
		}
		Arrays.sort(N);
		Arrays.sort(M);
		for(int i=1;i<=3;i++) {
			count1 = count1 + N[N.length-i];
			count2 = count2 + M[M.length-i];
		}
		System.out.println(count1+" "+count2);
	}

}
