package hash;

public class HashNode<K extends Comparable<K>,V> {
    private K key;
    private V value;


    private boolean delete=  false;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.delete=false;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}
