package Interfaces;

import DTO.Transfert;

import java.util.Optional;

public interface ITransfert {
    Optional<Transfert> ajouter(Transfert transfert);
    int supprimer(int code);
}
