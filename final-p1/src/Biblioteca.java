public class Biblioteca {
    private String nombre;                      // Nombre de la biblio
    private ListaEnlazada<Libro> libros;       // El catálogo principal
    private Pila<Libro> historialPrestamos;   // Pila de libros prestados
    private Cola<String> filaDeEspera;       // Cola de gente esperando un libro prestafdo
 


    // constructor 
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ListaEnlazada<>(); 
        this.historialPrestamos = new Pila<>();;
        this.filaDeEspera = new Cola<>();;
    }

// metodo publico
    public String getNombre() {
        return nombre;
    }


    //METODO AGREGAR: un libro al catálogo
    public void agregarLibro(Libro libro) {
        if (libro != null) {
            this.libros.agregar(libro);
        }
    }

    //METODO PRESTAR: buscar un libro
    public Libro buscarPorIsbn(String isbn) {
        // Recorre la lista
        for (int i = 0; i < this.libros.obtenerCantidad(); i++) {
            // Saca el libro en la posición 'i' usando obtener()
            Libro libroActual = this.libros.obtener(i);
            // Si el ISBN coincide, devuelve el libro inmediatamente
            if (libroActual.getIsbn().equals(isbn)) {
                return libroActual;
            }
        }
        // Si terminamos de buscar y no está, devuelve null
        return null;
    }

    
    //METODO BUSQUEDA Titulo
    public ListaEnlazada<Libro> buscarPorTitulo(String tituloBuscado) {
        ListaEnlazada<Libro> resultados = new ListaEnlazada<>(); // Inicializa lista de resultadso
        //recorre
        for (int i = 0; i < this.libros.obtenerCantidad(); i++) {
            Libro libroActual = this.libros.obtener(i);
            //.toLowerCase() para que la búsqueda ignore mayúsculas y minúsculas
            //.contains() para ver si el título del libro contiene lo que el usuario escribió
            if (libroActual.getTitulo().toLowerCase().contains(tituloBuscado.toLowerCase())) {
                resultados.agregar(libroActual); // Lo agregamos a la lista de resultados
            }
        }
        return resultados;
    }


        // BUSCAR libros que contengan parte del nombre del autor
    public ListaEnlazada<Libro> buscarPorAutor(String autorBuscado) {
        ListaEnlazada<Libro> resultados = new ListaEnlazada<>();
        for (int i = 0; i < this.libros.obtenerCantidad(); i++) {
            Libro libroActual = this.libros.obtener(i);
            
            if (libroActual.getAutor().toLowerCase().contains(autorBuscado.toLowerCase())) {
                resultados.agregar(libroActual);
            }
        }
        return resultados;
    }


    //  --------------------------------------------------------
    // |                    Pila y Cola                         |
    //  --------------------------------------------------------

    // Método para PRESTAR un libro a un usuario
    public boolean prestarLibroAUsuario(String isbn, String nombreUsuario) {
        Libro libro = buscarPorIsbn(isbn);
        if (libro == null) {
            System.out.println("El libro no existe.");
            return false;
        }
        if (libro.isDisponible()) {
            // 1. Prestamos el libro (cambia estado y suma contador)
            libro.prestarLibro();
            
            // 2. Guardamos la operación en la Pila del historial (Tarea 2)
            this.historialPrestamos.apilar(libro);
            
            System.out.println("Libro prestado a " + nombreUsuario + " con éxito.");
            return true;
        } else {
            // 3. Si no está disponible, el usuario va a la Cola de espera (Tarea 3)
            this.filaDeEspera.encolar(nombreUsuario);
            System.out.println("Libro no disponible. " + nombreUsuario + " añadido a la lista de espera.");
            return false;
        }
    }

    // Método para deshacer el último préstamo usando la Pila (Tarea 2)
    public void deshacerUltimoPrestamo() {
        if (!this.historialPrestamos.estaVacia()) {
            Libro ultimoPrestado = this.historialPrestamos.desapilar();
            ultimoPrestado.devolverLibro(); // Vuelve a estar disponible
            // Nota: Aquí se podría ajustar el contador de préstamos si se desea ser muy estricto
            System.out.println("Préstamo deshecho para el libro: " + ultimoPrestado.getTitulo());
        } else {
            System.out.println("No hay préstamos recientes para deshacer.");
        }
    }

    // Método para devolver un libro y atender la Cola de espera (Tarea 3)
    public void devolverLibro(String isbn) {
        Libro libro = buscarPorIsbn(isbn);
        
        if (libro != null && !libro.isDisponible()) {
            // 1. Devolvemos el libro
            libro.devolverLibro();
            System.out.println("Libro '" + libro.getTitulo() + "' devuelto a la biblioteca.");

            // 2. Revisamos si hay alguien en la fila esperando por un libro
            if (!this.filaDeEspera.estaVacia()) {
                String proximoUsuario = this.filaDeEspera.desencolar();
                
                // Le prestamos el libro automáticamente al siguiente en la fila
                libro.prestarLibro();
                this.historialPrestamos.apilar(libro); // Lo anotamos en el historial
                System.out.println("El libro fue asignado inmediatamente a " + proximoUsuario + " (estaba en espera).");
            }
        }
    }
    }
