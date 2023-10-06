package Interfaces;

import DTO.Agence;

import java.util.Optional;

public interface IAgence extends IData<Agence,Integer>{

    Optional<Agence> cherchebyAdresse(String adresse);

}
