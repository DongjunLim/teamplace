/**
 *  @문제접근
 *  스택을 사용해 풀었습니다.
 *
 *  @성능
 *  Runtime: 528 ms
 *  Memory Usage: 43240 KB
 *  시간복잡도: O(KN)?
 *  
 */
public class BOJ_9935_문자열폭발 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String target = sc.nextLine();
        String bomb = sc.nextLine();

        solve(target, bomb);
    }

    private static void solve(String target, String bomb) throws IOException {
        Deque<Character> deque = new ArrayDeque<>();
        Stack<Character> temp = new Stack<>();
        char lastChar = bomb.charAt(bomb.length()-1);

        for(int i = 0; i < target.length(); i++){
            deque.add(target.charAt(i));

            if(lastChar == deque.getLast() && bomb.length() - 1 <= i){
                int idx = bomb.length();

                while(--idx >= 0 && deque.getLast() == bomb.charAt(idx))
                    temp.push(deque.pollLast());

                if(idx >= 0)
                    while(!temp.isEmpty()) deque.add(temp.pop());

                else temp.clear();
            }
        }
        if(deque.isEmpty()){
            System.out.println("FRULA");
            return;
        }

        while(!deque.isEmpty()){
            bw.write(deque.pollFirst());
        }

        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
