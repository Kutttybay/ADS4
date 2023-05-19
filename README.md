# $\S1.$ HashTable
## HashTable 
``` java
    public HashTable(){
        chain = new LinkedList[M];
        size = 0;
    }
    
    public HashTable(int m){
        this.M = m;
        chain = new LinkedList[M];
        size = 0;
    }
```
Description : This is constructors

## hash
``` java
    private int hash(K key){
        return key.hashCode() % M;
    }
```
Description : The code defines a private method named hash that takes a generic key as input and returns its hash code as an integer within a pre-determined range using the % operator. <br/>
This method is typically used in a hash table implementation to map keys to specific array indices for fast retrieval of values.
## put 
``` java 
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
```
Description : The put method stores a key-value pair in a hash table. It calculates the hash code of the key and checks if the corresponding index in the table is null. If a linked list already exists at that index,<br/>
it checks for an existing node with the same key and updates its value. Otherwise, a new node is added to the linked list at that index. Collision resolution is handled by chaining.

## get
``` java
    public V get(K key){
        int index = hash(key);
        if (chain[index] == null) return null;
        for (HashNode<K, V> node: chain[index]){
            if (node.getKey().equals(key)) return node.getValue();
        }
        return null;
    }
```
Decription : 
The get method retrieves the value associated with a given key from the hash table. It calculates the hash code of the key and checks if the corresponding index in the table is null. <br/>
If a linked list exists at that index, it searches for a node with the given key and returns its value. If no such node is found, it returns null.

## remove 
``` java
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
```
Description : The remove method removes a key-value pair from the hash table based on the input key. It calculates the hash code of the key and checks if the corresponding index in the table is null.<br/>
If a linked list exists at that index, it searches for a node with the given key and removes it from the list. The size of the hash table is decremented and the value associated with the removed key is returned.<br/>
If no such node is found, it returns null.

## contains 
``` java
    public K getKey(V value){
        for (LinkedList<HashNode<K,V>> list : chain){
            for (HashNode<K,V> node: list){
                if (node.getValue().equals(value)) return node.getKey();
            }
        }
        return null;
    }
```
Description : The getKey method retrieves the key associated with a given value from the hash table.<br/>
It iterates through all the linked lists in the hash table, searching for a node with the given value. If such a node is found, it returns its key. If no such node is found, it returns null.

## getSize 
``` java
    public int getSize(){
        return size;
    }
```
Description : just retrun size of Hashtable 



