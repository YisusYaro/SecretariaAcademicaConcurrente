import java.util.HashMap;
import java.util.concurrent.*;

public class Alumno extends Persona{
    //atributos
    private String matricula;
    private Secretaria secretariaFCC;

    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, String email, String matricula, String[] nrcsDeseados){
        super(nombre, apellidoPaterno, apellidoMaterno, email, nrcsDeseados);
        this.matricula = matricula;
        this.secretariaFCC = null;
    }

    //metodos
    public void inscribirMaterias(String nrc, Materia materia){
        this.materias.put(nrc, materia);
    }

    public void run(){
        try{
            this.full.acquire();
            HashMap<String, Materia> materias = this.secretariaFCC.getMaterias();
            for(String nrcDeseado : this.nrcsDeseados){
                if(materias.get(nrcDeseado).inscribirMateria(this)){
                    System.out.println(this.nombre+"\tinscrito a: "+ nrcDeseado);
                }
            }
            this.empty.release();
        }catch(InterruptedException ie){
            System.out.println("Error al inscribir alumno, error : -> " + ie.getMessage());
        }
        
        
    }

}
