/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import java.io.Serializable;

/**
 *
 * @author Jonny,Daniel,Elvis,Edisson
 */
@Entity
@NamedQuery(name = "getPedido", query = "SELECT pe FROM  Pedido pe")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private char estado;
    private double longitud;
    private double latitud;
    private double subTotal;
    private double iva;
    private double total;
    @ManyToOne
    @JoinColumn(nullable = true)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Producto producto;
    
    @OneToOne
    @JoinColumn(nullable = true)
    private FacturaDetalle facturaDetalle;

    public Pedido() {
        super();
    }

}
