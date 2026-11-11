public class PilaDinamica implements Pila<Integer>{
    private class Nodo{
        Integer dato;
        Nodo sig;
    }
    private Nodo cima=null;
    private int n=0;


    @Override
    public void push(int x) {
    Nodo viejo= cima;
    this.cima=new Nodo();
    this.cima.dato=x;
    this.cima.sig= viejo;
    this.n++;
    }

    @Override
    public int pop() {
        if (isEmpty()) throw new RuntimeException("Underflow: Pila Vacia");
        Integer x= this.cima.dato;
        this.cima= this.cima.sig;
        this.n--;
        return x;
    }

    @Override
    public int peak() {
        if (isEmpty()) throw new RuntimeException("Underflow: Pila vacia");
        return this.cima.dato;
    }

    @Override
    public boolean isEmpty() {
        return this.cima==null;
    }

    @Override
    public int size() {
        return this.n;
    }
}
