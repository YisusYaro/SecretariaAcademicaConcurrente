import java.util.HashMap;
import java.util.concurrent.*;

public class Profesor extends Persona{
    //atributos
    private String idTrabajador;

    
    //constructor
    public Profesor(String nombre, String apellidoPaterno, String apellidoMaterno, String email, String idTrabajador, String[] nrcsDeseados){
        super(nombre, apellidoPaterno, apellidoMaterno, email, nrcsDeseados);
        this.idTrabajador = idTrabajador;
    }
    
    //metodos
    //este metodo es la parte concurrente y donde hará el proceso de solicitar la materia del archivo
    
    public void run(){

        try{
            this.empty.acquire();
            HashMap<String, Materia> materias = this.secretariaFCC.getMaterias();
            for(String nrcDeseado : this.nrcsDeseados){
                if(materias.get(nrcDeseado).inscribirMateria(this)){
                    System.out.println(this.nombre+"\tinscrito a: "+ nrcDeseado);
                }
            }
            this.full.release();
        }catch(InterruptedException ie){
            System.out.println("Error con profesor, escoger materia ->" + ie.getMessage());
        }

        
    }


}
 