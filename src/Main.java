import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello to Assignment 4");
        HashTable hashTable = new HashTable<TestingClass, String>();
        Random r = new Random();
        // Create numbers by random
        for (int i = 0; i < 10000; i++){
            int val = r.nextInt(0, 1000000);
            hashTable.put(new TestingClass(val), "Student " + val);
        }
        System.out.println(hashTable.get(1));
        System.out.println(hashTable.get(2));
        System.out.println(hashTable.get(3));
        hashTable.replace(3, 4, 132);
        System.out.println(hashTable.get(4));
        System.out.println(hashTable.get(5));
        System.out.println(hashTable.get(6));
        hashTable.contains(3);
        hashTable.remove(6);

    }
}

// Class for testing
class TestingClass{
    private int val;
    public TestingClass(int v){
        this.val = v;
    }
    @Override
    public int hashCode(){
        return Integer.hashCode(val);
    }
}