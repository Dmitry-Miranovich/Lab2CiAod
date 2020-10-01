public class Main {
    public static void main(String[] args) {
        Obj<Integer, String> s= new Obj<>(10,"s");
        Obj<Integer, String> ss= new Obj<>(10,"s");
        System.out.println(s.hashCode() +"\n"+ ss.hashCode());
    }
}
