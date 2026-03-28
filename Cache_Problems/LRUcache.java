package Cache_Problems;

import java.util.HashMap;

public class LRUcache {

    public static void main(String args[]){
        LRUcache cache = new LRUcache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // -1

        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
    
    class Node{
        int key, value;
        Node next, prev;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> hm;
    int capacity;
    Node head;
    Node tail;

    public LRUcache(int c){
        capacity = c;
        hm = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.next = head;
    }

    public void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node){
        Node next = head.next;

        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;
    }

    public int get(int key){
        if(!hm.containsKey(key)){
            return -1;
        }
        Node node = hm.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value){
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.value = value;
            remove(node);
            insert(node);
        }
        else{
            if(hm.size() == capacity){
                Node lru = tail.prev;
                remove(lru);
                hm.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insert(newNode);
            hm.put(key, newNode);
        }
    }
}
