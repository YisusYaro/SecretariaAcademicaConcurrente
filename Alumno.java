
public class Alumno extends Persona{
    //atributos
    private String matricula;

    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, String email, String matricula){
        super(nombre, apellidoPaterno, apellidoMaterno, email);
        this.matricula = matricula;
    }

    //metodos
    public void inscribirMaterias(String nrc, Materia materia){
        this.materias.put(nrc, materia);
    }

    //este metodo es la parte concurrente y donde hará el proceso de solicitar la materia del archivo
    public void run(){

    }

}
