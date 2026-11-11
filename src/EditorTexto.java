public class EditorTexto implements Pila<Integer> {

    private Integer arr[];
    private Integer n=0;

    public EditorTexto(int tam){
    this.arr=new Integer [tam];
    }


    @Override
    public void push(int x) {
        if (this.n==arr.length) throw new RuntimeException("Pila Llena");
        this.arr[this.n++]=x;
    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peak() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return n;
    }
}
