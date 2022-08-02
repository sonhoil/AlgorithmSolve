package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class al_1517 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int num = Integer.parseInt(br.readLine());
		int [] numbers = new int [num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<num;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0 ;
		for(int i = 0; i < numbers.length; i++) {
	        for(int j = 0 ; j < numbers.length - i - 1 ; j++) {
	            if(numbers[j] > numbers[j+1]) {
	                int temp = numbers[j+1];
	                numbers[j+1] = numbers[j];
	                numbers[j] = temp;
	                cnt++;
	            }
	        }
	    }
		System.out.println(cnt);
	}

}
