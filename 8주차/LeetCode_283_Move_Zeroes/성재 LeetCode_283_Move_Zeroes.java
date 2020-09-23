package LEETCODE;
/*
투포인터 사용
0이라면 그냥 넘기고 아니면 그자리에 값을 넣는다
배열의 크기만큼 나머지에 0을 추가한다
 */
import java.util.LinkedList;
import java.util.Queue;

public class leet283_MoveZeroes {
    public static void main(String[] args) {
        int nums[]={0,1,0,3,12};

        int s=0;

        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[s]=nums[i];
                s++;
            }
        }
        for (int i=s;i<nums.length;i++){
            nums[i]=0;
        }
        for (int i=0;i<nums.length;i++)System.out.println(nums[i]);
    }
}
