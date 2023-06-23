
package Controlador;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import Modelo.Alergias;
import Modelo.Pacientes;
import Vista.interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
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
                
                
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("pacientes.txt"));
                    String line;

                    while ((line = reader.readLine()) != null) {
                        ArrayList<String> listAux = new ArrayList<>();
                        String[] parts = line.split("=");
                        if (parts.length >= 2) {
                            String key = parts[0];
                            ArrayList<String> values = new ArrayList<>();

                            for (int i = 1; i < parts.length; i++) {
                                values.add(parts[i]);
                            }
                            
                            String cadena = values.get(0);
                            String[] palabras = cadena.split(", ");

                            ArrayList<String> palabrasIndividuales = new ArrayList<>(Arrays.asList(palabras));

                            for (String palabra : palabrasIndividuales) {
                                listAux.add(palabra);
                            }
                            
                            coleccionPacientes.put(key, listAux);
                        }
                    }
                    
                    reader.close();
                } catch (IOException x) {
                    x.printStackTrace();
                }

                

                
                cc = Vista.getTxtCedula();
                List<String> listaAlergias = alergias.obtenerListaAlergias();
                for (String alergia : listaAlergias) {
                    comboBoxAlergias.addItem(alergia);
                }
                if(coleccionPacientes.get(cc) == null){
                    System.out.println("EL USUARIO NO EXISTE");
                }
                else{
                    System.out.println("EL USUARIO SI EXISTE");
                    List<String> lista = new ArrayList<>();
                    lista = coleccionPacientes.get(cc);
                    Vista.setTxtApellidos(lista.get(0));
                    Vista.setTxtNombres(lista.get(1));
                    Vista.setTxtTelefono(lista.get(2));
                    Vista.setTxtDireccion(lista.get(3));   
                }     
            }
            if(e.getActionCommand().equalsIgnoreCase("Agregar")){

                String elementoSeleccionado = (String) comboBoxAlergias.getSelectedItem();
                
                Vista.setTextAreaAlergias(elementoSeleccionado);
                listaAlergias.add(elementoSeleccionado);
            } 
            if(e.getActionCommand().equalsIgnoreCase("Actualizar")){
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
                Vista.setBlank(); 
                comboBoxAlergias.removeAllItems();
                
                System.out.println("Agregar Usuario");
            } 
            if(e.getActionCommand().equalsIgnoreCase("Salir")){
                System.out.println("SALIR");
                try {
                    PrintWriter writer = new PrintWriter(new FileWriter("pacientes.txt"));

                    for (Map.Entry<String, ArrayList<String>> entry : coleccionPacientes.entrySet()) {
                        writer.println(entry.getKey() + "=" + entry.getValue());
                    }

                    writer.close(); 
                } catch (IOException A) {
                    A.printStackTrace();
                }
                Vista.dispose();
            } 
        }  
    }
    
}
