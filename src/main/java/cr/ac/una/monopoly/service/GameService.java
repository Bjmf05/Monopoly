/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopoly.service;

import cr.ac.una.monopoly.model.Game;
import cr.ac.una.monopoly.model.GameDto;
import cr.ac.una.monopoly.util.EntityManagerHelper;
import cr.ac.una.monopoly.util.Respuesta;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Servidor
 */
public class GameService {

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Respuesta getPartida(Long id, LocalDate fecha) {
        try {
            Query qryPartida = em.createNamedQuery("Game.findByGameId", Game.class);
            qryPartida.setParameter("id", id);
            qryPartida.setParameter("fecha", fecha);
            GameDto gameDto = new GameDto((Game) qryPartida.getSingleResult());
            return new Respuesta(true, "", "", "Partida", gameDto);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe una partida con las credenciales ingresadas.", "getPartida NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar la partida.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar la partida.", "getPartida NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, "Error obteniendo la partida [" + id + "]", ex);
            return new Respuesta(false, "Error obteniendo la partida.", "getPartida " + ex.getMessage());
        }
    }
    public Game obtenerJuegoPorId(Long id) {
    try {
        Query qryPartida = em.createNamedQuery("Game.findByGameId", Game.class);
        qryPartida.setParameter("id", id);
        return (Game) qryPartida.getSingleResult();
    } catch (NoResultException ex) {
        return null;
    } catch (NonUniqueResultException ex) {
        Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, "Ocurrió un error al consultar el juego.", ex);
        return null;
    } catch (Exception ex) {
        Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, "Error obteniendo el juego [" + id + "]", ex);
        return null;
    }
}

 public Respuesta guardarPartida(GameDto gameDto) {
    EntityTransaction et = null;
    try {
        et = em.getTransaction();
        et.begin();
        Game game;
        if (gameDto.getId() != null && gameDto.getId() > 0) {
            game = em.find(Game.class, gameDto.getId());
            if (game == null) {
                et.rollback();
                return new Respuesta(false, "No se encontró la partida a modificar", "guardarPartida NoResultException");
            }
            game.actualizar(gameDto);
            game = em.merge(game);
        } else {
            game = new Game(gameDto);
            em.persist(game);
        }
        et.commit();
        Respuesta respuesta = new Respuesta(true, "", "", "Partida", new GameDto(game));
        respuesta.setResultado("gameDto", new GameDto(game));
        return respuesta;
    } catch (Exception ex) {
        if (et.isActive()) {
            et.rollback();
        }
        Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, "Ocurrió un error al guardar la partida.", ex);
        return new Respuesta(false, "Ocurrió un error al guardar la partida", "guardarPartida " + ex.getMessage());
    }
}
    
     public Respuesta eliminarPartida(Long id) {
        try {
            et = em.getTransaction();
            et.begin();
            Game game;
            if (id != null && id > 0){
                game = em.find(Game.class, id);
                if (game == null){
                    et.rollback();
                    return new Respuesta(false, "No se encrontró la partida a eliminar.", "eliminarPartida NoResultException");
                }
                em.remove(game);
            } else {
                et.rollback();
                return new Respuesta(false, "Debe cargar la partida a eliminar.", "eliminarPartida NoResultException");
            }
            et.commit();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, "Error eliminando la partida.", ex);
            return new Respuesta(false, "Error eliminando la partida.", "eliminarPartida " + ex.getMessage());
        }
    }
     public Game obtenerJuegoActual() {
    try {
        TypedQuery<Game> query = em.createQuery("SELECT g FROM Game g ORDER BY g.id DESC", Game.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    } catch (NoResultException ex) {
        return null;
    }
}
}
