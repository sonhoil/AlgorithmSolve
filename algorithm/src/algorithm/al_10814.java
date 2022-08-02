package algorithm;


import java.util.Scanner;


public class al_10814 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num =  sc.nextInt();
		int [] age = new int [num];
		String [] name = new String [num];
		for(int i=0;i<num;i++) {
			age[i] = sc.nextInt();
			name[i] = sc.next();
		}
		for(int i=0;i<age.length-1;i++) {
			int A = age[i];
			String temp = "";
			for(int j=i+1;j<age.length;j++) {
				int B = age[j];
				String nm = name[j];
				if(A>B) {
					for(int k=j-1;k>=0;k--) {
						int temp2 = 0;
						int C = age[k];
						if(B < C) {
							temp2 = age[k];
							age[k+1] = temp2;
							age[k] = B;
							
							temp = name[k];
 						    name[k+1] = temp;
						    name[k] = nm;
						}else {
							break;
						}
					}
					break;
				}
				if(A == B) {
					break;
				}
			}
		}
		for(int i=0;i<age.length;i++) {
			System.out.println(age[i]+" "+name[i]);
		}
	}
}


