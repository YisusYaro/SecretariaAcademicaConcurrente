import java.util.ArrayList;
/**
Proceso de inscripción primavera 2021: en ese caso se modelará cuando la 
Secretaría Académica solicita a los profesores inscribirse a las materias(archivo), 
inicialmente el archivo solo tiene materias y los profesores las solicitan, cuidando
que no se asigne la misma materia a dos profesores distintos, posteriormente la
Secretaría publica los horarios para que los alumnos se puedan inscribir, por lo que
los alumnos sólo podrán ver las materias hasta que los profesores tomen las mismas, 
considerar que un curso puede ser solicitado por muchos alumnos pero tiene una capacidad 
finita. Si el curso (nrc) ya no tiene capacidad tendrá opción de inscribirse en otro nrc. 
No es necesario modelar toda la población de profesores y estudiantil sólo con al menos 5 
profesores y 5 alumnos y el número de nrc que consideren.
 */
public class Test {
    public static void main(String[] args) {
        //Alumnos
        Alumno miAlumno1 = new Alumno("Jesus","Yahuitl","Rodriguez","jesus.yahuitl@alumno.buap.mx","201744550");
        Alumno miAlumno2 = new Alumno("Christiam","Parraguirre","Lagunes","christiam.parraguirre@alumno.buap.mx","201758915");
        Alumno miAlumno3 = new Alumno("David","Tlahuapa","Coraza","david.tlahuapa@alumno.buap.mx","201736875");
        Alumno miAlumno4 = new Alumno("Melquiades","Bustamante","Bonfil","melkia-bustamante@melkia.com","201748133");
        ArrayList<Alumno> alumnosFCC = new ArrayList<Alumno>();
        alumnosFCC.add(miAlumno1);
        alumnosFCC.add(miAlumno2);
        alumnosFCC.add(miAlumno3);
        alumnosFCC.add(miAlumno4);
        
        //Profesores
        Profesor miProfesor1 = new Profesor("Pedro","Garcia","Juarez","pedro.juarez@correo.buap.mx","200058915");
        Profesor miProfesor2 = new Profesor("Hilda","Castillo", "Zacatelco", "hildacz@gmail.com", "256122810");
        Profesor miProfesor3 = new Profesor("Enrique","Colmenares","Guillen","enrique.colmenares@correo.buap.mx","200067890");
        Profesor miProfesor4 = new Profesor("Miguel Angel","León","Sánchez", "no-sé@gmail.com", "12345");
        ArrayList<Profesor> profesoresFCC = new ArrayList<Profesor>();
        profesoresFCC.add(miProfesor1);
        profesoresFCC.add(miProfesor2);
        profesoresFCC.add(miProfesor3);
        profesoresFCC.add(miProfesor4);
        
        Secretaria secretariaAcademicaFCC = new Secretaria(alumnosFCC, profesoresFCC, Archivo.obtenerMaterias("inscripcion.txt"));


        /*
        for (Materia materia : Archivo.obtenerMaterias("inscripcion.txt").values()) {
            System.out.println(materia);
        }*/
    }
    
}
