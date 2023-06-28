/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopoly.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author Servidor
 */
@Entity
@Table(name = "PLAM_GAME", schema = "UNA")
@NamedQueries({
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g"),
    @NamedQuery(name = "Game.findByGameId", query = "SELECT g FROM Game g WHERE g.id = :id"),
    @NamedQuery(name = "Game.findByFecha", query = "SELECT g FROM Game g WHERE g.fecha = :fecha")})
   /*, @NamedQuery(name = "Game.findByNomJugador1", query = "SELECT g FROM Game g WHERE g.nomJugador1 = :nomJugador1"),
    @NamedQuery(name = "Game.findByNomJugador2", query = "SELECT g FROM Game g WHERE g.nomJugador2 = :nomJugador2"),
    @NamedQuery(name = "Game.findByGamePosiFicha1", query = "SELECT g FROM Game g WHERE g.gamePosiFicha1 = :gamePosiFicha1"),
    @NamedQuery(name = "Game.findByGamePosiFicha2", query = "SELECT g FROM Game g WHERE g.gamePosiFicha2 = :gamePosiFicha2"),
    @NamedQuery(name = "Game.findByGameCuentaJugador1", query = "SELECT g FROM Game g WHERE g.gameCuentaJugador1 = :gameCuentaJugador1"),
    @NamedQuery(name = "Game.findByGameCuentaJugador2", query = "SELECT g FROM Game g WHERE g.gameCuentaJugador2 = :gameCuentaJugador2")*/
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "GAME_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate fecha;
    @Basic(optional = false)
    @Column(name = "NOM_JUGADOR1")
    private String nomJugador1;
    @Basic(optional = false)
    @Column(name = "NOM_JUGADOR2")
    private String nomJugador2;
    @Basic(optional = false)
    @Column(name = "GAME_POSI_FICHA1")
    private Integer posiFicha1;
    @Basic(optional = false)
    @Column(name = "GAME_POSI_FICHA2")
    private Integer posiFicha2;
    @Basic(optional = false)
    @Column(name = "GAME_CUENTA_JUGADOR1")
    private Double cuentaJugador1;
    @Basic(optional = false)
    @Column(name = "GAME_CUENTA_JUGADOR2")
    private Double cuentaJugador2;
    @Version
    @Column(name = "GAME_VERSION")
    private Long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameId", fetch = FetchType.LAZY)
    private Collection<Propiedad> propiedadCollection;

    public Game() {
    }

    public Game(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game(GameDto gameDto) {
        this.id = gameDto.getId();
        actualizar(gameDto);
    }
        public void actualizar(GameDto gameDto) {
        this.fecha=gameDto.getFecha();
        this.nomJugador1=gameDto.getNomJugador1();
        this.nomJugador2=gameDto.getNomJugador2();
        this.posiFicha1=gameDto.getPosiFicha1();
        this.posiFicha2=gameDto.getPosiFicha2();
        this.cuentaJugador1=gameDto.getCuentaJugador1();
        this.cuentaJugador2=gameDto.getCuentaJugador2();
        this.version=gameDto.getVersion();
          }
    


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNomJugador1() {
        return nomJugador1;
    }

    public void setNomJugador1(String nomJugador1) {
        this.nomJugador1 = nomJugador1;
    }

    public String getNomJugador2() {
        return nomJugador2;
    }

    public void setNomJugador2(String nomJugador2) {
        this.nomJugador2 = nomJugador2;
    }

    public Integer getPosiFicha1() {
        return posiFicha1;
    }

    public void setPosiFicha1(Integer posiFicha1) {
        this.posiFicha1 = posiFicha1;
    }

    public Integer getPosiFicha2() {
        return posiFicha2;
    }

    public void setPosiFicha2(Integer posiFicha2) {
        this.posiFicha2 = posiFicha2;
    }

    public Double getCuentaJugador1() {
        return cuentaJugador1;
    }

    public void setCuentaJugador1(Double cuentaJugador1) {
        this.cuentaJugador1 = cuentaJugador1;
    }

    public Double getCuentaJugador2() {
        return cuentaJugador2;
    }

    public void setCuentaJugador2(Double cuentaJugador2) {
        this.cuentaJugador2 = cuentaJugador2;
    }


    public Collection<Propiedad> getPropiedadCollection() {
        return propiedadCollection;
    }

    public void setPropiedadCollection(Collection<Propiedad> propiedadCollection) {
        this.propiedadCollection = propiedadCollection;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.monopoly.model.Game[ gameId=" + id + " ]";
    }


    
}
