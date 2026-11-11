
import java.util.ArrayList;
import java.util.List;
public class DemoPilas {

    static void demo(Pila<Integer> p){
        for (int i=1; i<=5; i++){
            p.push(i);
        }
        while (!p.isEmpty()){
            System.out.printf(p.pop()+" ");
        }
    }

        private static int charAInt(char c) {
            switch (c) {
                case '(': case ')': return 1;
                case '[': case ']': return 2;
                case '{': case '}': return 3;
                default: return 0;
            }
        }

        private static char intToCharApertura(int id) {
            switch (id) {
                case 1: return '(';
                case 2: return '[';
                case 3: return '{';
                default: return ' ';
            }
        }

        private static char obtenerCierre(int id) {
            switch (id) {
                case 1: return ')';
                case 2: return ']';
                case 3: return '}';
                default: return ' ';
            }
        }

        private static char obtenerApertura(char c) {
            switch (c) {
                case ')': return '(';
                case ']': return '[';
                case '}': return '{';
                default: return ' ';
            }
        }

        public static void analizarYBalancear(String s, Pila p) {
            List<String> errores = new ArrayList<>();
            List<String> sugerencias = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(' || c == '[' || c == '{') {
                    p.push(charAInt(c));
                }

                else if (c == ')' || c == ']' || c == '}') {
                    if (p.isEmpty()) {
                        errores.add("Carácter '" + c + "' en posición " + i + " no tiene apertura.");
                        sugerencias.add("Eliminar '" + c + "' en pos " + i + " O agregar '" + obtenerApertura(c) + "' antes.");
                    } else {
                        int tipoUltimoAbierto = p.pop();
                        int tipoActual = charAInt(c);

                        if (tipoUltimoAbierto != tipoActual) {
                            char esperado = obtenerCierre(tipoUltimoAbierto);
                            errores.add("Conflicto en pos " + i + ": se esperaba '" + esperado + "' pero se encontró '" + c + "'.");
                            sugerencias.add("Cambiar '" + c + "' por '" + esperado + "'.");
                        }
                    }
                }
            }

            while (!p.isEmpty()) {
                int tipoSobrante = p.pop();
                char simbolo = intToCharApertura(tipoSobrante);
                char cierreCorrespondiente = obtenerCierre(tipoSobrante);

                errores.add("Símbolo de apertura '" + simbolo + "' quedó sin cerrar.");
                sugerencias.add("Agregar '" + cierreCorrespondiente + "' al final O eliminar '" + simbolo + "'.");
            }

            System.out.println("Cadena analizada: " + s);
            if (errores.isEmpty()) {
                System.out.println("-> La cadena está perfectamente BALANCEADA.");
            } else {
                System.out.println("-> La cadena NO está balanceada:");
                for (int i = 0; i < errores.size(); i++) {
                    System.out.println("   [Error] " + errores.get(i));
                    System.out.println("   [Sugerencia] " + sugerencias.get(i));
                }
            }
        }


            public static void main(String[] args) {
                analizarYBalancear("{{}", new PilaDinamica());
                analizarYBalancear("{[(])}", new PilaDinamica());
                analizarYBalancear(")(", new PilaEstatica(10));
                analizarYBalancear("{[()]}", new PilaDinamica());
        }
    }
