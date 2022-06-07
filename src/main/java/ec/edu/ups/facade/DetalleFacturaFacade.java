/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;


import ec.edu.ups.entidades.FacturaDetalle;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class DetalleFacturaFacade extends AbstractFacade<FacturaDetalle> {

    @PersistenceContext(name = "TestJpa")
    private EntityManager em;

    public DetalleFacturaFacade() {
        super(FacturaDetalle.class);
        
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void calcularSubtoral(){
        
    }
    
        public FacturaDetalle  getCodigo(int codigo) {
        String jpql = "SELECT u FROM DetalleFactura u WHERE u.codigoDetalle = '" + codigo+"'";
        FacturaDetalle factura = (FacturaDetalle) em.createQuery(jpql).getSingleResult();
        return factura;
    }
    
}
