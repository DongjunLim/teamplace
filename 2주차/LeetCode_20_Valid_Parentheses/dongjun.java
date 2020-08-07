/**
 *  @성능
 *  Runtime: 2 ms
 *  Memory Usage: 37.7 MB
 *  시간복잡도: O(n)
 *  
 *  @문제접근
 *  스택을 사용해 풀었습니다.
 */


class Solution20 {
    public boolean isValid(String s) {
        ArrayList<Character> leftBracket = new ArrayList<>(Arrays.asList('(', '{', '['));
        ArrayList<Character> rightBracket = new ArrayList<>(Arrays.asList(')', '}', ']'));

        char[] str = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for(char chr: str){
            if(leftBracket.contains(chr))
                stack.add(chr);

            else if(stack.isEmpty())
                return false;

            else if(rightBracket.contains(chr)){
                int rightBracketIdx = rightBracket.indexOf(chr);
                int leftBracketIdx = leftBracket.indexOf(stack.peek());

                if(leftBracketIdx == rightBracketIdx)
                    stack.pop();
                else
                    return false;
            }
        }

        if(!stack.isEmpty())
            return false;
        else
            return true;
    }
}
