/*En una plataforma de procesamiento de datos recibes una secuencia de valores almacenados
en una lista simplemente enlazada por un error del sistema algunos valores aparecen repetidos
consecutivamente, debes eliminar las repeticiones, dejandoo unicamente una aparicion de cada valor
consecutivo
 */

import java.util.NoSuchElementException;

public class Ejercicio <Item> {
    private class Nodo {
        Item item;
        Nodo siguiente;
    }

    private int n = 0;
    private Nodo primero, ultimo;

    public boolean isEmpty(){
        return primero ==null;
    }
    public int size(){ return n;}

    public void agregarInicio(Item x) {
        Nodo nuevo = new Nodo();
        nuevo.item = x;
        nuevo.siguiente = primero;
        primero = nuevo;

        if (ultimo == null) {
            ultimo = primero;
        }
        n++;
    }

    public void agregarFinal(Item x) {
        Nodo nuevo = new Nodo();
        nuevo.item = x;
        nuevo.siguiente = null;

        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        n++;
    }

    public void mostrarLista() {
        Nodo aux = primero;
        while (aux != null) {
            System.out.print(aux.item + ",");
            aux = aux.siguiente;
        }
    }

    public void eliminar() {
        if (isEmpty()) throw new NoSuchElementException("Lista Vacia");
        Nodo aux = primero;

        while (aux != null && aux.siguiente != null) {
            if (aux.item.equals(aux.siguiente.item)) {
                aux.siguiente = aux.siguiente.siguiente;
                n--;

                if (aux.siguiente == null) {
                    ultimo = aux;
                }
            } else {
                aux = aux.siguiente;
            }
        }
    }


    public static void main(String[] args) {
        Ejercicio<Integer> lista = new Ejercicio<>();


        lista.agregarInicio(1);
        lista.agregarFinal(2);
        lista.agregarFinal(2);
        lista.agregarFinal(3);
        lista.agregarFinal(4);
        lista.agregarFinal(5);
        lista.agregarFinal(5);
        lista.agregarFinal(6);
        lista.agregarFinal(7);
        lista.agregarFinal(7);
        lista.agregarFinal(9);

        lista.mostrarLista();
        lista.eliminar();
        System.out.println("");
        System.out.println("Lista Actualizada");
        lista.mostrarLista();
    }
}
