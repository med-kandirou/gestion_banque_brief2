package Interfaces;

import DTO.Transfert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ITransfert {
    Optional<Transfert> ajouter(Transfert transfert);
    int supprimer(int code);
    List<Transfert> trasactParDate(LocalDateTime date);
}
