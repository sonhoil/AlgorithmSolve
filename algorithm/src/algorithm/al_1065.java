package algorithm;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
public class al_1065 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		if(N>=100) {
			cnt = 99;
			for(int i=100;i<=N;i++) {
				cnt = cnt +checkOneNumber(i);
			}
		}else {
			cnt = N;
		}
		System.out.println(cnt);
	}
	public static int checkOneNumber(int num) {
		ArrayList<Integer> integers = new ArrayList<Integer>();
		HashSet<Integer> gap = new HashSet<>();
		while(num >= 1) {
			integers.add(num % 10);
			num = num / 10;
		}
		
		for(int i=0;i<integers.size()-1;i++) {
			gap.add(integers.get(i) - integers.get(i+1));
		}
		
		if(gap.size() == 1) {
			return 1;
		}
		return 0;
	}
}
