/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rolan
 */
@Entity
public class Factura implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double total;
    private Date fecha;
    private double subtotal;
    private double iva;
    private Sucursal sucursal;
    
    @ManyToOne
    @JoinColumn
    private Cliente cliente;
    
    @OneToMany(fetch = FetchType.LAZY)
    private List<FacturaDetalle> detalles;
    
    public Factura() {
    }

    public Factura(int id, double total, Date fecha, double subtotal, double iva, Sucursal sucursal, Cliente cliente, List<FacturaDetalle> detalles) {
        this.id = id;
        this.total = total;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.sucursal = sucursal;
        this.cliente = cliente;
        this.detalles = detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<FacturaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<FacturaDetalle> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", total=" + total + ", fecha=" + fecha + ", subtotal=" + subtotal + ", iva=" + iva + ", sucursal=" + sucursal + ", cliente=" + cliente + ", detalles=" + detalles + '}';
    }
    
}
