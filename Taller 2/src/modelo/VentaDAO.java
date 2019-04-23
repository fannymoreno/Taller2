
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
   Vendedor vend;
  Conexion con;
    public VentaDAO() {
       this.con = new Conexion();
    }
    

    public ArrayList<ModeloVenta> getVentaByID(int idVenta) {
        
      
        
        ArrayList<ModeloVenta> ventas = new ArrayList<>();
       

        Connection accesoBD = con.getConexion();
        Vendedor vend;
        ModeloVenta c;
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
                String fecha = resultados.getString("fecha");
                int idVendedor = resultados.getInt("id");
                //Preparo segunda SQL
                String sql2="SELECT * FROM credencial WHERE idcuenta='"+idVenta+"'";
              
                //System.out.println(sql);
                Statement st2 = accesoBD.createStatement();
                ResultSet resultados2 = st2.executeQuery(sql);
                
                
                
               
                while (resultados2.next()) {
                    //int idVendedor = resultados.getInt("id");
                    String nomb= resultados.getString("nombre");
                    String apell= resultados.getString("apellido");
                    String rut= resultados.getString("rut");
                    //vend= new Vendedor(idVendedor,nomb, apell, rut);
                }
                //Una vez que tengo la cred y los datos de la cuenta puedo crear una cuenta
                c = new ModeloVenta(sucurl, monto, fecha,idVendedor);
                
            }
            accesoBD.close();
            return null;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
    }
    

      public boolean ingresarVenta(ModeloVenta v){
        Connection accesoBD = con.getConexion();
        boolean resp = false;
        
        try{
            String sql= "INSERT INTO venta VALUES ( NULL ,'"+v.getSucursal()+"', '"+v.getMonto()+"', '"+v.getFecha()+"','"+v.getId_vendedor()+"')";
            
            Statement st = accesoBD.createStatement();
            
            st.executeUpdate(sql);
            //query es para consultas
            resp = true;
            accesoBD.close();
        } catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
        return resp;    
    }
      public ArrayList<ModeloVenta> getVentasMes(String mes){
        
        ArrayList<ModeloVenta> ventas = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM venta WHERE fecha BETWEEN '2018-"+mes+"-01' and '2018-10-31'";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int idVenta = Integer.parseInt(resultados.getString("id_venta"));
                String sucursal = resultados.getString("sucursal");
                int monto = Integer.parseInt(resultados.getString("monto"));
                String fecha = resultados.getString("fecha");
                     int idVendedor = Integer.parseInt(resultados.getString("id_vendedor"));
                ventas.add(new ModeloVenta(sucursal,monto,fecha,idVendedor));
            }
            accesoBD.close();
            return ventas;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
    }
  public ArrayList<ModeloVenta> getVentasVendedor(int idV){
        
        ArrayList<ModeloVenta> ventas = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM venta WHERE id_vendedor='"+idV+"'";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int idVenta = Integer.parseInt(resultados.getString("id_venta"));
                String sucursal = resultados.getString("sucursal");
                int monto = Integer.parseInt(resultados.getString("monto"));
                String fecha = resultados.getString("fecha");
                 int idVendedor = Integer.parseInt(resultados.getString("id_vendedor"));
                ventas.add(new ModeloVenta(sucursal,monto,fecha,idVendedor));
            }
            accesoBD.close();
            return ventas;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
    }
}

    
