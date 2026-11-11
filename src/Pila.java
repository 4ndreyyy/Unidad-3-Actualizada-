public interface Pila<Int> {

    void push (int x); // Apila el dato "x" en la cima
    int pop(); // Retirar el dato y devolver el que estaba en la cima
    int peak();    // Consulta el numero en la cima
    boolean isEmpty();  // Pregunta si esta vacio
    int size(); // Solo devuelve el numero de elementos

}
