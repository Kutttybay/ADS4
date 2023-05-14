public class Main {
    public static void main(String[] args) {
        System.out.println("Hello to Assignment 4");
    }
}
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