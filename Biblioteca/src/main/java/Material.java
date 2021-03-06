import java.time.LocalDate;

//Interfaz de material
public interface Material {

    //Obtener obtener la fecha de devolucion
    public LocalDate obtenerFechaDevolucion();
    //Mostrar la informacion de mejor manera que el toSring
    public void mostrarInfoChula();
}
