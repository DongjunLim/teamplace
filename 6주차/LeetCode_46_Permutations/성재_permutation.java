import java.util.*;
/*
next_permutation 알고리즘 사용
1. 맨뒤에서부터 앞으로 올라오면서 [i-1]<[i]인 지점을 찾음
2. 다시 뒤에서부터 [i-1]<[j] 인 지점을 찾음         (j=nums.length-1부터시작)
3. [i-1],[j] swap
4. i>j{i++,j--} 하면서 swap(i,j)      (j는 다시 맨뒤부터)
DFS보다 성능이 좋음
*/
class Solution {
    static List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
    list = new ArrayList();
     Arrays.sort(nums);
		push(nums);
		while(next_permutation(nums)){}
		
		return list;
	}
	static boolean next_permutation(int[] arr) {
		int i=arr.length-1;
		while(i>0&&arr[i-1]>=arr[i])i--;
		if(i<=0)return false;
		
		int j=arr.length-1;
		while(arr[j]<=arr[i-1]) {
			j--;
		}
		swap(i-1,j,arr);
		j=arr.length-1;
		for(;i<j;i++,j--)swap(i,j,arr);
		
		push(arr);
		return true;
	}
	static void push(int arr[]) {
		ArrayList a=new ArrayList();
		for(int i=0;i<arr.length;i++)a.add(arr[i]);
		list.add(a);
	}
	static void swap(int i,int j,int[] arr) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
