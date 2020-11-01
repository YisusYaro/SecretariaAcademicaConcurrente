import java.util.HashMap;

public class Persona extends Thread {
    protected String nombre;
    protected String apellidoParteno;
    protected String apellidoMaterno;
    protected String email;
    protected HashMap<String, Materia> materias = new HashMap<String, Materia>();

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String email){
        this.nombre = nombre;
        this.apellidoParteno = apellidoPaterno;
        this.apellidoMaterno= apellidoMaterno;
        this.email = email;
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
    // Método que devuelve el nombre completo de la persona
    public String toString(){
        return this.nombre + " " + this.apellidoParteno + " " + this.apellidoMaterno;
    }

    
}
