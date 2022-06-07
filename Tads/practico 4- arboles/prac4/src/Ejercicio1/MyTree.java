package Ejercicio1;

public interface MyTree<K extends Comparable<K>, T> {
        T find(K key);
        void insert (K key, T data, K parentKey);
        void delete (K key);
    }

