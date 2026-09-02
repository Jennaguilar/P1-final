public class Pila<T> {
private Nodo<T> cima;
    private int cantidad;

public Pila() {
        this.cima = null;
        this.cantidad = 0;
    }

    public boolean estaVacia() {
        return this.cima == null;
    }
//APILAR (Push)
    public void apilar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguiente(this.cima); // El nuevo apunta al que antes estaba arriba
        this.cima = nuevoNodo;             // Ahora la cima es el nuevo
        this.cantidad++;
    }

    //DESAPILAR (Pop)
    public T desapilar() {
        if (estaVacia()) return null;
        
        T datoRecuperado = this.cima.getDato(); // Guardamos el dato antes de sacarlo
        this.cima = this.cima.getSiguiente();   // La nueva cima es el que estaba abajo
        this.cantidad--;
        return datoRecuperado;
    }

    //VER CIMA (Peek)
    public T verCima() {
        if (estaVacia()) return null;
        return this.cima.getDato();
    }
}