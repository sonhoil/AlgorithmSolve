package algorithm;

import java.util.Scanner;
import java.util.Arrays;
public class al_2752 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] N = new int[3];
		for(int i=0;i<3;i++) {
			N[i] =  sc.nextInt();
		}
		Arrays.sort(N);
		for(int i=0;i<3;i++) {
			System.out.print(N[i]+ " ");
		}
	}

}
