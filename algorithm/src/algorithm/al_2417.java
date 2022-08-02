package algorithm;

import java.math.BigInteger;
import java.util.Scanner;

public class al_2417 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num =  sc.next();
		BigInteger bigNumber = new BigInteger(num);
		BigInteger div = new BigInteger(num);
		BigInteger X = new BigInteger(num);
		/*
		 * int div = num; int X = num;
		 */
		BigInteger temp =  new BigInteger(num);
		while(true) {
			temp = div;
			div = div.divide(BigInteger.valueOf(2));
			X = div.multiply(div);
			if(X.compareTo(bigNumber) < 0 || X.compareTo(bigNumber) == 0 ) {
				break;
			}
		}
		System.out.println("X =>"+X);
		System.out.println("div =>"+div);
		System.out.println("temp =>"+temp);

		for(BigInteger i=div;i.compareTo(temp) < 0 ||i.compareTo(temp) == 0 ;i=i.add(BigInteger.valueOf(1))) {
		System.out.println(i);
			if(bigNumber.compareTo(i.multiply(i)) == 0) {
				System.out.println(i);
				break;
			}
		}
		
	}

}
