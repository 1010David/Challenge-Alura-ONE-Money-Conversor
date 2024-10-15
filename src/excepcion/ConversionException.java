package src.excepcion;  // Declara el paquete donde se encuentra la clase ConversionException

// Clase ConversionException que extiende la clase Exception
public class ConversionException extends Exception {

    // Constructor de la clase ConversionException que recibe un mensaje de error
    public ConversionException(String message) {
        super(message);  // Llama al constructor de la clase padre (Exception) con el mensaje proporcionado
    }
}
