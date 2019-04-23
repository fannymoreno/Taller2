
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JComboBox;
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
    private VendedorDAO vDAO;
    private javax.swing.JComboBox<String> vendedor;
    private javax.swing.JComboBox<String> sucursal;
    ArrayList<ModeloVenta> venta;
     ArrayList<Vendedor> vendedores;
     
     
    public LoginController(ventRegistrar vLogin,javax.swing.JComboBox<String> vendedor, javax.swing.JComboBox<String> sucursal) {
        
         
        this.vLogin = vLogin;
        this.vendedor = vendedor;
       
        
       // vDAO = new VendedorDAO();
       vendedores = vDAO.getVendedor();
        
        String v1=vendedores.get(0).getNombre()+" "+vendedores.get(0).getApellido();
        String v2=vendedores.get(1).getNombre()+" "+vendedores.get(1).getApellido();
        String v3=vendedores.get(2).getNombre()+" "+vendedores.get(2).getApellido();
        String v4=vendedores.get(3).getNombre()+" "+vendedores.get(3).getApellido();
        vendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {v1, v2, v3, v4}));
        
        sucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Portal temuco", "temuco centro","oulet Easton"
                ,"Oulet vivo"}));
    }
    
    
    
     @Override
    public void actionPerformed(ActionEvent e) {
     Vendedor ven;
    
    ven=(Vendedor)vLogin.nombreComb.getSelectedItem();
    String nombre= ven.getNombre();
    String apellido=ven.getApellido();
    int idV = ven.getIdVendedor();
   // id = Integer.parseInt(ven);
   
    
    String Sucursal= vLogin.sucursalCombo.getSelectedItem().toString();
    String fecha= vLogin.fechaTF.getText();
   int monto=Integer.parseInt(vLogin.montoTF.getText());
    VentaDAO vdao=new VentaDAO();
    ModeloVenta v=new ModeloVenta(Sucursal,monto,fecha,idV);
    vdao.ingresarVenta(v);
    }

}