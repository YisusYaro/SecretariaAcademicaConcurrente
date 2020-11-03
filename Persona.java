import java.util.HashMap;
import java.util.concurrent.*;

public class Persona extends Thread {
    protected String nombre;
    protected String apellidoParteno;
    protected String apellidoMaterno;
    protected String email;
    protected HashMap<String, Materia> materias = new HashMap<String, Materia>();
    protected String nrcsDeseados[];
    protected Secretaria secretariaFCC;
    protected Semaphore empty;
    protected Semaphore full;

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String email, String[] nrcsDeseados){
        this.nombre = nombre;
        this.apellidoParteno = apellidoPaterno;
        this.apellidoMaterno= apellidoMaterno;
        this.email = email;
        this.nrcsDeseados = nrcsDeseados;
        this.empty = null;
        this.full = null;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellidoPaterno(){
        return this.apellidoParteno;
    }

    public String getApellidoMaterno(){
        return this.apellidoMaterno;
    }

   public String getEmail(){
        return this.email;
    }

    public void setSecretaria(Secretaria secretariaFCC){
        this.secretariaFCC = secretariaFCC;
    }

    public void setSemaforos(Semaphore empty, Semaphore full){
        this.empty = empty;
        this.full = full;
    }

    // Método que devuelve el nombre completo de la persona
    public String toString(){
        return this.nombre + " " + this.apellidoParteno + " " + this.apellidoMaterno;
    }

}
