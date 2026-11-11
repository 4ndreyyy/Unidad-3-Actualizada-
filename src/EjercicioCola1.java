/*  n personas forman un circulo,numerada de 1 a n
empezando a contar se elimina cada k-esima persona (k) y se sigue contando desde la siguiente
hay que devolver el orden de la eliminacion, el ultimo en eliminarse seria como el ganador
 */

public class EjercicioCola1 {
    static int n = 10;
    static int k = 3;

    static void circulo(Cola<Integer> cola) {
        System.out.println("Cola Normal");
        for (int i = 1; i <= n; i++) {
            cola.enqueue(i);
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("Orden de eliminación: ");

        while (!cola.isEmpty()) {
            for (int i = 1; i < k; i++) {
                int per = cola.dequeue();
                cola.enqueue(per);
            }

            int eli = cola.dequeue();
            if (cola.isEmpty()) {
                System.out.println();
                System.out.println("Ganador: " + eli);
            } else {
                System.out.print(eli + " ");
            }
        }
    }

    public static void main(String[] args) {
        Cola<Integer> cola = new ColaEstatica<>(n);
        circulo(cola);
    }
}
