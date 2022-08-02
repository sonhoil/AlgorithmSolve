package algorithm;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class al_11728 {
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList C = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num =  Integer.parseInt(st.nextToken());
			C.add(num);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int num =  Integer.parseInt(st.nextToken());
			C.add(num);
		}
		 Collections.sort(C);
		for(int i=0;i<C.size();i++) {
			System.out.print(C.get(i)+" ");
		}
	}

}
