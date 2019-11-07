import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.List;


public class MyHashMap<K, V> implements Map<K, V> {

    class Element<K, V> {
        K key;
        V value;
    }


    private List<Element<K, V>>[] storage = new List[32];

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public Set<V> values() {
        Set<V> set = new HashSet<V>();
        try {
            for (List<Element<K, V>> list: storage) {
                for (Element<K, V> element: list) {
                    set.add(element.value);
                }
            }
            return set;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        try {
            for (List<Element<K, V>> list: storage) {
                for (Element<K, V> element: list) {
                    set.add(element.key);
                }
            }
            return set;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public void clear() {
        storage = new List[32];
    }

    @Override
    public void putAll(final Map<? extends K,? extends V> map) {}

    @Override
    public V remove(Object key) {
        try {
            for (List<Element<K, V>> list: storage) {
                for (Element<K, V> element: list) {
                    if (element.key == key) {
                        list.remove(element);
                        return element.value;
                    }
                }
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public V put(final K key, final V value) {
        List<Element<K, V>> list = storage[key.hashCode() >> 27];

        //Element element = new Element(key, value);
        //list.add(element);

        //list.add(new Element<K, V>());

        return value;
    }

    @Override
    public V get(final Object key) {
        try {
            for (List<Element<K, V>> list: storage) {
                for (Element<K, V> element: list) {
                    if (element.key == key) {
                        return element.value;
                    }
                }
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public boolean containsValue(final Object value) {
        try {
            for (List<Element<K, V>> list: storage) {
                for (Element<K, V> element: list) {
                    if (element.value == value) {
                        return true;
                    }
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public boolean containsKey(final Object key) {
        try {
            for (List<Element<K, V>> list: storage) {
                for (Element<K, V> element: list) {
                    if (element.key == key) {
                        return true;
                    }
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        int size = 0;
        try {
            for (List<Element<K, V>> list: storage) {
                size += list.size();
            }
        } catch (NullPointerException e) {
            return 0;
        }
        return size;
    }


    public static void main(final String[] args) {
        MyHashMap<Integer, Integer> mp = new MyHashMap<Integer, Integer>();
        System.out.println(mp.put(1,1));
        System.out.println(mp.size());

    }

}
