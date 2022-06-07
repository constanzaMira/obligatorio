package Ejercicio6;

import Exceptions.ArbolVacio;
import Exceptions.NoExisteKey;

public class mainBST {
    public static void main(String[] args) {
        BST miprueba = new BST();
        miprueba.insertar(2,3);
        miprueba.insertar(3,2);
        miprueba.insertar(7,8);
        miprueba.insertar(10,4);
        miprueba.insertar(1,80);
        miprueba.inOrder();
        try {
            System.out.println(miprueba.find(2));
        } catch (ArbolVacio e) {
            throw new RuntimeException(e);
        } catch (NoExisteKey e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(miprueba.find(10));
        } catch (ArbolVacio e) {
            throw new RuntimeException(e);
        } catch (NoExisteKey e) {
            throw new RuntimeException(e);
        }
        try {
            miprueba.borrar(3);
        } catch (NoExisteKey e) {
            throw new RuntimeException(e);
        }
        try {
            miprueba.borrar(10);
        } catch (NoExisteKey e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(miprueba.find(3));
        } catch (ArbolVacio e) {
            System.out.println("ok");
        } catch (NoExisteKey e) {
            System.out.println("ok");
        }
        //miprueba.inOrder();
        try {
            System.out.println(miprueba.find(10));
        } catch (ArbolVacio e) {
            System.out.println("ok1");
        } catch (NoExisteKey e) {
            System.out.println("ok1");
        }
        miprueba.inOrder();
        System.out.println(miprueba.size());
        miprueba.preOrder();



    }


}
