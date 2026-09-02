public class Libro {
    //atributos privados (encapsulamiento)
    private String titulo;
    private String isbn;
    private String autor;
    private int anioPublicacion;
    private boolean Disponible;
    private int vecesPrestado;


    // constructor
    public Libro(String titulo, String isbn, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.Disponible = true; 
        this.vecesPrestado = 0; 
    }


    // getters y setters
    // para lerr datos de los atributos
    public String getTitulo() {
         return titulo; 
         }
    public String getIsbn() {
         return isbn; 
         }
    public String getAutor() {
         return autor; 
         }
    public int getAnioPublicacion() {
         return anioPublicacion; 
         }
    public boolean isDisponible() {
         return Disponible; 
         }
    public int getVecesPrestado() {
         return vecesPrestado; 
         }

    // para modificar datos de los atributos de forma segura
    public void setTitulo(String titulo) {
         this.titulo = titulo; 
         }
    public void setIsbn(String isbn) {
         this.isbn = isbn; 
         }
    public void setAutor(String autor) {
         this.autor = autor; 
         }
    public void setAnioPublicacion(int anioPublicacion) {
         this.anioPublicacion = anioPublicacion; 
         }


         //Prestar Libro 
         public boolean prestarLibro() {
          // verificar si el libro esta disponible
          if (this.Disponible == true) {
               this.Disponible = false; 
               this.vecesPrestado = this.vecesPrestado + 1;
               return true;
          } else {
               return false; // libro no disponible
          }
          }

          // Devolver libro
          public void devolverLibro(){
               this.Disponible = true; // vuelve a estar disponible
          }
}
