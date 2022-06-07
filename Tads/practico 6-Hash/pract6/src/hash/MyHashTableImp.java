package hash;

import exceptions.NoExiste;
import hash.HashNode;
import hash.HashTable;

public class MyHashTableImp<K extends Comparable<K>,V> implements HashTable<K,V> {

    private final static int SIZE_INICIAL=10;// declaracion de cte
    private final static int FACTOR_CRECIMIENTO=2;
    int cant_elementos=0;

    private HashNode<K, V>[] elements;


    public MyHashTableImp(){
        elements= new HashNode[SIZE_INICIAL];
    }

    private int colison(int prueba){
        return prueba;
    }

    public  HashNode<K,V> [] redimensionarArreglo (HashNode <K,V>[] arreglo){
        HashNode<K, V>[] elementsDup;
        elementsDup=new HashNode[elements.length*FACTOR_CRECIMIENTO];
        System.arraycopy(arreglo,0,elementsDup,0,arreglo.length);
        return elementsDup;
    }


    @Override
    public void put(K key, V value) {
            //aplicar funcion de hash a la key para determinar posicion
        int position= Math.abs(key.hashCode())% elements.length;   //lo que me devuelve el hash code aplico el modulo del tamano de tabla
                                                    //llama a la funcion hashcode del objeto que yo pase como primer argumento(k.hashcode)
        float division= (float)cant_elementos/elements.length;
        if(division>= 0.8f){
            elements=redimensionarArreglo(elements);
        }
        // verifico si la poscion esta libre para colocar elemento
        if (elements[position]==null || elements[position].isDelete() ||  elements[position].getKey().equals(key) ){
            HashNode<K,V> node=new HashNode<>(key, value);
            elements[position]= node;
            cant_elementos++;
        }else{
            int nroColision=1;
            int nuevaPosicion= 0;

            do {
                nuevaPosicion= (key.hashCode() + colison(nroColision)) % elements.length;
                nroColision ++;

            } while(this.elements[nuevaPosicion]!= null && !elements[nuevaPosicion].isDelete()
                    && nuevaPosicion < elements.length);
            if (nroColision< elements.length) {
                HashNode<K, V> node = new HashNode<>(key, value);
                elements[nuevaPosicion] = node; //antes de chekear esto fijarse que factor de carga este por debajo de el freshcod que voy a definir, aumentar tamanio y dsp operar
                cant_elementos++;
            }
            }
        }


    public V get(K key){
        int position= Math.abs(key.hashCode())% elements.length;
        V exit= null;

        if(this.elements[position]!=null){//estoy accediendo a una posicion de una clave que tiene algo
            if(!this.elements[position].isDelete() && this.elements[position].getKey().equals(key)){//encontre valor
                exit= this.elements[position].getValue();
            }else {//elemento borrado pudo haber habido una colision
                int nroColision=1;
                int nuevaPosicion= 0;

                do {
                    nuevaPosicion= (key.hashCode() + colison(nroColision)) % elements.length;
                    nroColision ++;

                } while(elements[nuevaPosicion]!= null && this.elements[position].getKey().equals(key)
                        && nroColision < elements.length);
                if(nroColision< elements.length){
                    if(elements[nuevaPosicion]!= null && this.elements[nuevaPosicion].isDelete() ){
                        exit= this.elements[nuevaPosicion].getValue();
                    }
                }
            }

        }


        return exit;
    }

    @Override
    public boolean contains(K key) {
        if(get(key)!=null){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public void remove(K key) throws NoExiste {
        int position= Math.abs(key.hashCode())% elements.length;
        //V exit= null;
        if(this.elements[position]!=null){//estoy accediendo a una posicion de una clave que tiene algo
            if(!this.elements[position].isDelete() && this.elements[position].getKey().equals(key)){//encontre valor
                this.elements[position].setDelete(true);
            }else {//elemento borrado pudo haber habido una colision
                int nroColision=1;
                int nuevaPosicion= 0;

                do {
                    nuevaPosicion= (key.hashCode() + colison(nroColision)) % elements.length;
                    nroColision ++;

                } while(elements[nuevaPosicion]!= null && this.elements[position].getKey().equals(key)
                        && nroColision < elements.length);

                if(nroColision< elements.length){
                    if(elements[nuevaPosicion]!= null && this.elements[nuevaPosicion].isDelete() ){
                        throw new NoExiste();
                    }
                }
            }

        }

    }

    @Override
    public int size() {
        return cant_elementos;
    }
}
