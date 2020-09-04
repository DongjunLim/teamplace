import java.util.HashMap;
/*
 * 유니온 파인드 알고리즘을 사용함
 * 최대 최소값을 알수없어서 배열이아닌 HashMap을 사용했음
 * 각 값들이들어오면 먼저 자기보다 1큰수가 있는지 없는지 확인한 후 있으면  1큰수의 부모를 자신의 부모로 만듬
 * 그후 1작은 수를 확인한뒤 있으면 1작은수의 부모를 자신의 부모로 바꿈
 * 마지막 다시 한바퀴 돌면서 각 부모와 자신의 값을 빼서 최대길이를 확인함 -> but 입력 순서가 뒤죽박죽이라 업데이트가 안된애들이 있어서 findback으로 연결된
 * 가장 큰 부모를 찾아서 빼야됨
 */
public class Longest_Consecutive_Sequence {
	static HashMap h;
	static int nums[]= {1,3,5,2,4};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  h=new HashMap();
			for(int i=0;i<nums.length;i++) {
				h.put(nums[i], nums[i]);
				int temp=find(nums[i]+1);
				h.put(nums[i],temp);
				
				if(h.containsKey(nums[i]-1)) {
					h.put(nums[i]-1,temp);
				}
				
			}
			
			int max=0;
			for(int i=0;i<nums.length;i++) {
				int temp=(int)h.get(nums[i]);
				if((int)h.get(temp)!=temp) {
					temp=backfind(temp);
				}
				max=Math.max(max, (temp-nums[i]+1));
			}
	        System.out.println(max);
		}
		static int backfind(int t) {
			int temp=(int)h.get(t);
			if(t==temp) {
				return temp;
			}else {
				return backfind(temp);
			}
		}
		static int find(int x) {
			if(h.containsKey(x)) {
				int temp=(int)h.get(x);
				if(x==temp)return x;
				else return find(temp);
			}
			else return x-1;
		}
	}
