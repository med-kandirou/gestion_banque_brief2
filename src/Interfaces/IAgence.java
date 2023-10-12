package Interfaces;

import DTO.Agence;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface IAgence extends IData<Agence,Integer>{

    Optional<Agence> cherchebyAdresse(String adresse);
    HashMap<String,String> afficherContact();

}
