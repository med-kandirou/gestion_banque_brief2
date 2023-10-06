package services;

import DAO.ImpAgence;
import DAO.ImpOperation;
import DTO.Agence;
import java.util.Optional;

public class AgenceService {
    ImpAgence impAgence;
    public AgenceService(ImpAgence impAg){
        this.impAgence = impAg;
    }

    public boolean ajouter(Agence agence) {
        Optional<Agence> optagence = impAgence.ajouter(agence);
        if (optagence.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean supprimer(int code){
        int optagence=impAgence.supprimer(code);
        if(optagence==1){
            return true;
        }
        else{
            return false;
        }
    }



}
