public class Leetcode394_Decode_String {
/*
주어진 스트링을 복호화(decode) 하는 문제
반복의 횟수와 반복 시작 index, 끝 index를 찾는 것이 관건

decoding 과정
1. ("[") 의 시작 위치를 찾는다.
2. 시작 위치 전까지는 StringBuffer에 추가
3. 반복 횟수를 찾는다.
4. 열린괄호와 닫힌 괄호의 갯수를 counting하여
   열린괄호와 닫힌 괄호의 갯수가 같아질 경우
   startIndex에서 부터 현재 index까지의 subString에 대하여 decoding과정을 진행한다.
5. 반복 횟수반큼 StringBuffer에 추가한다.
6. 남든 String에 대하여 또다시 decoding과정을 진행한다.

Time Complexity: O(N) // N is length of string
 */
    public static String decodeString(String s) {
        if (s == null || !s.contains("[")) return s;

        StringBuilder stringBuilder = new StringBuilder();

        int stratIndex = s.indexOf("[");
        int index = 0;

        while (index < stratIndex && !Character.isDigit(s.charAt(index))) {
            stringBuilder.append(s.charAt(index++)); //("[") 이전 까지의 값은 반복의 대상이 아니므로 그냥 추가
        }
        int number = Integer.parseInt(s.substring(index, stratIndex)); // 반복 횟 수 지정

        int openCount = 1; // "["이후부터 시작이므로 1로 setting , []내부에 또 [] 가 있는 경우를 체크하기 위한 변수이다.
        for (index = stratIndex + 1; index < s.length(); index++) {
            if (s.charAt(index) == '[') {
                openCount++;
                continue;
            }
            if (s.charAt(index) == ']') {
                openCount--;
            }
            if (openCount == 0) {
                String innerStr = decodeString(s.substring(stratIndex + 1, index)); // 또다시 []가 반복되는 경우가 있으므로 다시 decodeString함수를 호출
                for (int i = 0; i < number; i++) {
                    stringBuilder.append(innerStr); // 원하는 만큼 반복 String을 덪붙힘
                }
                stringBuilder.append(decodeString(s.substring(index + 1))); // 남은 스트링에 대하여 decode과정 진행
                return stringBuilder.toString();
            }
        }
        return "";
    }

    public static void main(String[] args) {
//        String s = "3[a2[c]]";
        String s = "2[abc]3[cd]ef";

        String answer = decodeString(s);
        System.out.print(answer);
    }
}
