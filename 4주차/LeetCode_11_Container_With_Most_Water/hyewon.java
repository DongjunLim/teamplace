/*
Time Complexity:O(N)
Space Complexity:O(1)
*/

public class Leetcode11_Container_With_Most_Water {

    public static int maxArea(int[] height) {
        int result = 0;

        int left = 0;
        int right = height.length -1;

        while(left < right){
            int currentArea = (right - left) * Math.min(height[left],height[right]);
            result = Math.max(result,currentArea);

            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return result;
    }

    public static void main(String[] args) {
        // write your code here
        int[] height ={ 1,8,6,2,5,4,8,3,7};
        int answer = maxArea(height);
        System.out.print(answer);
    }
}
