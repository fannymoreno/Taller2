
package modelo;

import java.sql.Date;


public class ModeloVenta {
   // private int idVenta;
    String sucursal;
    int monto;
    String fecha;
    int id_vendedor;

    public ModeloVenta( String sucursal, int monto, String fecha, int id_vendedor) {
       // this.idVenta = idVenta;
        this.sucursal = sucursal;
        this.monto = monto;
        this.fecha = fecha;
        this.id_vendedor = id_vendedor;
    }

//    public int getIdVenta() {
//        return idVenta;
//    }
//
//    public void setIdVenta(int idVenta) {
//        this.idVenta = idVenta;
//    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    
}