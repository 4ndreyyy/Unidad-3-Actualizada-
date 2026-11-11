import java.util.NoSuchElementException;

public class ListaEnlazada<Item> {
    private class Nodo {
        Item item;
        Nodo siguiente;
    }

    private int n = 0;
    private Nodo primero, ultimo;

    public boolean isEmpty() {
        return primero == null;
    }

    public int size() {
        return n;
    }

    public void agregarInicio(Item x) {
        Nodo viejo = primero;
        primero = new Nodo();
        primero.item = x;
        primero.siguiente = viejo;

        if (ultimo == null) {
            ultimo = primero;
        }
        n++; // Corregido: se incrementa en todos los casos
    }

    public void agregarFinal(Item x) {
        Nodo viejo = ultimo;
        ultimo = new Nodo();
        ultimo.item = x;
        ultimo.siguiente = null;

        if (isEmpty()) {
            primero = ultimo;
        } else {
            viejo.siguiente = ultimo;
        }
        n++; // Incremento del contador al agregar al final
    }

    public boolean contiene(Item x) {
        for (Nodo p = primero; p != null; p = p.siguiente) {
            if (p.item.equals(x)) {
                return true;
            }
        }
        return false;
    }

    public Item eliminarInicio() {
        if (isEmpty()) throw new NoSuchElementException("La lista está vacía");

        Item x = primero.item;
        primero = primero.siguiente;
        n--;

        if (isEmpty()) {
            ultimo = null;
        }
        return x;
    }

    public Item eliminarFinal() {
        if (isEmpty()) throw new NoSuchElementException("La lista está vacía");

        Item x = ultimo.item;

        // Caso con un solo elemento en la lista
        if (primero == ultimo) {
            primero = null;
            ultimo = null;
        } else {
            // Recorrer la lista hasta encontrar el penúltimo nodo
            Nodo actual = primero;
            while (actual.siguiente != ultimo) {
                actual = actual.siguiente;
            }
            actual.siguiente = null;
            ultimo = actual;
        }

        n--;
        return x;
    }
}