package cr.ac.una.monopoly.model;

import cr.ac.una.monopoly.model.Game;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-29T15:05:08", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Propiedad.class)
public class Propiedad_ { 

    public static volatile SingularAttribute<Propiedad, Game> gameId;
    public static volatile SingularAttribute<Propiedad, Long> propiId;
    public static volatile SingularAttribute<Propiedad, Integer> propiPropietario;
    public static volatile SingularAttribute<Propiedad, Integer> propiCasas;
    public static volatile SingularAttribute<Propiedad, Integer> propiHipoteca;
    public static volatile SingularAttribute<Propiedad, Double> propiAlquiler;
    public static volatile SingularAttribute<Propiedad, Integer> propiHoteles;
    public static volatile SingularAttribute<Propiedad, Long> version;

}