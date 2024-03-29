/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopoly.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Servidor
 */
public class GameDto implements Serializable {

    public SimpleStringProperty id;
    public ObjectProperty<LocalDate> fecha;
    public SimpleStringProperty nomJugador1;
    public SimpleStringProperty nomJugador2;
    public Integer posiFicha1;
    public Integer posiFicha2;
    public Double cuentaJugador1;
    public Double cuentaJugador2;
    public Long version;
    private Boolean modificado;
    private Collection<Propiedad> propiedadCollection;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    

    public GameDto() {
        this.id = new SimpleStringProperty();
        this.fecha = new SimpleObjectProperty<>(LocalDate.now());
        this.nomJugador1 = new SimpleStringProperty();
        this.nomJugador2 = new SimpleStringProperty();
        this.modificado = false;
    }

    public GameDto(Game game) {
       
          if (game.getId() != null) {
            this.id.set(game.getId().toString());
        }
             if (game.getFecha() != null) {
        this.fecha = new SimpleObjectProperty<>(game.getFecha());
    } else {
        this.fecha = new SimpleObjectProperty<>(LocalDate.now());
    }
     
        if (this.nomJugador1 == null) {
    this.nomJugador1 = new SimpleStringProperty();
}
this.nomJugador1.set("valor");

        if (this.nomJugador2 == null) {
    this.nomJugador2 = new SimpleStringProperty();
}
this.nomJugador2.set("valor");

        this.posiFicha1=game.getPosiFicha1();
        this.posiFicha2=game.getPosiFicha2();
        this.cuentaJugador1=game.getCuentaJugador1();
        this.cuentaJugador2=game.getCuentaJugador2();
        this.version=game.getVersion();
        this.propiedadCollection = game.getPropiedadCollection();
    }

    public Long getId() {
        if(id.get()!=null && !id.get().isEmpty())
            return Long.valueOf(id.get());
        else
            return null;
    }

    public void setId(Long id) {
        this.id.set(id.toString()) ;
    }


    public LocalDate getFecha() {
        return fecha.get();
    }

    public void setFecha(LocalDate fecha) {
        this.fecha.set(fecha);
    }

    public String getNomJugador1() {
        return nomJugador1.get();
    }

    public void setNomJugador1(String nomJugador1) {
        this.nomJugador1.set(nomJugador1); ;
    }

    public String getNomJugador2() {
        return nomJugador2.get();
    }

    public void setNomJugador2(String nomJugador2) {
        this.nomJugador2.set(nomJugador2);
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

    @Override
    public String toString() {
        return "GameDto{" + "id=" + id + ", fecha=" + fecha + ", nomJugador1=" + nomJugador1 + ", nomJugador2=" + nomJugador2 + ", posiFicha1=" + posiFicha1 + ", posiFicha2=" + posiFicha2 + ", cuentaJugador1=" + cuentaJugador1 + ", cuentaJugador2=" + cuentaJugador2 + ", version=" + version + ", modificado=" + modificado + '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GameDto other = (GameDto) obj;
        return Objects.equals(this.fecha, other.fecha);
    }
    

}
