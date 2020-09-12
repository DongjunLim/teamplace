import java.util.Scanner;

/*
s: 제공되는 문자열
pattern: 찾고자 하는 패턴
s에 pattern이 중복을 제외하고 몇번 포함되어있는지를 찾는 문제

s에서 pattern의 길이만큼 substring을 잘라 검사한다.
pattern matching이 성공한 경우 index를 pattern의 길이만큼 증가시켜 중복 검사를 방지한다.

Time Compelxity: O(L^M)
Space Complexity: O(M)

L:length of s
M:length of pattern

 */
public class BJ_1543_문서_검색 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String pattern = scanner.nextLine();
        solution(s, pattern);
    }

    private static void solution(String s, String pattern) {

        int cnt = 0;
        int index = 0;
        while (index <= s.length() - pattern.length()) {
            String temp = s.substring(index, index + pattern.length());

            if (patternMatching(temp, pattern)) {
                index += pattern.length();
                cnt++;
            } else {
                index++;
            }
        }
        System.out.print(cnt);
    }

    private static boolean patternMatching(String temp, String pattern) {
        return temp.equals(pattern);
    }
}
/*
abcababab
ab
 */