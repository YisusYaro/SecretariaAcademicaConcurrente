import java.util.HashMap;

public class Alumno extends Persona{
    //atributos
    private String matricula;

    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, String email, String matricula, String[] nrcsDeseados){
        super(nombre, apellidoPaterno, apellidoMaterno, email, nrcsDeseados);
        this.matricula = matricula;
    }

    //metodos
    public void inscribirMaterias(String nrc, Materia materia){
        this.materias.put(nrc, materia);
    }

    public void run(){
        try{
            String materiaDeseada= "";
            this.full.acquire();
            HashMap<String, Materia> materias = this.secretariaFCC.getMaterias();
            for(String nrcDeseado : this.nrcsDeseados){
                if(materias.get(nrcDeseado).inscribirMateria(this)){
                    System.out.println("El alumno " + this.nombre + " inscrito a: "+ nrcDeseado);
                }
                else{
                    materiaDeseada = materias.get(nrcDeseado).getNombre();
                    if(this.secretariaFCC.getMateriasAlternativas(materiaDeseada).size() > 0)
                        for(Materia materiaAlternativa : this.secretariaFCC.getMateriasAlternativas(materiaDeseada)){
                            if(materias.get(materiaAlternativa.getNrc()).inscribirMateria(this)){
                                System.out.println("El alumno " + this.nombre + " inscrito alternativamente a: "+ materiaAlternativa.getNrc());
                                break;
                            }
                        }
                    else{
                        System.out.println("El alumno " +this.nombre + " no tiene alternativas para: " + nrcDeseado);
                    }

                }

            }
            this.empty.release();
        }catch(InterruptedException ie){
            System.out.println("Error al inscribir alumno, error : -> " + ie.getMessage());
        }
        
        
    }

}
