public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== BIBLIOTECA ===\n");
        // Se crea una biblioteca con nombre
        Biblioteca miBiblioteca = new Biblioteca("Biblioteca Argentina");
        System.out.println("=== INICIANDO SISTEMA DE: " + miBiblioteca.getNombre() + " ===\n");

        Libro libro1 = new Libro("Harry Potter y la Piedra Filosofal", "111", "J.K. Rowling", 1997);
        Libro libro2 = new Libro("El Señor de los Anillos", "222", "J.R.R. Tolkien", 1954);
        Libro libro3 = new Libro("Cien Años de Soledad", "333", "Gabriel García Márquez", 1967);

        //Agrega a los libros en la Lista Enlazada
        miBiblioteca.agregarLibro(libro1);
        miBiblioteca.agregarLibro(libro2);
        miBiblioteca.agregarLibro(libro3);
        System.out.println("3 libros agregados al catálogo de la biblioteca.\n");

    
        //BUSQUEDA por ISBN
        System.out.println("BUSQUEDA:");
        Libro busqueda = miBiblioteca.buscarPorIsbn("222");
        if (busqueda != null) {
            System.out.println("Libro encontrado: " + busqueda.getTitulo() + " (Autor: " + busqueda.getAutor() + ")\n");
        }

    // ---PRÉSTAMOS Y PILA (DESHACER) ---
        System.out.println("PRUEBA DE PRÉSTAMOS E HISTORIAL (PILA):");
        // mostrar 111 de Harry Potter a Juan
        miBiblioteca.prestarLibroAUsuario("111", "Juan");
        // error, Juan quería otro libro. Deshacemos usando Pila.
        miBiblioteca.deshacerUltimoPrestamo();
        // Ahora sí, se lo prestamos a quien correspondía: María
        miBiblioteca.prestarLibroAUsuario("111", "María");
        System.out.println();


        // ---COLA DE ESPERA ---
        System.out.println("PRUEBA DE LISTA DE ESPERA (COLA):");
        // Harry Potter (111) ya lo tiene María. Si Pedro lo pide, debería ir a la fila.
        miBiblioteca.prestarLibroAUsuario("111", "Pedro");
        // Si Lucía lo pide, debería ir detrás de Pedro en la fila.
        miBiblioteca.prestarLibroAUsuario("111", "Lucía");
        System.out.println();


        // --- DEVOLUCIÓN Y ASIGNACIÓN AUTOMÁTICA ---
        System.out.println("PRUEBA DE DEVOLUCIÓN:");
        // María terminó de leer Harry Potter y lo devuelve.
        // El sistema debería dárselo automáticamente a Pedro que era el primero en la Cola.
        miBiblioteca.devolverLibro("111");
        
        System.out.println("\n=== FIN DE LA PRUEBA DEL SISTEMA ===");
    }
    
    }

    

