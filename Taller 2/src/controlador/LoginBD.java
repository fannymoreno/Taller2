/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Vendedor;
import modelo.ModeloVenta;
import modelo.VentaDAO;
import vista.ventRegistrar;
import vista.VentanaReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Antonia
 */
public class  LoginBD implements ActionListener {
//     public static void main(String[] args) {
//        // TODO code application logic here
//
//        ventRegistrar v = new ventRegistrar();
//        v.setVisible(true);
//        
//    }
     
    public ventRegistrar r1;
    
//    public RegistrarControlador(ventRegistrar r){
//             this.r1=r;
//    
//    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("registrar")){
            
            String fecha = this.r1.fechaTF.getText();
            int monto = Integer.parseInt(this.r1.montoTF.getText());
            String sucursal = this.r1.sucursalCombo.getItemAt(0);
            //String nombre = this.r1.listaVendedores.getItemAt(0);
            Vendedor vendedor = (Vendedor) this.r1.nombreComb.getSelectedItem();
            
            
            Vendedor ven = vendedor;
            int id = ven.getIdVendedor();
            //int idVenta, String sucursal, int monto, String fecha, int id_vendedor
            ModeloVenta v1 = new ModeloVenta(sucursal,monto,fecha,id);
            VentaDAO  ventaDAO = new VentaDAO();
            ventaDAO.ingresarVenta(v1);
            
            //Venta aux = ventaDAO.getId_venta(v1);
            
            
            
            
            
            VentanaReportes r1 = new VentanaReportes();
            
            
            
            
            
            
            
            
        }
    }
}
