import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.io.IOException;

public class Archivo{
    
    public static HashMap<String, Materia> obtenerMaterias(String nombreArchivo){
        BufferedReader reader;
        // Tabla hash que contiene las materias ofertadas. La clave para guardar una materia es el nrc.
        HashMap<String, Materia> materias = new HashMap<String, Materia>();
        String linea = null;    
        String atributos [];
        String nrc;
        
        try{
                    reader = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = reader.readLine()) != null) {
                atributos = linea.split(",");
                nrc = atributos[1];
                materias.put(nrc, new Materia(nrc, atributos[0],Integer.parseInt(atributos[2]), atributos[3]));
            }
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
        return materias;
	}
}