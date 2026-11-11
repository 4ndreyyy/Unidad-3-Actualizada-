/*Desarrollar un programa e utilizando listas dobles, gestione las tareas de un proyecto,
el programa debe permitir al usuario 3 puntos
1= Agregar nuevas tareas
2= Cambiar estado de las tareas (En ejecucion, en espera, finalizado)
3=Mostrar informacion sobre las tareas (Nombre, estado y prioridad)*/


import javax.swing.*;

public class Tarea <Item> {

    private class Tar {
        Item item;
        Tar prev;
        Tar next;
        boolean finalizado =false;
    }

    private Tar cabeza, cola;
    private int n = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void agregarTareaInicio(Item x) {
        Tar nuevo = new Tar();
        nuevo.item = x;
        nuevo.next = cabeza;
        nuevo.prev = null;

        if (isEmpty()) {
            cola = nuevo;
        } else {
            cabeza.prev = nuevo;
        }
        cabeza = nuevo;
        n++;
    }

    public void agregarTareaFinal(Item x) {
        Tar nuevo = new Tar();
        nuevo.item = x;
        nuevo.prev = cola;
        nuevo.next = null;

        if (isEmpty()) {
            cabeza = nuevo;
        } else {
            cola.next = nuevo;
        }
        cola = nuevo;
        n++;
    }

    public Item eliminarTareaInicio(){
    if (isEmpty()) throw new RuntimeException("Lista Vacia");
    Item x = cabeza.item;
    cabeza = cabeza.next;

    if (cabeza==null){
        cola=null;
    }else{
        cabeza.prev=null;
    }
    n--;
    return x;
    }

    public boolean finalizarTarea(Item objetivo){
        Tar aux = cabeza;
        while(aux!=null && !aux.item.equals(objetivo)){
        aux=aux.next;
        }
        if (aux == null) return false;
        aux.finalizado= true;
        return true;
    }

    public Item eliminarFinalTarea(){
    if (isEmpty()) throw new RuntimeException("Lista vacia");
    Item x = cola.item;
    cola = cola.prev;

    if (cola==null){
        cabeza=null;
    }else{

        cola.next=null;
    }
    n--;
    return x;
    }

    public void mostrarTareas() {
        Tar aux = cabeza;
        while (aux != null) {
            String estado;
            if (aux.finalizado) {
                estado = "Finalizado";
            } else if (aux == cabeza) {
                estado = "En ejecucion";
            } else {
                estado = "En espera";
            }

            System.out.println("Tarea: " + aux.item + " | Estado: " + estado);
            aux = aux.next;
        }
    }

    public boolean agregarTareaDespues(Item objetivo, Item x) {
        Tarea.Tar aux = cabeza;
        while (aux != null && !aux.item.equals(objetivo)) {
            aux = aux.next;
        }
        if (aux == null) return false;
        Tarea.Tar nuevo = new Tarea.Tar();
        nuevo.item = x;
        nuevo.prev=aux;
        nuevo.next= aux.next;
        if (aux.next==null){
            cola =nuevo;
        }else{
            aux.next.prev=nuevo;
        }
        aux.next = nuevo;
        n++;
        return true;
    }


    public static void main(String[] args) {
        Tarea<String> lista = new Tarea();
        int continuar;
        do {
            String tarea = JOptionPane.showInputDialog(null, "Ingresa el nombre de la tarea:");

            if (tarea != null && !tarea.trim().isEmpty()) {
                tarea = tarea.toLowerCase();

                Object[] opciones = {"Al inicio", "Al final", "Después de otra tarea"};
                int seleccion = JOptionPane.showOptionDialog(
                        null,
                        "¿Dónde deseas agregar la tarea '" + tarea + "'?",
                        "Posición de la tarea",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]
                );

                switch (seleccion) {
                    case 0:
                        lista.agregarTareaInicio(tarea);
                        break;

                    case 1:
                        lista.agregarTareaFinal(tarea);
                        break;

                    case 2:
                        if (lista.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "La lista está vacía. Se agregará al inicio por defecto.");
                            lista.agregarTareaInicio(tarea);
                        } else {
                            String objetivo = JOptionPane.showInputDialog(null, "¿Después de qué tarea existente deseas agregarla?");
                            if (objetivo != null && !objetivo.trim().isEmpty()) {
                                objetivo = objetivo.toLowerCase();
                                boolean agregado = lista.agregarTareaDespues(objetivo, tarea);

                                if (!agregado) {
                                    JOptionPane.showMessageDialog(null, "No se encontró la tarea objetivo. Se agregará al final por defecto.");
                                    lista.agregarTareaFinal(tarea);
                                }
                            } else {
                                lista.agregarTareaFinal(tarea);
                            }
                        }
                        break;

                    default:
                        break;
                }
            }

            continuar = JOptionPane.showConfirmDialog(
                    null,
                    "¿Deseas agregar otra tarea?",
                    "Continuar",
                    JOptionPane.YES_NO_OPTION
            );

        } while (continuar == JOptionPane.YES_OPTION);

        lista.agregarTareaDespues("Barrer","limpiar");
        lista.agregarTareaDespues("Barrer","cambiar");
        lista.agregarTareaDespues("Barrer","acomodar");
        lista.agregarTareaFinal("Trapear");
        lista.finalizarTarea("limpiar");
        lista.mostrarTareas();

        System.out.println("");
        System.out.println("lista actualizada");
        lista.eliminarFinalTarea();
        lista.eliminarTareaInicio();
        lista.mostrarTareas();
    }
}