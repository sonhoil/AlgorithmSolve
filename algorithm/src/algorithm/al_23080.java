package algorithm;

import java.util.Scanner;

public class al_23080 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String M = sc.next();
		String[] Marr = M.split("");
		
		for(int i=0;i<Marr.length;i++) {
			if(i%N == 0) {
				System.out.print(Marr[i]);
			}
		}
		

	}

}
