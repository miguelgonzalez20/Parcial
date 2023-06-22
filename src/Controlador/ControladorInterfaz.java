
package Controlador;

import Modelo.Alergias;
import Modelo.Pacientes;
import Vista.interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorInterfaz {
    //Atributos
    private interfaz Vista;
    private Pacientes Pacientes;
    private Alergias Alergias;
    //Constructor
    
    public ControladorInterfaz(Alergias alergias, Pacientes pacientes, interfaz vista ){
        this.Vista = vista;
        this.Pacientes = pacientes;
        this.Alergias = alergias;
        
        this.Vista.addbtnBuscarListener(new CalculateListener());
        this.Vista.addbtnAgregarAlergiasListener(new CalculateListener());
        this.Vista.addbtnAgregarUsuarioListener(new CalculateListener());
        this.Vista.addbtnActualizarUsuarioListener(new CalculateListener());
        
        Vista.setVisible(true);
        Vista.setLocationRelativeTo(null);
        
    }
    
    class CalculateListener implements ActionListener{
         
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equalsIgnoreCase("Buscar")){
                System.out.println("buscar");
                
            }
            if(e.getActionCommand().equalsIgnoreCase("Agregar")){
                System.out.println("Agregar");
            } 
            if(e.getActionCommand().equalsIgnoreCase("Agregar Usuario")){
                System.out.println("Agregar Usuario");
            } 
            if(e.getActionCommand().equalsIgnoreCase("Actualizar")){
                System.out.println("Actualizar");
            } 
        }  
    }
    
}
