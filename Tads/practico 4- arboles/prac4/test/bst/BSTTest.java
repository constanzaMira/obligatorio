package bst;

import Ejercicio6.BST;
import Ejercicio6.MyBST;
import Exceptions.ArbolVacio;
import Exceptions.NoExisteKey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BSTTest {
    @Test
    public void testAdd() {
        MyBST<Integer, Integer> bst = new BST<>();
        bst.insertar(2,3);
        bst.insertar(4,5);
        bst.insertar(6,7);
        bst.insertar(9,10);
        bst.insertar(50,8);
        bst.insertar(75,79);
        try {
            Assertions.assertEquals(3,bst.find(2));
        } catch (ArbolVacio e) {
            throw new RuntimeException(e);
        } catch (NoExisteKey e) {
            throw new RuntimeException(e);
        }
        try {
            Assertions.assertEquals(79,bst.find(75));
        } catch (ArbolVacio e) {
            throw new RuntimeException(e);
        } catch (NoExisteKey e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void testBuscar(){
        MyBST<Integer, Integer> bst = new BST<>();
        bst.insertar(2,3);
        bst.insertar(4,5);
        bst.insertar(6,7);
        try {
            Assertions.assertEquals(3,bst.find(2));
        } catch (ArbolVacio e) {

        } catch (NoExisteKey e) {

        }
        try {
            Assertions.assertEquals(7,bst.find(6));
        } catch (ArbolVacio e) {

        } catch (NoExisteKey e) {

        }

    }

    @Test
    void testBorrar(){
        MyBST<Integer, Integer> bst = new BST<>();
        bst.insertar(2,3);
        bst.insertar(4,5);
        bst.insertar(6,7);
        bst.insertar(9,10);
        bst.insertar(50,8);
        bst.insertar(75,79);

        try {
            bst.borrar(9);
        } catch (NoExisteKey e) {

        }
        try {
            bst.borrar(2);
        } catch (NoExisteKey e) {

        }
        try {
            bst.borrar(75);
        } catch (NoExisteKey e) {

        }

        try {
            Assertions.assertEquals(false,bst.find(75));
        } catch (ArbolVacio e) {

        } catch (NoExisteKey e) {

        }


    }

    @Test
    void testSize(){
        MyBST<Integer, Integer> bst = new BST<>();
        bst.insertar(2,3);
        bst.insertar(4,5);
        bst.insertar(6,7);
        bst.insertar(9,10);
        bst.insertar(50,8);
        bst.insertar(75,79);

        Assertions.assertEquals(6,bst.size());

        try {
            bst.borrar(4);
        } catch (NoExisteKey e) {
        }

        Assertions.assertEquals(5,bst.size());



    }
}