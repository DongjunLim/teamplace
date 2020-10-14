import java.util.Arrays;

public class Leetcode14_Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        Arrays.sort(strs);
        int size = strs.length;
        int length = strs[0].length();
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < length; i++) {
            int cnt = 0;
            for (int index = 0; index < size - 1; index++) {
                if (strs[index].charAt(i) != strs[index + 1].charAt(i)) break;
                cnt++;
            }
            if (cnt == size - 1)
                stringBuffer.append(strs[0].charAt(i));
            else
                break;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        String answer = longestCommonPrefix(strs);
        System.out.print(answer);
    }
}
