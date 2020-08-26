package leetcode;
/*
 * 1.<key , value> 쌍의 해쉬맵사용
 * 2.최근에 들어온 key 값을 큐에 넣어놓고 사용
 * 3.key값이 원래있었다면 해쉬맵의 값을 교체하고 큐에서 그값을 삭제한후 맨뒤로 넣어줌
 * 4.사이즈 초과+원래 없던 키값이 들어오면 해쉬맵에 넣어주고, 큐에서 가장 앞에있는 값을 빼주고 그 키값을 해쉬맵에서 제거
 */
import java.util.*;
public class LRUCache {
	HashMap map=new HashMap();
	Queue q=new LinkedList();
	int max;
	int nowc=0;
	public LRUCache(int capacity) {
		max=capacity;
	}
    
    public int get(int key) {
    	
    	if(map.containsKey(key)) {
    		q.remove((Integer)key);
        	q.add(key);
    		return (int)map.get(key);
    	}
    	else return -1;
    }
    
    public void put(int key, int value) {
    	if(nowc==max) {
    		if(map.containsKey(key)) {
    			map.put(key, value);
        		q.remove((Integer)key);
        		q.add(key);
    		}else {
    			map.put(key, value);
    			int temp=(int) q.poll();
    			map.remove(temp);
    			q.add(key);
    		}
    	}else {
    		map.put(key, value);
    		q.remove((Integer)key);
    		q.add(key);
    		nowc=q.size();
    	}
//    	System.out.println("현재 들어있는 크기:  "+nowc);
    }
}
