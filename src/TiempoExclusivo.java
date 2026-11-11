public class TiempoExclusivo {

    private static class Nodo {
        int id;
        Nodo siguiente;

        Nodo(int id) {
            this.id = id;
            this.siguiente = null;
        }
    }

    public static class Pila {
        private Nodo tope;

        public Pila() {
            this.tope = null;
        }

        public void push(int id) {
            Nodo nuevoNodo = new Nodo(id);
            nuevoNodo.siguiente = tope;
            tope = nuevoNodo;
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("La pila está vacía");
            }
            int valor = tope.id;
            tope = tope.siguiente;
            return valor;
        }

        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("La pila está vacía");
            }
            return tope.id;
        }

        public boolean isEmpty() {
            return tope == null;
        }
    }

    public int[] tiempoExclusivo(int n, String[] logs) {
        int[] resultado = new int[n];
        Pila pila = new Pila();
        int prevTime = 0;

        for (String log : logs) {
            String[] partes = log.split(":");
            int id = Integer.parseInt(partes[0]);
            String tipo = partes[1];
            int time = Integer.parseInt(partes[2]);

            if (tipo.equals("start")) {
                if (!pila.isEmpty()) {
                    resultado[pila.peek()] += time - prevTime;
                }
                pila.push(id);
                prevTime = time;
            } else {
                resultado[pila.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        return resultado;
    }
    public static void main(String[] args) {
       TiempoExclusivo solucion = new TiempoExclusivo();

        // Caso 1
        int[] r1 = solucion.tiempoExclusivo(1, new String[]{"0:start:0", "0:end:2"});
        System.out.println(java.util.Arrays.toString(r1)); // [3]

        // Caso 2
        int[] r2 = solucion.tiempoExclusivo(2, new String[]{"0:start:0", "1:start:2", "1:end:5", "0:end:6"});
        System.out.println(java.util.Arrays.toString(r2)); // [3, 4]

        // Caso 3
        int[] r3 = solucion.tiempoExclusivo(2, new String[]{"0:start:0", "1:start:1", "1:end:1", "0:end:2"});
        System.out.println(java.util.Arrays.toString(r3)); // [2, 1]
    }
}
