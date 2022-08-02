package algorithm;

import java.io.IOException;
import java.util.Scanner;

public class devideSum {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N, M =0;
		N = sc.nextInt();
		int result = 0;
		for(int i=1;i<=N;i++) {
			result = devide(i,N);
			if(result > 0) {
				System.out.println(result);
				break;
			}else if(i==N && result==0) {
				System.out.println(result);
			}
		}
	}
	
	public static int devide(int num,int N) {
		int sum = 0;
		
		int dev = num;
		while(dev > 0) {
			sum = sum + dev % 10;
			dev = dev/10;
		}
		sum= sum + num;
		if(sum == N) {
			return num;
		}else {
			return 0;
		}
	}

}
