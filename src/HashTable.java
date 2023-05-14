import java.util.LinkedList;
public class HashTable<K, V> {
    private LinkedList<HashNode<K, V>>[] chain;
    private int M = 25;
    private int size;
    public HashTable(){
        chain = new LinkedList[M];
        size = 0;
    }
    public HashTable(int m){
        this.M = m;
        chain = new LinkedList[M];
        size = 0;
    }
    private int hash(K key){
        return key.hashCode() % M;
    }
    public void put(K key, V value){
        int index = hash(key);
        if (chain[index] == null){
            chain[index] = new LinkedList<HashNode<K,V>>();
        }
        for (HashNode<K,V> node: chain[index]){
            if (node.getKey().equals(key)){
                node.setValue(value);
                return;
            }
        }
        chain[index].add(new HashNode<K, V>(key, value));
        size ++;
    }
    public V get(K key){
        int index = hash(key);
        if (chain[index] == null) return null;
        for (HashNode<K, V> node: chain[index]){
            if (node.getKey().equals(key)) return node.getValue();
        }
        return null;
    }
    public V remove(K key){
        int index = hash(key);
        if (chain[index] == null) return null;
        for (HashNode<K, V> node: chain[index]){
            if (node.getKey().equals(key)){
                chain[index].remove(node);
                size--;
                return node.getValue();
            }
        }
        size--;
        return null;
    }

}
