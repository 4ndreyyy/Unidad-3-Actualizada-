public class MainColas {

    static void demo(Cola<Integer> c){
        for (int i=1; i<=5; i++){
            c.enqueue(i);
        }
        while (!c.isEmpty()){
            System.out.print(c.dequeue()+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        demo(new ColaEstatica<>(10));
        demo(new ColaDinamica<>());
    }
}
