/**
 *
 *  @��������
 *  ������ ����� Ǯ�����ϴ�.
 *  ���ڴ� ���ÿ� �����ϰ�,
 *  �����ڸ� ������ ���ÿ��� ���� �ΰ��� ���� ����ϰ� ���ÿ� ����ֽ��ϴ�.
 *
 *  @����
 *  Runtime: 4 ms
 *  Memory Usage: 39.1 MB
 *  �ð����⵵: O(N)
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
