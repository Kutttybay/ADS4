public class HashNode<K, V> {

    // Данный класс представляет собой узел хеш-таблицы
    // Класс имеет два поля - key и value, конструктор, геттеры и сеттер для поля value, а также переопределенный метод toString
    private K key;
    private V value;
    public HashNode(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }

    public void setValue(V value){
        this.value = value;
    }

    @Override
    public String toString(){
        return "{" + key + " " + value + "}";
    }
}
