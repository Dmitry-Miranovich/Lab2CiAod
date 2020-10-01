public class Obj<K,V> {
    private final K key;
    private final V value;
    private boolean check;
    Obj(K key, V value){
        this.key =key;
        this.value = value;
        this.check = false;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public boolean isCheck() {
        return check;
    }
    public boolean deletePair() {
        if (!this.check) { //удален ключ == удалено значение
            this.check = true;
            return true;
        }
        else
            return false;
    }
}
