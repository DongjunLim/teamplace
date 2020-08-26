/**
 *
 *  @문제접근
 *  스택을 사용해 풀었습니다.
 *  숫자는 스택에 삽입하고,
 *  연산자를 만나면 스택에서 숫자 두개를 꺼내 계산하고 스택에 집어넣습니다.
 *
 *  @성능
 *  Runtime: 4 ms
 *  Memory Usage: 39.1 MB
 *  시간복잡도: O(N)
 *
 */
public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for(String c: tokens){
        if(c.equals("*"))
            stack.push(stack.pop() * stack.pop());
        else if(c.equals("/")){
            int div1 = stack.pop();
            int div2 = stack.pop();
            stack.push(div2 / div1);
        }
        else if(c.equals("+"))
            stack.push(stack.pop() + stack.pop());
        else if(c.equals("-")){
            int sub1 = stack.pop();
            int sub2 = stack.pop();
            stack.push(sub2 - sub1);
        }
        else
            stack.push(Integer.parseInt(c));
    }
    return stack.pop();
}
