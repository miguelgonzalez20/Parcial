
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pacientes {
    //Atributos
   
    private static Map< String, ArrayList<String>> coleccionPacientes = new HashMap<>();
    //Constructor
    public Pacientes(){ 
    }
    //metodos
 
    public Map<String, ArrayList<String>> getColeccionPacientes() {
        return coleccionPacientes;
    }
    
    public static void AgregarMap(String clave, ArrayList<String> valor){
        coleccionPacientes.put(clave,valor);
    }
    
    public ArrayList<String> getValor(){
        ArrayList<String> lista = new ArrayList<>();
        return lista;
    
    }

   
    
    
            
            
    
    

    
    
    
    
 
}
