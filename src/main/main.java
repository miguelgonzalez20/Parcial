
package main;

import Controlador.ControladorInterfaz;
import Modelo.Alergias;
import Modelo.Pacientes;
import Vista.interfaz;

public class main{

    public static void main(String[] args) {
        interfaz vista = new interfaz();
        Alergias alergias = new Alergias();
        Pacientes pacientes = new Pacientes();
        ControladorInterfaz controlador = new ControladorInterfaz(alergias, pacientes, vista);
    }
    
}
