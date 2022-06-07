package HashTableTests;
import exceptions.NoExiste;
import hash.HashTable;
import hash.MyHashTableImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HTT {
    @Test
    void testPut(){
        HashTable<Integer,Integer> hash = new MyHashTableImp<>();
        hash.put(3,4);
        hash.put(5,6);
        hash.put(9,8);
        Assertions.assertEquals(8,hash.get(9));
        Assertions.assertEquals(false, hash.contains(7));
        // como hago para usar la funcion get pra comparar la key con el value
    }
    @Test
    void testContains(){
        HashTable<Integer,Integer> hash = new MyHashTableImp<>();
        hash.put(3,4);
        hash.put(5,6);
        hash.put(9,8);
        hash.put(30,26);
        Assertions.assertEquals(true,hash.contains(30));
        Assertions.assertEquals(false,hash.contains(7));
    }

    @Test
    void testSize(){
        HashTable<Integer,Integer> hash = new MyHashTableImp<>();
        hash.put(3,4);
        hash.put(5,6);
        hash.put(9,8);
        hash.put(30,26);
        hash.put(6,14);
        hash.put(90,65);
        hash.put(34,7);
        hash.put(22,1);
        Assertions.assertEquals(8,hash.size());
    }

    @Test
    void testRemove(){
        HashTable<Integer,Integer> hash = new MyHashTableImp<>();
        hash.put(3,4);
        hash.put(5,6);
        hash.put(9,8);
        hash.put(30,26);

        try {
            hash.remove(9);
        } catch (NoExiste e) {
        }
        try {
            hash.remove(30);
        } catch (NoExiste e) {
        }
        Assertions.assertEquals(false,hash.contains(30));
        Assertions.assertEquals(false,hash.contains(9));
    }
}
