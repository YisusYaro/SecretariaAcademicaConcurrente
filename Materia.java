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

    public String getNrc(){
        return this.nrc;
    }

    public String toString(){
        return "Materia: " + this.nombreMateria + " NRC: " + this.nrc + " Capacidad: " + this.capacidadAlumnos + " Horario: " + this.horario + "Asignada: " + asignada + "Profesor: " + this.profesor.getNombre();
    }

    public boolean inscribirMateria(Profesor profesor){
        try{
            mutex.acquire();
            //System.out.println(profesor.getNombre() + " " + this.nombreMateria);
            //sección crítica  
            if(!this.asignada){
                this.asignada = true;
                this.profesor = profesor;

                mutex.release();
            }
            else{
                mutex.release();
                return false;
            }
            
           
        }catch(InterruptedException ie){
            System.out.println("Error al inscribir profesor"+ie.getMessage());
        }
        return this.asignada;
    }

    public boolean inscribirMateria(Alumno alumno){
        boolean status = false;
        try{
            mutex.acquire();
            //sección crítica
            if(this.asignada){
                if(this.capacidadAlumnos>0){
                    this.capacidadAlumnos--;
                    this.alumnos.add(alumno);
                    status = true;
                }
            }
            else{
                System.out.println("no fue asignada: " + this.nombreMateria);
            }
            mutex.release();
        }catch(InterruptedException ie){
            System.out.println("Error al inscribir alumno " + ie.getMessage());
        }
        return status;
    }
    public String getNombre(){
        return this.nombreMateria;
    }
    public int getCapacidad(){
        return this.capacidadAlumnos;
    }   
}
