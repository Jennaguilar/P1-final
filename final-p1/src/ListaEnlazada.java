public class ListaEnlazada<T> {
private Nodo<T> cabeza; //primer nodo de la lista
private int cantidad; // cantidad de nodos en la lista

//Constructor: lista vacia
public ListaEnlazada() {
    this.cabeza = null;
    this.cantidad = 0;
}

public boolean estaVacia(){
    return this.cabeza == null; // si la cabeza no apunta a nada esta vacia == significa que no hay nodos en la lista
}

public int obtenerCantidad(){
    return this.cantidad;
}

// ---------- METODOS DE MODIFICACIONES ----------

//AGREGAR
public void agregar(T dato){
    Nodo<T> nuevoNodo = new Nodo<>(dato); // se crea un nuevo nodo con el dato que se quiere agregar
    // preguntamos si la lista esta vacia
    if (estaVacia()){
        this.cabeza = nuevoNodo; // si esta vacia, el nuevo nodo se convierte en la cabeza de la lista
    } else {
        Nodo<T> actual = this.cabeza; // si hay nodos en la lista, se recorre desde el principio
        while (actual.getSiguiente() != null){ // mientras el siguiente nodo no sea nulo, se sigue recorriendo
            actual = actual.getSiguiente(); // se mueve al siguiente nodo
        }
        actual.setSiguiente(nuevoNodo); // se agrega el nuevo nodo al final de la lista
    }
    this.cantidad++; // se incrementa la cantidad de nodos en la lista
}

// OBTENER
public T obtener(int posicion) {
    //Vslidacion de la posicion
    if (posicion < 0 || posicion >= this.cantidad) { // si la posicion es menor a 0 o mayor o igual a la cantidad de nodos, es invalida
            return null; // se retorna null para indicar que la posicion es invalida
    }
    // Recorre el inicio de la lista hasta la posicion deseada
    Nodo<T> actual = this.cabeza;
    for (int i = 0; i < posicion; i++) {
        actual = actual.getSiguiente();
    }
    return actual.getDato();
}

// ELIMINAR
public boolean eliminar(T datoParaEliminar){
    if (estaVacia()) {
            return false;
        }
        //si el libro a eliminar es el primer nodo
    if (this.cabeza.getDato().equals(datoParaEliminar)) {
            // La cabeza nueva pasa a ser el siguiente nodo
            this.cabeza = this.cabeza.getSiguiente();
            this.cantidad--; // Restamos 1 al contador
            return true; // Éxito
        }
    // caso contrario, recorremos la lista para encontrar el nodo a eliminar
    Nodo<T> actual = this.cabeza;
    while (actual.getSiguiente() != null) { //si el sig nodo es nulo, significa que llegamos al final de la lista y no encontramos el nodo a eliminar
        if (actual.getSiguiente().getDato().equals(datoParaEliminar)) { // si el siguiente nodo contiene el dato a eliminar
            actual.setSiguiente(actual.getSiguiente().getSiguiente()); // se salta el nodo a eliminar
            this.cantidad--; // se decrementa la cantidad de nodos en la lista
            return true; // se retorna true para indicar que se elimino correctamente
        }
        actual = actual.getSiguiente(); // se mueve al siguiente nodo
    }
    return false; // si no se encontro el nodo a eliminar, se retorna false
}
}
