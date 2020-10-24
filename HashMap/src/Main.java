
public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("SSA", 21);
        hashMap.put("Ssa", 32);
        System.out.println(hashMap.get("SSA"));
        System.out.println(hashMap.remove("SsA"));
        System.out.println(hashMap.get("SSA"));
        System.out.println(hashMap.get("Ssa"));
    }
}
