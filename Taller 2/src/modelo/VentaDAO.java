
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chelo
 */
public class VentaDAO {

  Conexion con;
    public VentaDAO() {
        con = new Conexion();
    }
    

    public ModeloVenta getVentaByID(int idVenta) {
        
        Connection accesoBD = con.getConexion();
        Vendedor vend=null;
        ModeloVenta c = null;
        try{
            String sql="SELECT * FROM vend WHERE idventa='"+idVenta+"'";
            //ejemplo: SELECT * FROM Customers WHERE Country='Mexico'; 
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            
            
            //int idVenta, String sucursal, int monto, Date fecha, Vendedor id_vendedor
            while ( resultados.next() ) {
                
                String sucurl = resultados.getString("sucursal");
                int monto = resultados.getInt("monto");
                Date fecha = resultados.getDate("fecha");
                
                //Preparo segunda SQL
                String sql2="SELECT * FROM credencial WHERE idcuenta='"+idVenta+"'";
              
                //System.out.println(sql);
                Statement st2 = accesoBD.createStatement();
                ResultSet resultados2 = st2.executeQuery(sql);
                
                
                
               
                while (resultados2.next()) {
                    int idVendedor = resultados.getInt("id");
                    String nomb= resultados.getString("nombre");
                    String apell= resultados.getString("apellido");
                    String rut= resultados.getString("rut");
                    vend= new Vendedor(idVendedor,nomb, apell, rut);
                }
                //Una vez que tengo la cred y los datos de la cuenta puedo crear una cuenta
                c = new ModeloVenta(idVenta,sucurl, monto, fecha,vend);
                
            }
            accesoBD.close();
            return c;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
    }
    
}