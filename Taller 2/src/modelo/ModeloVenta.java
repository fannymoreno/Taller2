
package modelo;

import java.sql.Date;


public class ModeloVenta {
    private int idVenta;
    String sucursal;
    int monto;
    Date fecha;
    Vendedor id_vendedor;

    public ModeloVenta(int idVenta, String sucursal, int monto, Date fecha, Vendedor id_vendedor) {
        this.idVenta = idVenta;
        this.sucursal = sucursal;
        this.monto = monto;
        this.fecha = fecha;
        this.id_vendedor = id_vendedor;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Vendedor getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(Vendedor id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    
}