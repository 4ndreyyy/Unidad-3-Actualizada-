public class ListasOrdenadas {
    static class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public static Nodo unirListas(Nodo lista1, Nodo lista2) {
        Nodo dummy = new Nodo(0);
        Nodo actual = dummy;

        while (lista1 != null && lista2 != null) {
            if (lista1.dato <= lista2.dato) {
                actual.siguiente = lista1;
                lista1 = lista1.siguiente;
            } else {
                actual.siguiente = lista2;
                lista2 = lista2.siguiente;
            }
            actual = actual.siguiente;
        }

        if (lista1 != null) {
            actual.siguiente = lista1;
        } else {
            actual.siguiente = lista2;
        }

        return dummy.siguiente;
    }

    public static void imprimir(Nodo lista) {
        Nodo actual = lista;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Nodo lista1 = new Nodo(1);
        lista1.siguiente = new Nodo(3);
        lista1.siguiente.siguiente = new Nodo(5);

        Nodo lista2 = new Nodo(2);
        lista2.siguiente = new Nodo(4);
        lista2.siguiente.siguiente = new Nodo(6);

        Nodo resultado = unirListas(lista1, lista2);

        System.out.print("Lista unida: ");
        imprimir(resultado);
    }}