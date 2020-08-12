package leetcode;
/*
 * nums와 같은 배열을 만든 후 (arr) 소팅
 * 소팅후 원래의 배열 nums와 비교하여 바뀐점의 시작점과 마지막 점을찾음
 * 두값을 빼고 +1 시킨 값이 바꿔야할 값, 많약 바꾸지 않을시에는 0을 리턴
 * 6ms 	40.8 MB
 */
import java.util.*;
public class shortest_unsorted_continuous_subarray {
	static int[] nums= {2, 6, 4, 8, 10, 9, 15};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=nums.clone();
		Arrays.sort(arr);
		int res=0;
		int s=-1,e=-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=arr[i]) {
				if(s==-1)s=i;
				e=i;
			}
		}
		if(s==-1) {
			return res;
		}else {
			res=e-s+1;
			return res;
		}
		
	}

}
