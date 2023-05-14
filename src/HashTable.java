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
}
