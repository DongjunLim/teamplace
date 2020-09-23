/*
BST로 접근해야 하는 문제. 다시 풀어야함

Time Complexity: O(N^2)
Space Complexity: O(N)
*/
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i =0;i< nums.length; i++){
            int target = nums[i];
            int cnt = 0;
            for(int j = i +1; j< nums.length; j++){
                if(target >nums[j]){
                    cnt++;
                }  
            }
            answer.add(cnt); 
        }
        return answer;
    }
}