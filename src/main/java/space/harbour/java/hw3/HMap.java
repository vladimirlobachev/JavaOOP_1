import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

public final class HMap<K, V> implements Map<K, V> {

    private static final int SIZE = 32;

    class Element<K, V> {
        private K key;
        private V value;

        Element(final K newKey, final V newValue) {
            this.key = newKey;
            this.value = newValue;
        }

        public void isNull() {
            System.out.println(this == null);
        }
    }


    private List<Element<K, V>>[] storage = new List[SIZE];


    @Override
    public V put(final K key, final V value) {
        if (key != null && value != null) {
            int index = key.hashCode() % SIZE;
            if (storage[index] == null) {
                List<Element<K, V>> bucket = new LinkedList<Element<K, V>>();
                storage[index] = bucket;
                bucket.add(new Element<K, V>(key, value));
            } else {
                List<Element<K, V>> bucket = storage[index];
                bucket.add(new Element<K, V>(key, value));
            }
            return value;
        }
        return null;
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public Set<V> values() {
        if (!isEmpty()) {
            Set<V> values = new HashSet<V>();
            for (List<Element<K, V>> bucket: storage) {
                if (bucket != null) {
                    for (Element<K, V> elem: bucket) {
                        values.add(elem.value);
                    }
                }
            }
            return values;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        if (!isEmpty()) {
            Set<K> keySet = new HashSet<K>();
            for (List<Element<K, V>> bucket: storage) {
                if (bucket != null) {
                    for (Element<K, V> elem: bucket) {
                        keySet.add(elem.key);
                    }
                }
            }
            return keySet;
        }
        return null;
    }

    @Override
    public void clear() {
        storage = new List[SIZE];
    }

    @Override
    public void putAll(final Map<? extends K, ? extends V> map) { }

    @Override
    public V remove(final Object key) {
        if (containsKey(key)) {
            int index = key.hashCode() % SIZE;
            for (Element<K, V> elem: storage[index]) {
                if (elem.key == key) {
                    storage[index].remove(elem);
                    return elem.value;
                }
            }
        }
        return null;
    }

    @Override
    public V get(final Object key) {
        if (containsKey(key)) {
            for (Element<K, V> elem: storage[key.hashCode() % SIZE]) {
                if (elem.key == key) {
                    return elem.value;
                }
            }
        }
        return null;
    }

    @Override
    public boolean containsValue(final Object value) {
        if (value != null) {
            for (List<Element<K, V>> bucket: storage) {
                if (bucket != null) {
                    for (Element<K, V> elem: bucket) {
                        if (elem.value == value) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsKey(final Object key) {
        if (key != null) {
            int index = key.hashCode() % SIZE;
            if (storage[index] != null) {
                for (Element<K, V> elem: storage[index]) {
                    if (elem.key == key) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        int size = 0;
        int counter = 0;
        for (List<Element<K, V>> bucket: storage) {
            if (bucket != null) {
                size += bucket.size();
            }
        }
        return size;
    }





    public static void main(String[] args) {

    }

}
