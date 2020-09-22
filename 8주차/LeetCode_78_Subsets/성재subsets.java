package LEETCODE;
/*
BFS 방식을 이용
배열을 정렬하고 시작
맨처음 숫자하나씩 넣은상태에서 시작
현재 리스트에서 끝자리 숫자보다 큰값을 더함
반복
 */
import java.lang.reflect.Array;
import java.util.*;

public class leet78_subsets {
    static ArrayList<ArrayList<Integer>> res;
    static int[] array;
    static void bfs(ArrayList<Integer> a){
        if(a.size()==0)return;

        int min= (int) a.get(a.size()-1);
        int start=Arrays.binarySearch(array,min);

        for (int i=start+1;i<array.length;i++){
            ArrayList<Integer> temp= (ArrayList<Integer>) a.clone();
            temp.add(array[i]);
            res.add(temp);
        }

    }

    public static void main(String[] args) {
        int nums[]={1,2,3};
        array = nums.clone();
        Arrays.sort(array);
        res=new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i=0;i<nums.length;i++){
            ArrayList a=new ArrayList();
            a.add(nums[i]);
            res.add(a);
        }
        for (int i=1;i<nums.length;i++){
            int size=res.size();
            for (int j=0;j<size;j++){
                ArrayList arr=(ArrayList)res.get(j);
                if(arr.size()==i)
                bfs(arr);
            }
        }
//        for (int i=0;i<res.size();i++) {
//            ArrayList arr=(ArrayList)res.get(i);
//            for (int j=0;j<arr.size();j++){
//                System.out.printf("%d ",arr.get(j));
//            }System.out.println("");
//        }

    }
}
