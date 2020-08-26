import java.util.HashMap;
import java.util.Map;

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
public class Leetcode146_LRU_Cache {
    Map<Integer,Node> map = new HashMap<>();
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int capacity;

    public Leetcode146_LRU_Cache(int capacity) {
        this.capacity = capacity;
        join(head,tail);
    }

    public void join(Node prev,Node next){
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            moveToHead(node);
            return;
        }
        if(map.size() == capacity){
            if(tail.prev != head){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
        }
        Node node = new Node(key, value);
        moveToHead(node);
        map.put(key,node);
    }

    public void moveToHead(Node node){
        Node next = head.next;
        join(head,node);
        join(node,next);
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
