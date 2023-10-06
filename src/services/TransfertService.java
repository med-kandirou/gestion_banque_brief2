package services;

import DAO.ImpTransfert;
import DTO.Transfert;

import java.util.Optional;

public class TransfertService {
    ImpTransfert imptransfert ;

    Transfert transfert;

    public TransfertService(ImpTransfert imptransfert) {
        this.imptransfert = imptransfert;
    }

    public Optional<Transfert> ajouter(Transfert transfert){
        Optional<Transfert> optran= imptransfert.ajouter(transfert);
        return optran;
    }
}
