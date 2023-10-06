package Interfaces;

import DTO.Empagence;

import java.util.List;

public interface IEmpAgence {
    int affecter (Empagence empagence);

    List<Empagence> statistique ();
}
