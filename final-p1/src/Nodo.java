public class Nodo<T> { // <T> indica que es una clase genérica que puede almacenar cualquier tipo de dato
    private T dato; // cualquier tipo de dato que se quiera almacenar en el nodo
    private Nodo<T> siguiente;

    //Constructor de nodo
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    //Gett y Sett 
    public T getDato() {
        return dato;
    }
    public void setDato(T dato) {
        this.dato = dato;
    }
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

}
