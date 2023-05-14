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