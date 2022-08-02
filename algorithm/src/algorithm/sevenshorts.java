package algorithm;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class sevenshorts {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int[] N = new int [9];
		int[] out = new int[2];
		int sum = 0;
		for(int i=0;i<9;i++) {
			N[i] = sc.nextInt();
			sum = sum +N[i];
		}
		 
		for(int j=0;j<8;j++) {
			int outertotal = sum;
			int innertotal = 0;
			outertotal = outertotal - N[j];
			for(int k=j+1;k<9;k++) {
				innertotal = outertotal;
				innertotal = innertotal - N[k];
				if(innertotal == 100) {
					out[0] = N[k];
					break;
				}
			}
			if(innertotal == 100) {
				out[1] = N[j];
				break;
			}
		}
		Arrays.sort(N);
		for(int a=0;a<9;a++) {
			if(N[a] != out[0] && N[a] != out[1]) {
				System.out.println(N[a]);
			}
		}
	}

}
