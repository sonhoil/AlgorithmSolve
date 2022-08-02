package algorithm;

import java.util.Scanner;

public class al_1436 {

	static boolean count6(int n) {
	    int cnt = 0;
	    while (n > 0)
	    {
	        if (n % 10 == 6)
	            cnt += 1;
	        else
	            cnt = 0;
	        if (cnt >= 3)
	            return true;
	        n /= 10;
	    }
	    return false;		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int answer = 665;
		
		while ( N > 0) {
			answer += 1;
			if (count6(answer))
				N -= 1;
		}
	    
	    System.out.println(answer);		
	}

}
