public class PilaEstatica implements Pila<Integer>{

    private Integer[] a;
    private Integer n=0;

    public PilaEstatica(int capacidad) {
        this.a=new Integer[capacidad];
    }

    @Override
    public void push(int x) {
        if (this.n==a.length) throw new RuntimeException("Overflow: La pila esta llena");
        this.a[this.n++]=x;
    }


    @Override
    public int pop() {
        if (isEmpty()) throw new RuntimeException("Pila vacia");
        Integer x = this.a[--this.n];
        this.a[n] = null;
        return x;
    }


    @Override
    public int peak() {
        if (isEmpty()) throw new RuntimeException("Underflow: Pila vacia");
        return this.a[n-1];
    }


    @Override
    public boolean isEmpty() {
        return this.n==0;
    }


    @Override
    public int size() {
        return n;
    }
}
