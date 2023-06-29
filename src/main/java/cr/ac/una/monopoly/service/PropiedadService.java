/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopoly.service;

import cr.ac.una.monopoly.model.Propiedad;
import cr.ac.una.monopoly.model.PropiedadDto;
import cr.ac.una.monopoly.util.EntityManagerHelper;
import cr.ac.una.monopoly.util.Respuesta;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Servidor
 */
public class PropiedadService {

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Respuesta getPropiedad(Long propiId) {
        try {
            Query qryPropiedad = em.createNamedQuery("Propiedad.findByPropiId", Propiedad.class);
            qryPropiedad.setParameter("propiId", propiId);
            PropiedadDto propiedadDto = new PropiedadDto((Propiedad) qryPropiedad.getSingleResult());
            return new Respuesta(true, "", "", "Propiedad", propiedadDto);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe una Propiedad con las credenciales ingresadas.", "getPropiedad NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar la propiedad.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar la propiedad.", "getPropiedad NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, "Error obteniendo la Propiedad [" + propiId + "]", ex);
            return new Respuesta(false, "Error obteniendo la Propiedad.", "getPropiedad " + ex.getMessage());
        }
    }

    public Respuesta guardarPropiedad(PropiedadDto propiedadDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Propiedad propiedad;

            
            propiedad = new Propiedad(propiedadDto);
            em.persist(propiedad);

            et.commit();
            return new Respuesta(true, "", "", "Propiedad", new PropiedadDto(propiedad));
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar la propiedad.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar la propiedad", "guardarPropiedad " + ex.getMessage());
        }
    }

    public Respuesta eliminarPropiedad(Long id) {
        try {
            et = em.getTransaction();
            et.begin();
            Propiedad propiedad;
            if (id != null && id > 0) {
                propiedad = em.find(Propiedad.class, id);
                if (propiedad == null) {
                    et.rollback();
                    return new Respuesta(false, "No se encrontró la propiedad a eliminar.", "eliminarPartida NoResultException");
                }
                em.remove(propiedad);
            } else {
                et.rollback();
                return new Respuesta(false, "Debe cargar la propiedad a eliminar.", "eliminarPartida NoResultException");
            }
            et.commit();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(PropiedadService.class.getName()).log(Level.SEVERE, "Error eliminando la partida.", ex);
            return new Respuesta(false, "Error eliminando la propiedad.", "eliminarPropiedad " + ex.getMessage());
        }
    }
}
