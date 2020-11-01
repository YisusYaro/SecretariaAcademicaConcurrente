import java.util.HashMap;

public class Profesor extends Persona{
    //atributos
    private String idTrabajador;
    
    //constructor
    public Profesor(String nombre, String apellidoPaterno, String apellidoMaterno, String email, String idTrabajador ){
        super(nombre, apellidoPaterno, apellidoMaterno, email);
        this.idTrabajador = idTrabajador;
    }
    //metodos
    //este metodo es la parte concurrente y donde hará el proceso de solicitar la materia del archivo
    public void run(){

    }
}
