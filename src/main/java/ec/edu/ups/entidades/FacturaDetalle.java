package ec.edu.ups.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.io.Serializable;

/**
 *
 * @author rolan
 */
@Entity
public class FacturaDetalle implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private double precio;
    private String descripcion;
    private double totalXproducto;
    
    @OneToOne
    @JoinColumn
    private Producto producto;
    
    //@ManyToOne
    //@JoinColumn
    //private Factura factura;
    
    public FacturaDetalle() {
        
    }

    public FacturaDetalle(Long id, int cantidad, double precio, String descripcion, double totalXproducto) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.totalXproducto = totalXproducto;
    }

    
    
    public FacturaDetalle(Long id, int cantidad, double precio, double totalXproducto, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.totalXproducto = totalXproducto;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotalXproducto() {
        return totalXproducto;
    }

    public void setTotalXproducto(double totalXproducto) {
        this.totalXproducto = totalXproducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Override
    public String toString() {
        return "FacturaDeatalle{" + "id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + ", totalXproducto=" + totalXproducto + ", producto=" + producto + '}';
    }

    public void setId(int num) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
