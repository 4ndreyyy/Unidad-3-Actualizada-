public class ListaDoble<Item> {

    private class Nodo{ Item item ; Nodo prev; Nodo next;}
    private Nodo cabeza, cola;
    private int n=0;

    public boolean isEmpty() {
        return n==0;
    }

    public int size(){
        return n;
    }

    public void agregarInicio(Item x) {
        Nodo nuevo= new Nodo();
        nuevo.item=x;
        nuevo.next= cabeza;
        nuevo.prev=null;

        if (isEmpty()) {
            cola=nuevo;
        }else {
            cabeza.prev=nuevo;
        }
        cabeza= nuevo;
        n++;
    }

    public void agregarFinal(Item x) {
        Nodo nuevo = new Nodo();
        nuevo.item=x;
        nuevo.prev= cola;
        nuevo.next=null;

        if(isEmpty()){
            cabeza=nuevo;
        }else{
            cola.next= nuevo;
        }
        cola = nuevo;
        n++;
    }

    public Item eliminarInicio(){
        if (isEmpty()) throw new RuntimeException("Lista vacia");
            Item x = cabeza.item;
            cabeza= cabeza.next;

            if (cabeza==null){
                cola=null;
            }else{
                cabeza.prev=null;
            }
            n--;
            return x;
    }

    public Item eliminarFinal(){
        if (isEmpty()) throw new RuntimeException("Lista Vacia");
        Item x = cola.item;
        cola = cola.prev;

        if (cola==null){
            cabeza=null;
        }else{
            cola.next=null;
        }
        n--;
        return x;
    }
    public void muestraInicio(){
        Nodo aux = cabeza;
        while(aux!= null){
            System.out.println(aux.item);
            aux=aux.next;
        }
    }

    public void muestraFinal(){
        Nodo aux = cola;
        while(aux!= null){
            System.out.println(aux.item);
            aux=aux.prev;
        }
    }

    public boolean insertarDespues(Item objetivo, Item x){
      Nodo aux = cabeza;
      while (aux!=null && !aux.item.equals(objetivo)){
          aux = aux.next;
      }
      if (aux==null) return false;
      Nodo nuevo = new Nodo();
      nuevo.item=x;
      nuevo.prev=aux;
      nuevo.next= aux.next;
      if (aux.next==null){
          cola =nuevo;
      }else{
          aux.next.prev=nuevo;
      }
      aux.next = nuevo;
      n++;
      return true;
    }

    public Item eliminarEn(int posicion) {

        if (posicion < 0 || posicion >= n) {
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }

        if (posicion == 0) {
            return eliminarInicio();
        }

        if (posicion == n - 1) {
            return eliminarFinal();
        }

            Nodo aux = cabeza;
        for (int i = 0; i < posicion; i++) {
            aux = aux.next;
        }

        Item nodoEliminado = aux.item;
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;

        n--;
        return nodoEliminado;
    }

        public static void main(String[] args) {
            ListaDoble<String> lista = new ListaDoble<>();

            System.out.println("AGREGAR AL INICIO Y AL FINAL");
            lista.agregarInicio("B");
            lista.agregarInicio("A");
            lista.agregarFinal("C");
            lista.agregarFinal("D");

            System.out.println("Lista desde el inicio: ");
            lista.muestraInicio();

            System.out.println("Lista desde el final:");
            lista.muestraFinal();
            System.out.println("INSERTAR DESPUÉS ");
            boolean insertado = lista.insertarDespues("B", "X");

            System.out.println("¿Se insertó X después de B? " + insertado);
            System.out.println("Lista actualizada: ");
            lista.muestraInicio();

            System.out.println("ELIMINAR EN POSICIÓN ");
            String eliminadoEn2 = lista.eliminarEn(2);
            System.out.println("Elemento eliminado en el índice 2: " + eliminadoEn2);
            System.out.println("Lista actualizada:");
            lista.muestraInicio();

            System.out.println("ELIMINAR INICIO Y FINAL");
            String eliminadoInicio = lista.eliminarInicio();
            System.out.println("Elemento eliminado al inicio: " + eliminadoInicio);

            String eliminadoFinal = lista.eliminarFinal();
            System.out.println("Elemento eliminado al final: " + eliminadoFinal);

            System.out.println("Lista final:");
            lista.muestraInicio();

        }
    }

