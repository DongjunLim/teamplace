package LEETCODE;
/*
1. binary search tree 사용
2. 맨뒤에부터 시작, 맨뒤가 루트
3. 현노드보다 크면 오른쪽으로 가면서 카운트는 현노의 왼쪽개수를 포함시킴
4. 현노드보다 작으면 왼쪽으로 가면서 카운트는 유지
 */
import java.util.*;
public class leet_315_CountofSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        int[] nums={2,0,1};
        ArrayList<Integer> arr=new ArrayList<>();
        Bstnode btn[]=new Bstnode[nums.length];
        if (nums.length>0) {
           btn[nums.length-1]=new Bstnode(nums[nums.length-1]);
           for (int i=nums.length-2;i>=0;i--){
                btn[i]=new Bstnode(nums[i]);
                insert(btn[i],btn[nums.length-1],0);
           }
           for (int i=0;i< btn.length;i++){
               System.out.println(btn[i].now+"  "+btn[i].size);
               arr.add(btn[i].size);
           }
        }
    }
    static void insert(Bstnode node,Bstnode lastNode,int count){

        if (lastNode.now<node.now){
            count+=(lastNode.lsize+1);
            if (lastNode.right==null){
                lastNode.right=node;
                node.size=count;
            }else
            insert(node,lastNode.right,count);
        }else{
            lastNode.lsize++;
            if (lastNode.left==null){
                lastNode.left=node;
                node.size=count;
            }else
            insert(node,lastNode.left,count);
        }
    }
}
class Bstnode{
    Bstnode left=null;
    Bstnode right=null;
    int lsize=0;int rsize=0;
    int now=0;int size=0;
    Bstnode(int now){
        this.now=now;
    }

}
