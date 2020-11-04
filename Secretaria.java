import java.util.ArrayList;
import java.util.HashMap; 
import java.util.concurrent.*;

public class Secretaria{
    private ArrayList<Alumno> alumnos;
    private ArrayList<Profesor> profesores;
    private HashMap<String, Materia> materias;
    private Semaphore empty;
    private Semaphore full;
    public static int numeroProfesores;
    public static int contadorProfesores = 0;

    public Secretaria(ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores, HashMap<String, Materia> materias){
        this.alumnos = alumnos;
        this.profesores = profesores;
        this.materias = materias;
        numeroProfesores = profesores.size();
        this.empty = new Semaphore(numeroProfesores);
        this.full = new Semaphore(0);
    }

    public HashMap<String, Materia> getMaterias(){
        return this.materias;
    }

    public void proceso(){
        for(Profesor profesor : this.profesores){
            profesor.setSemaforos(this.empty, this.full);
            profesor.setSecretaria(this);
            profesor.start();
        }
        
        for(Alumno alumno : this.alumnos){
            alumno.setSemaforos(this.empty, this.full);
            alumno.setSecretaria(this);
            alumno.start();
        }
        

    }
    public ArrayList<Materia> getMateriasAlternativas(String materiaSolicitada){
        ArrayList<Materia> alternativas = new ArrayList<Materia>();
        for(Materia materia : this.materias.values()){
            if(materia.getNombre().equals(materiaSolicitada) && materia.getCapacidad()>0)
                alternativas.add(materia);
        }
        return alternativas;
    }
}