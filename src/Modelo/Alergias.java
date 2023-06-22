
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Alergias {
    //Atributo
    private List<String> Lista_Alergias;
    
    //Constructor
    public Alergias() {
        Lista_Alergias = new ArrayList<>();
        Lista_Alergias.add("Latex");
        Lista_Alergias.add("Polen");
        Lista_Alergias.add("Acetaminofen");
        Lista_Alergias.add("Polvo");
        Lista_Alergias.add("Cebolla");
    }
    
    public List<String> obtenerListaAlergias() {
        return Lista_Alergias;
    }
}
