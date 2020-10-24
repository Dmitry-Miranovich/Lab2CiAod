public class HashMap<K,V> {
    private List<Pair<K, V>>[] hashmap;
    private int size = 0;
    public HashMap() {
        int INIT_SIZE = 1000;
        hashmap = new List[INIT_SIZE];
        for (int i = 0; i < INIT_SIZE; i++)
            hashmap[i] = new List<>();
    }
    /*
    * Метод добавление в хеш-таблицу имеет особенность, в случае если добавляют элемент с одинаковым ключом в лист,
    * где уже похожий был инициализирован, то он заменяется на новый.
     */
    public void put(K key, V value) {
        if (size == hashmap.length)
            resizeHashmap(hashmap.length * 2);
        int h = hashCode(key);
        if (!hashmap[h].isEmpty()) {
            boolean ParamIfThereIsNoCoincidences = true;
            for (int i = 0; i < hashmap[h].size(); i++)
                if (hashmap[h].get(i).key == key) {
                    hashmap[h].add(new Pair<>(key, value), i);
                    ParamIfThereIsNoCoincidences = false;
                    break;
                }
            if(ParamIfThereIsNoCoincidences)
                hashmap[h].add(new Pair<>(key, value));
        }else
            hashmap[h].add(new Pair<>(key, value));
        size++;
    }

    public V get(K key) {
        int h = hashCode(key);
        V value = null;
        if(hashmap[h].isEmpty()){
            return null;
        }
        else {
            for(int i = 0; i<hashmap[h].size(); i++)
                if(hashmap[h].get(i).key == key){
                    value = hashmap[h].get(i).value;
                    break;
                }
        }
        return value;
    }

    public V remove(K key) {
        V value = null;
        int h = hashCode(key);
        if (hashmap[h].isEmpty())
            return null;
        else {
            for (int i = 0; i < hashmap[h].size(); i++)
                if (hashmap[h].get(i).key == key) {
                    value = hashmap[h].get(i).value;
                    hashmap[h].remove(i);
                    break;
                }
        }
        size--;
        return value;
    }

    public int hashCode(K key) {
        if(key == null){
            throw new IndexOutOfBoundsException("Thrown invalid key name");
        }
        int h = 0;
        char []BinaryArray = key.toString().toCharArray();
        for (char c : BinaryArray) {
            h += c;
        }
        return h % hashmap.length-1;
    }

    private void resizeHashmap(int newSize) {
        List<Pair<K, V>>[] newArray = new List[newSize];
        for (int i = 0; i < newSize; i++) {
            newArray[i] = new List<>();
        }
        System.arraycopy(hashmap, 0, newArray, 0, size);
        hashmap = newArray;
    }

    static private class Pair<K, V> {
        private final K key;
        private final V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        Pair() {
            this.key = null;
            this.value = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

