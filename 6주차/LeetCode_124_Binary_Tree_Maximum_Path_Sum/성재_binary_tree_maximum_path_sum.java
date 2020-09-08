/*
 * 1.right left의 가장 깊은 부분에서 시작
 * 2. 현재노드를 부모노드라고 생각하지 않는다면 left,right중 한쪽으로만 들어가야됨
 * 3. left, right로 들어갔을 때 구한 값들중 더 큰값을 (둘다 음수라면 여기가 마지막 노드) 현재 노드의 값과 더한 값을 리턴
 * 4. 현재 노드를 부모노드라고 생각하면 left, right 노드양쪽다 탐색한 후 현재노드의 값과 더한후 max값과 비교
 * 
 * 문제이해잘못해서 5번틀림..
 */

class Solution {
    static int max;
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        int temp=0;
        int ltemp=0;
        int rtemp=0;
        if(root.left!=null){
            ltemp=dfs(root.left);
            if(ltemp>0)temp+=ltemp;
        }
        if(root.right!=null){
            rtemp=dfs(root.right);
            if(rtemp>0)temp+=rtemp;
        }
        
        temp+=root.val;
        max=Math.max(max,temp);
        
        return max;
    }
    static int dfs(TreeNode trn){
        int now=0;
        int rnow=0;
        int lnow=0;
        int tnow=trn.val;
        if(trn.left!=null){
            lnow=dfs(trn.left);
            if(lnow<0)lnow=0;
            else tnow+=lnow;
        }
        if(trn.right!=null){
            rnow=dfs(trn.right);
            if(rnow<0)rnow=0;
            else tnow+=rnow;
        }
        now+=trn.val+Math.max(lnow,rnow);
        max=Math.max(tnow,max);
        
        return now;
    }
}

