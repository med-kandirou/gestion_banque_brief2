package services;

import DAO.ImpAgence;
import DAO.ImpOperation;
import DTO.Agence;

import java.util.HashMap;
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


    public Optional<Agence> rechercheParCode(int code){
        Optional<Agence> optagence=impAgence.cherchebyId(code);
        if(optagence.isPresent()){
            return optagence;
        }else {
            return Optional.empty();
        }
    }

    public Optional<Agence> rechercheParAdresse(String adresse){
        Optional<Agence> optagence=impAgence.cherchebyAdresse(adresse);
        if(optagence.isPresent()){
            return optagence;
        }else {
            return Optional.empty();
        }
    }

    public HashMap<String,String> AfficheContact(){
        HashMap<String,String> contacts=impAgence.afficherContact();
        return contacts;
    }



}
