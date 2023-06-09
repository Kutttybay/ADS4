import java.util.LinkedList;
public class HashTable<K, V> {
    private LinkedList<HashNode<K, V>>[] chain;
    private int M = 11;
    private int size;
    /*
    * конструктор создает хэш-таблицу со стандартным размером M и инициализирует пустой связанный список для каждого ячейки таблицы.
    */
    public HashTable(){
        chain = new LinkedList[M];
        size = 0;
    }

    /*
    * Defence
    *
    */
    public V replace(K key, V value, Object nValue){
        int index = hash(key);
        if (chain[index] == null) {
            return value;
        }
        for (HashNode<K,V> node: chain[index]){
            if (node.getKey().equals(key)){
                node.setValue(value);
                put(key, value);
            }
        }
        if (value == nValue){
            return value;
        }
        for (HashNode<K,V> node: chain[index]){
            if (node.getKey().equals(key)){
                node.setValue((V) nValue);
                value = (V) nValue;
                return (V) nValue;
            }
        }
        return value;
    }
    /*
    * конструктор создает хэш-таблицу с заданным размером M и инициализирует пустой связанный список для каждого ячейки таблицы.
    */
    public HashTable(int m){
        this.M = m;
        chain = new LinkedList[M];
        size = 0;
    }
    /*
    * вычисления хэш-кода ключа "key"
    */
    private int hash(K key){
        return key.hashCode() % M;
    }
    /*
    * используется для добавления элемента с ключом "key" и значением "value" в хэш-таблицу.
    * Сначала метод "put" вычисляет индекс ячейки таблицы, в которую должен быть помещен элемент, используя метод "hash". Затем он проверяет,
    * есть ли уже связанный список для этой ячейки таблицы. Если списка нет, то он создает новый связанный список для этой ячейки.
    * Затем метод "put" проверяет, есть ли уже элемент с таким же ключом в этом списке. Если элемент найден, то его значение обновляется на новое значение. Если элемент не найден,
    * то он создает новый узел в списке с ключом и значением и увеличивает переменную size на 1, чтобы отразить увеличение размера хэш-таблицы.
    * */
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
    /*
    * используется для получения значения элемента с ключом "key" из хэш-таблицы.
    * Сначала метод "get" вычисляет индекс ячейки таблицы, в которой должен находиться элемент с заданным ключом, используя метод "hash".
    * Затем он проверяет, есть ли уже связанный список для этой ячейки таблицы. Если списка нет, то метод возвращает null, поскольку элемент с таким ключом не может быть найден.
    * Затем метод "get" итерируется по узлам в связанном списке, который соответствует заданному индексу, и проверяет каждый узел,
    * чтобы узнать, есть ли там элемент с заданным ключом.
    * Если элемент найден, то метод возвращает его значение. Если элемент не найден, то метод возвращает null.
    * */
    public V get(K key){
        int index = hash(key);
        if (chain[index] == null) return null;
        for (HashNode<K, V> node: chain[index]){
            if (node.getKey().equals(key)) return node.getValue();
        }
        return null;
    }
    /*
    *  используется для удаления элемента с ключом "key" из хэш-таблицы и возвращения его значения.
    *  Сначала метод "remove" вычисляет индекс ячейки таблицы, в которой должен находиться элемент с заданным ключом,
    *  используя метод "hash". Затем он проверяет, есть ли уже связанный список для этой ячейки таблицы.
    *  Если списка нет, то метод возвращает null, поскольку элемент с таким ключом не может быть найден.
    *  Затем метод "remove" итерируется по узлам в связанном списке, который соответствует заданному индексу, и проверяет каждый узел,
    *  чтобы узнать, есть ли там элемент с заданным ключом. Если элемент найден, то он удаляет его из списка, уменьшает переменную size на 1 и возвращает его значение. Если элемент не найден, то метод возвращает null.
    *  Если в списке было несколько элементов с заданным ключом, то удаляется только первый из них.
    * */
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

    /*
    * используется для проверки наличия элемента с заданным значением "value" в хэш-таблице.
    * Метод "contains" итерируется по всем связанным спискам в массиве "chain" и проверяет каждый узел, чтобы узнать, есть ли там элемент с заданным значением.
    * Если элемент найден, то метод возвращает true. Если элемент не найден, то метод возвращает false.
    * метод "contains" ищет элементы по значению, а не по ключу, и может вернуть true, если в хэш-таблице есть несколько элементов с одинаковым значением.
    * */
    public boolean contains(V value ){
        for (LinkedList<HashNode<K,V>> list : chain){
            for (HashNode<K,V> node: list){
                if (node.getValue().equals(value)) return true;
            }
        }
        return false;
    }
    /*
    * используется для получения ключа элемента с заданным значением "value" из хэш-таблицы.
    * Метод "getKey" итерируется по всем связанным спискам в массиве "chain" и проверяет каждый узел, чтобы узнать, есть ли там элемент с заданным значением.
    * Если элемент найден, то метод возвращает соответствующий ключ. Если элемент не найден, то метод возвращает null.
    *  метод "getKey" ищет элементы по значению, а не по ключу, и может вернуть ключ только для первого элемента с заданным значением, если в хэш-таблице есть несколько элементов с одинаковым значением.
    */

    public K getKey(V value){
        for (LinkedList<HashNode<K,V>> list : chain){
            for (HashNode<K,V> node: list){
                if (node.getValue().equals(value)) return node.getKey();
            }
        }
        return null;
    }

    /*
    * Просто возвращает размер таблицы
    * */
    public int getSize(){
        return size;
    }
}
