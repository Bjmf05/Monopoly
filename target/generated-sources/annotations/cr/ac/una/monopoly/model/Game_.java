package cr.ac.una.monopoly.model;

import cr.ac.una.monopoly.model.Propiedad;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-29T15:05:08", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Game.class)
public class Game_ { 

    public static volatile SingularAttribute<Game, LocalDate> fecha;
    public static volatile SingularAttribute<Game, Integer> posiFicha1;
    public static volatile SingularAttribute<Game, String> nomJugador1;
    public static volatile SingularAttribute<Game, Integer> posiFicha2;
    public static volatile CollectionAttribute<Game, Propiedad> propiedadCollection;
    public static volatile SingularAttribute<Game, String> nomJugador2;
    public static volatile SingularAttribute<Game, Double> cuentaJugador1;
    public static volatile SingularAttribute<Game, Double> cuentaJugador2;
    public static volatile SingularAttribute<Game, Long> id;
    public static volatile SingularAttribute<Game, Long> version;

}