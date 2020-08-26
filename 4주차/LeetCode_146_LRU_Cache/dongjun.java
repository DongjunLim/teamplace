/**
 *  @문제접근
 *  해시맵과 이중연결리스트로 구현했습니다.
 *
 * 
 *  @성능
 *  Runtime: 33 ms
 *  Memory Usage: 58.3 MB
 * 
 */
class LRUCache {

    public class Node{
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            Node temp = map.get(key);

            if(temp != head){
                if(temp == tail){
                    tail = tail.prev;
                }
                if(temp.prev != null)
                    temp.prev.next = temp.next;
                if(temp.next != null)
                    temp.next.prev = temp.prev;
                temp.prev = null;
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
        }
        return head.val;
    }

    public void put(int key, int value) {
        if(get(key) == -1){
            Node newNode = new Node(key, value);
            if(map.size() == capacity){
                    map.remove(tail.key);
                    tail = tail.prev;
            }
            if(head == null){
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            map.put(key, newNode);
        } else{
            map.get(key).val = value;
        }
    }
} 
