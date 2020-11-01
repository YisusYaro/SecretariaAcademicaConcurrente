import java.util.ArrayList;
import java.util.HashMap; 

public class Secretaria{
    private ArrayList<Alumno> alumnos;
    private ArrayList<Profesor> profesores;
    private HashMap<String, Materia> materias;

    public Secretaria(ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores, HashMap<String, Materia> materias){
        this.alumnos = alumnos;
        this.profesores = profesores;
        this.materias = materias;
    }

    
}