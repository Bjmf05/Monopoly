/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopoly.model;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Servidor
 */
public class PropiedadDto implements Serializable {
    public SimpleStringProperty propiId;
    public Integer propiPropietario;
    public Double propiAlquiler;
    public Integer propiCasas;
    public Integer propiHoteles;
    public Integer propiHipoteca;
    public Game gameId;
    public Long version;
    
    public PropiedadDto() {
         this.propiId = new SimpleStringProperty();
    }

    public PropiedadDto(Propiedad propiedad) {
        this.propiId.set(propiedad.getPropiId().toString());
        this.propiAlquiler=propiedad.getPropiAlquiler();
        this.propiCasas=propiedad.getPropiCasas();
        this.propiHipoteca=propiedad.getPropiHipoteca();
        this.propiHoteles=propiedad.getPropiHoteles();
        this.propiPropietario = propiedad.getPropiPropietario();
        this.version = propiedad.getVersion();
        this.gameId = propiedad.getGameId();
                
        
    }
    

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
    public Long getPropiId() {
       if(propiId.get()!=null && !propiId.get().isEmpty())
            return Long.valueOf(propiId.get());
        else
            return null;
    }

    public void setPropiId(Long propiId) {
        this.propiId.set(propiId.toString());
    }

    public Integer getPropiPropietario() {
        return propiPropietario;
    }

    public void setPropiPropietario(Integer propiPropietario) {
        this.propiPropietario =propiPropietario;
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
    
    
}
