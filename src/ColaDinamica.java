public class ColaDinamica<Integer> implements Cola<Integer> {
    private class Nodo{Integer dato;Nodo sig;}
    private int n=0;
    private Nodo head,tail;


    @Override
    public void enqueue(Integer x) {
        Nodo viejo = tail;
        tail= new Nodo();
        tail.dato=x;
        tail.sig=null;
        if (isEmpty()){
            head=tail;
        }else{
            viejo.sig=tail;
        }
        n++;
    }

    @Override
    public Integer dequeue() {
        if (isEmpty()) throw new RuntimeException("Cola Vacia");
        Integer x = head.dato;
        head = head.sig;
        if (isEmpty()) {
            tail = null;
        }
        n--;
        return x;
    }

    @Override
    public Integer peak() {
        if (isEmpty()) throw new RuntimeException("Cola Vacia");
        return head.dato;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public int size() {
        return n;
    }
}
