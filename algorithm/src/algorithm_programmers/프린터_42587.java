package algorithm_programmers;

import java.util.*;

public class 프린터_42587 {
	 	static ArrayList<Integer> list = new ArrayList<Integer>(); // 큐 사용을 위한 priorities 용 리스트
	    static ArrayList<Integer> locations = new ArrayList<Integer>(); // 위치 저장을 위한 location 용 리스트
	    static ArrayList<Integer> re = new ArrayList<Integer>(); // 출력 문서 저장을 위한 리스트
	public static void main(String[] args) {
		int[] priorities = null;
		int location = 0;
		int answer = 0;
        // 리스트 초기 값 세팅
        for(int i=0;i<priorities.length;i++){
            locations.add(i);
            list.add(priorities[i]);
        }
        
        //list에서 모든 값이 출력 될 때까지
        while(list.size() > 0){
            int val =  dequeue(list);
            int loVal =  dequeue(locations);
            //최대값 아닐경우 (우선순위 값과 위치값은 같이 움직이고 빠지도록)
            if(!checkMax(val)){
                list.add(val);
                locations.add(loVal);
            }else{
                re.add(loVal); // 출력되면 출력 리스트에 저장
            }
            
         }

        for(int i=0;i<re.size();i++){
            if(re.get(i) == location){
               // return i+1;
            }
        }
       // return answer;

	}
	// dequeu 구현
    public static int dequeue(List<Integer> list){
        if(list.size() < 1){
            return -1;
        }
        int result = list.get(0);
        list.remove(0);
        return result;
    }
    // 최대값인지 검사
    public static boolean checkMax(int a){
        for(int i=0;i<list.size();i++){
            if(list.get(i) > a){
                return false;
            }
        }
        return true;
      }
}
