package services;

import DAO.ImpAgence;
import DAO.ImpDemande;
import DTO.Agence;
import DTO.Demande;

import java.util.Optional;

public class demandeService {
    ImpDemande impDemande;
    public demandeService(ImpDemande impDemande){
        this.impDemande = impDemande;
    }

    public boolean ajouter(Demande demande) {
        Optional<Demande> optdemande=impDemande.ajouter(demande);
        return optdemande.isPresent();
    }
}
