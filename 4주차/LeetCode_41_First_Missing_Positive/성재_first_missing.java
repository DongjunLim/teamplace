package leetcode;
/*
 * 해쉬셋을 사용하여 접근하지 않은 값을 구함 ->속도면에서 매우 느림
 */
import java.util.*;
public class first_missing_positive_41 {
	static int nums[]= {3,4,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(nums.length==0) {
			System.out.println(1);
		}else {
		HashSet h=new HashSet();
		int max=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<1)continue;
			max=Math.max(nums[i], max);
			h.add(nums[i]);
		}
		int x=0;
		while(true) {
			x++;
			if(!h.contains(x)) {
				break;
			}
		}
		System.out.println(x);
	}
	}
}



//if(nums[i]<1)continue;
//if(s+1==m) {
//	e++;
//	m=e;
//	s=e;
//}else if(s==nums[i])s++;
//if(e<nums[i]) {
//	if(e==m) {
//		e=nums[i];
//		m=nums[i];
//	}else e=nums[i];
//}
