import java.util.ArrayList;
import java.util.concurrent.*;
public class Materia{
    //atributos
    private String nrc;
    private String nombreMateria;
    private int capacidadAlumnos;
    private String horario;
    private boolean asignada;
    private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    private Profesor profesor;
    // Semaforo
    private Semaphore mutex;
    //constructor
    public Materia(String nrc, String nombreMateria, int capacidadAlumnos, String horario){
        this.nrc = nrc;
        this.nombreMateria = nombreMateria;
        this.capacidadAlumnos=capacidadAlumnos;
        this.horario = horario;
        this.asignada = false;
        this.mutex = new Semaphore(1);
    }
    //metodos
    public String toString(){
        return "Materia: " + this.nombreMateria + " NRC: " + this.nrc + " Capacidad: " + Integer.toString(this.capacidadAlumnos) + " Horario: " + this.horario;
    }

    public void inscribirMateria(){
       /* mutex.acquire();
        // sección crítica
        mutex.release();*/
    }
    
}
