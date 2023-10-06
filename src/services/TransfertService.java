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


    public boolean supprimer(int code){
        int deleted=imptransfert.supprimer(code);
        if(deleted==1){
            return true;
        }
        return false;
    }
}
