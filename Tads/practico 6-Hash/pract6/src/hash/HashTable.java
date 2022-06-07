package hash;

import exceptions.NoExiste;

public interface HashTable<K, V>{
    public void put(K key, V value);
    public boolean contains(K key);
    public void remove(K key) throws NoExiste;

    public V get(K key);

    int size();

}
