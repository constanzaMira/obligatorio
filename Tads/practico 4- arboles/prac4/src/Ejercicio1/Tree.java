package Ejercicio1;

public class Tree <K extends Comparable<K>,T>implements MyTree<K,T>{

    private Node<K, T> root;

    public Tree(Node<K, T> root) {
        this.root = root;
    }

    public Node<K, T> getRoot() {
        return root;
    }

    public void setRoot(Node<K, T> root) {
        this.root = root;
    }

    private Node<K,T> findNode(K key, Node<K,T> root){
        Node<K,T> result= null;
        if (root.getKey()==key){
            return root;
        }
        if (root.getLeftChild()!= null){
           result= findNode(key, root.getLeftChild());
        }
        if (root.getRightChild()!= null){
           result= findNode(key, root.getRightChild());
        }
        return result;
    }

    @Override
    public T find(K key) {

        return findNode(key,this.root).getData();
    }

    @Override
    public void insert(K key, T data, K parentKey) {
        Node<K, T> node1 = new Node<K, T>(key, data);
        if (find(parentKey)!= null){
            if (findNode(parentKey,this.root).getRightChild()== null){

                findNode(parentKey,this.root).setRightChild(node1);
            } else if (findNode(parentKey,this.root).getLeftChild()== null) {
                findNode(parentKey,this.root).setLeftChild(node1);

            }
            else {
                System.out.println("no se puede crear hijo");// crear exepcion TODO
            }

        }

    }

    @Override
    public void delete(K key) {


    }
}
