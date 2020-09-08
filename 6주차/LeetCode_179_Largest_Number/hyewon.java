import java.util.Arrays;
import java.util.Collections;

public class Leetcode179_Largest_Number {
    public static String largestNumber(int[] nums) {

        String answer = "";
        String[] arr = new String[nums.length];

        for(int i =0;i< nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));

        answer = String.join("",arr);
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        String answer = largestNumber(nums);
        System.out.print(answer);
    }
}