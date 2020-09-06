/**
 *  @문제접근
 *  nums를 문자열로 변환하고
 *  람다식으로 정렬조건을 변환해 풀었습니다.
 *
 *  @성능
 *  Runtime: 5 ms
 *  Memory Usage: 39.2 MB
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];

        for(int i = 0; i < s.length; i++)
            s[i] = String.valueOf(nums[i]);

        Arrays.sort(s, (e1, e2) -> {
            String a1 = e1 + e2;
            String a2 = e2 + e1;
            return a2.compareTo(a1);
        });

        String answer = "";

        for(int i = 0; i < s.length; i++){
            String a = s[i];

            if(a.equals("0") && answer.equals(""))
                continue;
            answer += a;
        }
        return answer.equals("") ? "0" : answer;
    }
}
