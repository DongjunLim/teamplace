/*
나 올수 있는 문자들을 digit과 roman 배열을 활용하여 미리 저장해 놓았습니다.
주어진 수를 digit에 있는 숫자로 표현할 수 있다면 해당 문자를 return합니다.
이와 동시에 digit를 뺀 나머지 숫자를 대상으로 또 다시 탐색합니다.
이 과정은 재귀적으로 실행되며 상수시간 안에 해결됩니다.
*/

public class Leetcode12_Integer_to_Roman {

    static int[] digit = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        return getConversion(num);
    }

    private static String getConversion(int num) {
        if (num == 0) return "";

        int index;
        index = getDiversor(num);
        return roman[index] + getConversion(num - digit[index]);
    }

    private static int getDiversor(int num) {
        for (int index = 0; index < digit.length; index++) {
            if (num / digit[index] > 0) return index;
        }
        return -1;
    }

    public static void main(String[] args) {
        int num = 490;
        String answer = intToRoman(num);
        System.out.print(answer);
    }
}
