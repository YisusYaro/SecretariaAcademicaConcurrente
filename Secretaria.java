import java.util.ArrayList;
import java.util.HashMap; 
import java.util.concurrent.*;

public class Secretaria{
    private ArrayList<Alumno> alumnos;
    private ArrayList<Profesor> profesores;
    private HashMap<String, Materia> materias;
    private Semaphore empty;
    private Semaphore full;
    private final int size = 4;

    public Secretaria(ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores, HashMap<String, Materia> materias){
        this.alumnos = alumnos;
        this.profesores = profesores;
        this.materias = materias;
        this.empty = new Semaphore(this.size);
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
}