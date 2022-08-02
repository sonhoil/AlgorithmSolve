package algorithm;

import java.util.Scanner;

public class al_1072 {
	
	static long x;
	static long y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 x = sc.nextLong();
		 y = sc.nextLong();
		 long result = binarySearch();
		 System.out.println(result);
	}
	
	 public static long binarySearch() {

		 if (x == y || 99 <= (y * 100) / x)
				return -1;
		 	long  z = (y*100)/x;
		 	long r = 1000000000;
		 	long l = 0;
		 	long mid = -1;
		 	while(r >= l) {
		 		mid = (r+l) / 2;
		 		long new_z = (y+mid)*100 / (x+mid) ;
		 		if(new_z <= z) {
		 			l = mid + 1;
		 		}else {
		 			r = mid - 1;
		 		}
		 		System.out.println("L =>"+l);
		 		System.out.println("R =>"+r);
		 		System.out.println("mid =>"+mid);
		 	}
		 	return l;
	    }


}
