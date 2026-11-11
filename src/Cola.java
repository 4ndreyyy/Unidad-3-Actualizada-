public interface Cola  <Integer>{

    void enqueue(Integer x); //Agrega x al final
    Integer dequeue();  // retira y devuelve el frente
    Integer peak(); //Consulta el frente sin retirarlo
    boolean isEmpty();  // vacia?
    int size(); //Numero de elementos

}
