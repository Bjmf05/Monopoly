/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopoly.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author Servidor
 */
@Entity
@Table(name = "PLAM_PROPIEDADES", schema = "UNA")
@NamedQueries({
    @NamedQuery(name = "Propiedad.findAll", query = "SELECT p FROM Propiedad p"),
   /* @NamedQuery(name = "Propiedad.findByPropiId", query = "SELECT p FROM Propiedad p WHERE p.propiId = :propiId"),
    @NamedQuery(name = "Propiedad.findByPropiPropietario", query = "SELECT p FROM Propiedad p WHERE p.propiPropietario = :propiPropietario"),
    @NamedQuery(name = "Propiedad.findByPropiAlquiler", query = "SELECT p FROM Propiedad p WHERE p.propiAlquiler = :propiAlquiler"),
    @NamedQuery(name = "Propiedad.findByPropiCasas", query = "SELECT p FROM Propiedad p WHERE p.propiCasas = :propiCasas"),
    @NamedQuery(name = "Propiedad.findByPropiHoteles", query = "SELECT p FROM Propiedad p WHERE p.propiHoteles = :propiHoteles"),
    @NamedQuery(name = "Propiedad.findByPropiHipoteca", query = "SELECT p FROM Propiedad p WHERE p.propiHipoteca = :propiHipoteca")*/})
public class Propiedad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PROPI_ID")
    private Long propiId;
    @Basic(optional = false)
    @Column(name = "PROPI_PROPIETARIO")
    private Integer propiPropietario;
    @Basic(optional = false)
    @Column(name = "PROPI_ALQUILER")
    private Double propiAlquiler;
    @Column(name = "PROPI_CASAS")
    private Integer propiCasas;
    @Column(name = "PROPI_HOTELES")
    private Integer propiHoteles;
    @Column(name = "PROPI_HIPOTECA")
    private Integer propiHipoteca;
    @Version
    @Column(name = "GAME_VERSION")
    private Long version;
    @JoinColumn(name = "GAME_ID", referencedColumnName = "GAME_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Game gameId;

    public Propiedad() {
    }

    public Propiedad(Long propiId) {
        this.propiId = propiId;
    }

  

    public Long getPropiId() {
        return propiId;
    }

    public Integer getPropiPropietario() {
        return propiPropietario;
    }

    public void setPropiPropietario(Integer propiPropietario) {
        this.propiPropietario = propiPropietario;
    }

    public Double getPropiAlquiler() {
        return propiAlquiler;
    }

    public void setPropiAlquiler(Double propiAlquiler) {
        this.propiAlquiler = propiAlquiler;
    }

    public Integer getPropiCasas() {
        return propiCasas;
    }

    public void setPropiCasas(Integer propiCasas) {
        this.propiCasas = propiCasas;
    }

    public Integer getPropiHoteles() {
        return propiHoteles;
    }

    public void setPropiHoteles(Integer propiHoteles) {
        this.propiHoteles = propiHoteles;
    }

    public Integer getPropiHipoteca() {
        return propiHipoteca;
    }

    public void setPropiHipoteca(Integer propiHipoteca) {
        this.propiHipoteca = propiHipoteca;
    }

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
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
        hash += (propiId != null ? propiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propiedad)) {
            return false;
        }
        Propiedad other = (Propiedad) object;
        if ((this.propiId == null && other.propiId != null) || (this.propiId != null && !this.propiId.equals(other.propiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.monopoly.model.Propiedad[ propiId=" + propiId + " ]";
    }
    
}
