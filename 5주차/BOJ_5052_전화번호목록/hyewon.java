import java.util.*;

class TrieNode {
    private Map<Character, TrieNode> childNodes = new HashMap<>(); //자식 노드
    private boolean isLastChar; //마지막 글자인지에 대한 여부

    Map<Character, TrieNode> getChildNodes() {
        return this.childNodes;
    }

    boolean isLastChar() {
        return this.isLastChar;
    }

    void setIsLastChar(boolean isLastChar) {
        this.isLastChar = isLastChar;
    }
}

class Trie {
    private TrieNode rootNode;

    Trie() {
        rootNode = new TrieNode();
    }

    public boolean insert(String word) {
        TrieNode thisNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            if (thisNode.isLastChar() && i + 1 < word.length()) return false;
        }
        thisNode.setIsLastChar(true);
        return true;
    }

    public boolean contains(String word) {
        TrieNode thisNode = this.rootNode;

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            TrieNode node = thisNode.getChildNodes().get(character);

            if (node == null) return false;

            thisNode = node;
        }
        return thisNode.isLastChar();
    }
}

public class BJ_5052_전화번호_목록 {


    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for (int t = 0; t < testCase; t++) {
            int num = scanner.nextInt();
            String[] phoneBook = new String[num];

            for (int i = 0; i < num; i++) {
                phoneBook[i] = scanner.next();
            }
            solution(phoneBook);
        }
    }

    private static void solution(String[] phoneBook) {

        Trie trie = new Trie();
        boolean answer = true;

        Arrays.sort(phoneBook);

        for (String s : phoneBook) {
            if (!trie.insert(s)) {
                answer = false;
                break;
            }
        }
        System.out.println(answer ? "YES" : "NO");
    }
}
