import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ModeloVenta;
import modelo.Vendedor;
import modelo.VendedorDAO;
import modelo.VentaDAO;
import vista.VentanaReportes;
import vista.ventRegistrar;

/**
 *
 * @author chelo
 */
public class LoginController implements ActionListener{
    
    
    private ventRegistrar vLogin;

    public LoginController(ventRegistrar vLogin) {
        this.vLogin = vLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("ingresar")){
            String nomb= vLogin.nombreComb.getName();
         

            Vendedor newVend= new Vendedor(nomb);
            
            VendedorDAO c = new VendedorDAO(); // Creo el objeto para acceder a la BD

            ArrayList<Vendedor> listaDeCred= c.getVendedor(); // Creo lista y llamo al metodo getCredenciales del DAO
            
             boolean flag=false;
            for(int i=0; i<listaDeCred.size();i++){ // Recorro los resultados
                
//                if(listaDeCred.get(i).getNombre().equals(newVend.getNombre())){ //Match en usuario
//                    System.out.println("Usuario encontrado");
//                    
//                    if(listaDeCred.get(i).getApellido().equals(newVend.getApellido())){ //Match en pass
//                        System.out.println("Password correcto");
//                        VentanaReportes vInfo = new VentanaReportes();
//                        
//                        VentaDAO ventadao= new VentaDAO();
//                        ModeloVenta venta = ventadao.getVentaByID(listaDeCred.get(i).getIdVendedor());
//                        
//                        vInfo.sucursalCombo.setText(venta.getNombre());
//                        vInfo.apellidoLabelValue.setText(cuenta.getApellido());
//                        vInfo.correoLabelValue.setText(cuenta.getEmail());
//                        
//                        vInfo.setVisible(true);
//                        JOptionPane.showMessageDialog(vInfo, "Login Exitoso");
//                        vLogin.dispose();
//                        flag=true; 
//                    }
//                }
            }
            
            if(!flag){
                JOptionPane.showMessageDialog(vLogin, "USer o Pass incorrectos");
            }
        }
        
    }
    
    
    
    
    
    
}