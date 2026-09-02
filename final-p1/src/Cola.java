public class Cola<T> {
private Nodo<T> frente; // El primero de la fila (el próximo a ser atendido)
    private Nodo<T> finalCola; // El último de la fila (el recién llegado)
    private int cantidad;

    public Cola() {
        this.frente = null;
        this.finalCola = null;
        this.cantidad = 0;
    }

    public boolean estaVacia() {
        return this.frente == null;
    }

    //ENCOLAR (Enqueue)
    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        
        if (estaVacia()) {
            this.frente = nuevoNodo;     // Si está vacía, es el primero y el último
            this.finalCola = nuevoNodo;
        } else {
            this.finalCola.setSiguiente(nuevoNodo); // El que estaba último apunta al nuevo
            this.finalCola = nuevoNodo;             // Ahora el final es el nuevo
        }
        this.cantidad++;
    }

    //DESENCOLAR (Dequeue)
    public T desencolar() {
        if (estaVacia()) return null;
        
        T datoRecuperado = this.frente.getDato(); // Guardamos el dato del primero
        this.frente = this.frente.getSiguiente(); // Ahora el frente es el que estaba segundo
        
        if (this.frente == null) {
            this.finalCola = null; // Si se fue el único que había, el final también es nulo
        }
        
        this.cantidad--;
        return datoRecuperado;
    }


    //VER FRENTE (Peek)
    public T verPrimero() {
        if (estaVacia()) return null;
        return this.frente.getDato();
    }
}
