/*
해쉬맵을사용해서 모든 substring을 넣었음 그중 가장 많이나온거가 답
*/

class Solution {
    static int max;
    public int longestMountain(int[] A) {
         max=0;
        for (int i=0;i<A.length;i++){
            findMountain(A,i);
        }
        
        return max;
    }
    static void findMountain(int[] arr,int mid){
        int left=mid-1;
        int right=mid+1;
        if(left<0||right>arr.length-1)return;;

        while (left>=0){
            if (arr[left]>=arr[left+1]){
                left++;break;
            }else{
                left--;
            }
        }
        while (right<=arr.length-1){
            if (arr[right]>=arr[right-1]){
                right--;break;
            }else{
                right++;
            }
        }
        if (left<0)left=0;
        if (right>arr.length-1)right=arr.length-1;

        int temp=right-left+1;
        if(left!=mid&&right!=mid)
        max=Math.max(max,temp);
    }
}
