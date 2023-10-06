package Interfaces;

import java.util.List;
import java.util.Optional;

public interface IData <Entity, IdType>  {
    Optional<Entity> ajouter(Entity entity);
    int supprimer(IdType id);
    Optional<Entity> update(Entity entity);
    Optional<Entity> cherchebyId(IdType id);
    List<Entity> afficher();
}
