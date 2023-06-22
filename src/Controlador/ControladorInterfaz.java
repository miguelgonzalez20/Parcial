
package Controlador;

import Modelo.Alergias;
import Modelo.Pacientes;
import Vista.interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;

public class ControladorInterfaz {
    //Atributos
    private Map< String, ArrayList<String>> coleccionPacientes = new HashMap<>();
    private interfaz Vista;
    private Pacientes pacientes;
    private Alergias alergias;
    private ArrayList<String> listaAlergias = new ArrayList<>();
    private String cc;
    private JComboBox<String> comboBoxAlergias;
    //Constructor
    
    public ControladorInterfaz(Alergias Alergias, Pacientes Pacientes, interfaz vista ){
        
        this.Vista = vista;
        this.pacientes = Pacientes;
        this.alergias = Alergias;
        
        this.comboBoxAlergias = this.Vista.getComboBox();
        this.coleccionPacientes = pacientes.getColeccionPacientes();
        
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
                cc = Vista.getTxtCedula();
                
                List<String> listaAlergias = alergias.obtenerListaAlergias();
                for (String alergia : listaAlergias) {
                    comboBoxAlergias.addItem(alergia);
                }
                
                if(coleccionPacientes.get(cc) == null){
                    System.out.println("EL USUARIO NO EXISTE");
                    
                }
                else{
                    
                }
                    
                System.out.println("buscar");
                
            }
            if(e.getActionCommand().equalsIgnoreCase("Agregar")){

                String elementoSeleccionado = (String) comboBoxAlergias.getSelectedItem();
                
                Vista.setTextAreaAlergias(elementoSeleccionado);
                listaAlergias.add(elementoSeleccionado);
                System.out.println("Agregar");
            } 
            if(e.getActionCommand().equalsIgnoreCase("Agregar Usuario")){
                ArrayList<String> lista = new ArrayList<>();
                
                String apellidos = Vista.getTxtApellidos();
                String nombres = Vista.getTxtNombres();
                String telefono = Vista.getTxtTelefono();
                String direccion = Vista.getTxtDireccion();
                lista.add(apellidos);
                lista.add(nombres);
                lista.add(telefono);
                lista.add(direccion);
                lista.addAll(listaAlergias);
                Pacientes.AgregarMap(cc, lista);
                System.out.println(coleccionPacientes);
                       
                System.out.println("Agregar Usuario");
            } 
            if(e.getActionCommand().equalsIgnoreCase("Actualizar")){
                System.out.println("Actualizar");
            } 
        }  
    }
    
}
