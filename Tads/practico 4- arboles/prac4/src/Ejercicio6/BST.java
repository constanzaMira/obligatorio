package Ejercicio6;

import Exceptions.ArbolVacio;
import Exceptions.NoExisteKey;

public class BST<K extends Comparable<K>,T> implements MyBST<K,T> {
    private NodeBST<K,T> root;

    public NodeBST<K, T> getRoot() {
        return root;
    }

    public void setRoot(NodeBST<K, T> root) {
        this.root = root;
    }

    private NodeBST<K,T> insert (K key, T data, NodeBST<K,T> root){
        NodeBST result= null;
        NodeBST<K,T> newNode= new NodeBST<>(key,data);
        if (root==null){
            return newNode;
        } else if (key.compareTo(root.getKey()) > 0) {
            root.setRightChild(insert(key, data,root.getRightChild()));
            result= root;
        } else if (key.compareTo(root.getKey())<0) {// si la key< a la root.getkey
            root.setLeftChild(insert(key, data, root.getLeftChild()));//getLeftChild()
            result=root;
        }
        return result;
    }

    private NodeBST<K,T> delete (K key,NodeBST<K,T> root) {
        if (this.root == null) {
            //nada para hacer retorna lo mismo
        } if (key.compareTo(root.getKey()) < 0) {//si la key< a la root.getkey
          root.setLeftChild(delete(key, root).getLeftChild());
        } else if (key.compareTo(root.getKey()) > 0) {
            root.setRightChild(delete(key, root.getRightChild()));
        }else{
            if(root.getLeftChild()==null){
                return root.getRightChild();
            } else if (root.getRightChild()==null) {
                return root.getLeftChild();
            }root.key=getMin(root.getRightChild());
            root.setRightChild(delete(root.getKey(), root.getRightChild()));
        }return root;
    }
   private K getMin(NodeBST<K,T> root){
       K result=root.getKey();
       while(root.getLeftChild()!=null){
           result=root.getLeftChild().getKey();
           root=root.getLeftChild();
       }return result;
    }

    private NodeBST<K,T> findNode(K key, NodeBST<K,T> root) throws NoExisteKey {
        NodeBST<K,T> result= root;
        if(root==null){
            throw new NoExisteKey();

        } else if (root.getKey()==key) {// si lo que busco esta en el nodo principal
            return root;
        } else if (key.compareTo(root.getKey())<0) {// si lo que busco< nodo principal
            return findNode(key,root.getLeftChild());
        } else if (key.compareTo(root.getKey())>0) {
            return findNode(key,root.getRightChild());
        }
        return result;

    }

    private int tamanio(NodeBST<K,T> root){
        if(root==null){
            return 0;
        }
        else{
            return(tamanio(root.getLeftChild()) + 1 + tamanio(root.getRightChild()));
        }
    }

    @Override
    public T find(K key) throws ArbolVacio, NoExisteKey  {
        if (findNode(key,this.root)==null){
            throw new ArbolVacio();
        }
       else{
            return findNode(key,this.root).getData();
        }
    }

    @Override
    public void insertar(K key, T data) {
        root= insert(key,data,this.root);

    }

    @Override
    public void borrar(K key)  throws NoExisteKey{
        if (root==null){
            throw new NoExisteKey();
        }else{
            delete(key,this.root);        
        }

    }

    @Override
    public int size() {
        return tamanio(root);
    }

    private void inOrder_(NodeBST<K, T> root) {

        if (root != null) {

            inOrder_(root.getLeftChild());

            System.out.println(root.key);

            inOrder_(root.getRightChild());
        }
    }

    private void preOrder_(NodeBST<K,T> root){

            if (root != null) {

                System.out.println(root.key);

                preOrder_(root.getLeftChild());

                preOrder_(root.getRightChild());
            }
    }
    public void inOrder() {
        inOrder_(this.root);
    }
    public void preOrder() {
        preOrder_(this.root);
    }
}
