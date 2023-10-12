package Interfaces;

import DTO.Demande;

import java.util.Optional;

public interface IDemande {

    Optional<Demande> ajouter(Demande demande);
}
