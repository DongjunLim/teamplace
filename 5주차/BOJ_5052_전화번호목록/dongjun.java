/**
 *  @��������
 *  Ʈ���� �ڷᱸ���� Ǯ�����ϴ�.
 *
 *  @����
 *  Runtime: 748 ms
 *  Memory Usage: 125008 KB
 *  �ð����⵵: O(NM)   N = ��ȣ ����, M = ��ȣ ����
 */
public class BOJ_5052_��ȭ��ȣ��� {
    public static BufferedReader br;
    public static String answer;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            int n = Integer.parseInt(br.readLine());

            String[] input = new String[n];
            for(int i = 0; i < n; i++)
                input[i] = br.readLine();

            Arrays.sort(input);

            System.out.println(solve(input, n));
        }
        br.close();
    }

    public static String solve(String[] inputString, int n){
        Trie root = new Trie();

        for(int i = 0; i < n; i++){
            char[] phoneNumber = inputString[i].toCharArray();

            Trie temp = root;

            for (char number : phoneNumber) {
                if (temp.isEnd)
                    return "NO";

                if (temp.next[number - '0'] == null) {
                    temp.next[number - '0'] = new Trie();
                    temp.cnt++;
                }
                temp = temp.next[number - '0'];
            }
            if(temp.cnt > 0)
                return "NO";

            temp.isEnd = true;
        }
        return "YES";
    }
}

class Trie {
    boolean isEnd;
    int cnt;
    Trie[] next;

    public Trie(){
        next = new Trie[11];
        this.cnt = 0;
        this.isEnd = false;
    }
}
