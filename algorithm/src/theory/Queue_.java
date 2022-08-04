package theory;
import java.util.LinkedList;
import java.util.Queue; 

public class Queue_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue_int = new LinkedList<Integer>();
		Queue<String> queue_str = new LinkedList<String>();
		
		queue_int.add(1); // 값 추가
		System.out.println(queue_int);
		queue_int.offer(2);
		System.out.println(queue_int);
		
		int i = queue_int.poll();
		System.out.println(i);
		System.out.println(queue_int);
		queue_int.add(3); 
		System.out.println(queue_int);
	}

}
