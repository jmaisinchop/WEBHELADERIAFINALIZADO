package ec.edu.ups.beans;

import ec.edu.ups.entidades.Cliente;
import ec.edu.ups.entidades.Factura;
import ec.edu.ups.entidades.FacturaDetalle;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Sucursal;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.facade.DetalleFacturaFacade;
import ec.edu.ups.facade.FacturaFacade;
import ec.edu.ups.facade.ProductoFacade;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rolan
 */
@Model
public class FacturaBean implements Serializable {

    @EJB
    private FacturaFacade facturaFacade;
    @EJB
    private DetalleFacturaFacade detallFacade;

    @EJB
    private ProductoFacade prodFacade;
    private Factura factura;
    private Cliente cliente;
    private Sucursal sucursal;
    private Producto producto = new Producto();
    private Long idProducto;
    private String nombreProducto;

    private FacturaDetalle detalle;
    static List<FacturaDetalle> detalles = new ArrayList<>();
    List<Factura> facturas = new ArrayList<>();
    List<FacturaDetalle> detallesvista = new ArrayList<>();

    //calcular stock nuevo despues de venta
    private int stockActualizado;

    //Datos de la factura cabecera.
    private int codigoFactura;
    private int idCliente;
    private int numerF;
    private String nombreCliente;
    private String direccionCliente;
    private String numeroTelfonoC;
    private String cedula;
    //Datos del detalle factura
    private int cantidad;
    private double precio;
    private double totalXproducto;
    private double subtotal;
    private double iva;
    private double total;

    public FacturaBean() {
        cliente = new Cliente();
        factura = new Factura();
    }

    @Produces
    @RequestScoped
    @Named("listadofacturas")
    public List<Factura> listadofacturas() {
        List<Factura> prod = facturaFacade.listar();
        return prod;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Factura> getFacturas() {

        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getNumeroTelfonoC() {
        return numeroTelfonoC;
    }

    public void setNumeroTelfonoC(String numeroTelfonoC) {
        this.numeroTelfonoC = numeroTelfonoC;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public int getNumerF() {
        return numerF;
    }

    public void setNumerF(int numerF) {
        this.numerF = numerF;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public List<FacturaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<FacturaDetalle> detalles) {
        this.detalles = detalles;
    }

    public FacturaDetalle getDetalle() {
        return detalle;
    }

    public void setDetalle(FacturaDetalle detalle) {
        this.detalle = detalle;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<FacturaDetalle> getDetallesvista() {
        return detallesvista;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public void setDetallesvista(List<FacturaDetalle> detallesvista) {
        this.detallesvista = detallesvista;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    
    public void loadDetalles() {
        Factura f = facturaFacade.getCodigo(codigoFactura);
        detallesvista = f.getDetalles();
    }

    public String verDetalles(int codigo) {
        return "detalles.xhtml?faces-redirect=true&codigo=" + codigo;
    }

    public void buscarCliente() {
        cliente = facturaFacade.buscarClientePorCedula(cedula);
        idCliente=(int) cliente.getId();
        try {
            if (cliente != null) {
                System.out.println("Entra en buscar ");
                nombreCliente = cliente.getNombre() + " " + cliente.getApellido();
                direccionCliente = cliente.getDireccion();
                numeroTelfonoC = cliente.getTelefono();

            } else {
                System.out.println("NO EXISTE 1");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "EL Clinete no Existee"));
                System.out.println("NO EXISTE 2");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Clinete  no existe"));
        }

    }

    public void numFactura() {
        facturas = facturaFacade.findAll();
        numerF = facturas.size() + 1;
        System.out.println(numerF);
    }

    public void buscarProducto() {
        System.out.println("CODIGO DEL PRODUCTO **** : " + idProducto);

        producto = facturaFacade.buscarProductoPorId(idProducto);
        nombreProducto = producto.getNombre();
        precio = producto.getPrecio();

    }

    public void add() {
        totalXproducto = cantidad * precio;
        detalle = new FacturaDetalle();

        //detalle.setId(idProducto);
        detalle.setDescripcion(nombreProducto);
        detalle.setCantidad(cantidad);
        producto.setCantidad(cantidad);
        Producto produto1 = facturaFacade.buscarProductoPorId(idProducto);
        detalle.setProducto(produto1);
        detalle.setPrecio(precio);
        detalle.setTotalXproducto(totalXproducto);
        //detallFacade.create(detalle);
        detalles.add(detalle);
        String txtStock = "";
        //idProducto= null;
        nombreProducto = "";
        cantidad = 0;
        precio = 0;
        subtotal = 0;
        iva = 0;
        total = 0;
        for (int i = 0; i < detalles.size(); i++) {
            subtotal = subtotal + detalles.get(i).getTotalXproducto();
            iva = subtotal * 0.12;
            total = subtotal + iva;
        }

    }

    public void guardarFactura() {
        factura = new Factura();
        facturas = facturaFacade.findAll();
        int idfac = facturas.size() + 1;
        factura.setId(idfac);
        cliente.setId(idCliente);
        cliente.setNombre(nombreCliente);
        factura.setCliente(cliente);
        factura.setDetalles(detalles);
        factura.setSucursal(sucursal);
        factura.setFecha(new Date());
        factura.setIva(iva);
        factura.setSubtotal(subtotal);
        factura.setTotal(total);
        //factura.setId(idCliente);

        facturaFacade.guardarFactura(factura);
        updateStock();
        detalles.clear();

    }

    public void updateStock() {
        for (int i = 0; i < detalles.size(); i++) {
            Producto p = prodFacade.getProductoByName(detalles.get(i).getDescripcion());
            p.setStock(p.getStock() - detalles.get(i).getCantidad());
            p.setCantidad(cantidad);
            prodFacade.edit(p);
        }
    }

}
