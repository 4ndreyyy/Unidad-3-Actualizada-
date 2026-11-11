public class ColaEstatica <Integer> implements Cola<Integer> {
    private Integer a[];
    private int head=0, tail=0,n=0;

    public ColaEstatica(int cap){
        a= (Integer[]) new Object[cap];
    }


    @Override
    public void enqueue(Integer x) {
        if (n==a.length) throw new RuntimeException("Cola Llena"); //Overflow
        a[tail]=x;
        tail= (tail+1)%a.length;    //avanza circularmente
        n++;
    }

    @Override
    public Integer dequeue() {
        if (isEmpty()) throw new RuntimeException("Cola Vacia"); //Underflow
        Integer x = a[head];
        a[head]=null;
        head= (head+1)%a.length;
        n--;
        return x;
    }

    @Override
    public Integer peak() {
        if (isEmpty()) throw new RuntimeException("Cola Vacia"); //Underflow
        return a[head];
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public int size() {
        return n;
    }
}
