
package modelo;

import java.sql.Connection;
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
    

    public ModeloVenta getCuentaByID(int idVendedor) {
        
        Connection accesoBD = con.getConexion();
        Vendedor vend=null;
        ModeloVenta mV = null;
        try{
            String sql="SELECT * FROM cuenta WHERE idcuenta='"+idVendedor+"'";
            //ejemplo: SELECT * FROM Customers WHERE Country='Mexico'; 
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            
            while ( resultados.next() ) {
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                String mail = resultados.getString("email");
                
                //Preparo segunda SQL
                String sql2="SELECT * FROM credencial WHERE idcuenta='"+idVendedor+"'";
              
                //System.out.println(sql);
                Statement st2 = accesoBD.createStatement();
                ResultSet resultados2 = st2.executeQuery(sql);
                
                while (resultados2.next()) {
                    String user = resultados.getString("nombre");
                    String pass = resultados.getString("apellido");
                    vend= new Vendedor(user, pass,idVendedor);
                }
                //Una vez que tengo la cred y los datos de la cuenta puedo crear una cuenta
                mV = new ModeloVenta(vend,nombre, apellido, mail);
                
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
