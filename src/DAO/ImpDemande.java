package DAO;

import Config.Database;
import DTO.Demande;
import Interfaces.IDemande;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Optional;

public class ImpDemande implements IDemande {
    Connection cnx= Database.getconn();
    @Override
    public Optional<Demande> ajouter(Demande demande) {
        try {
            String insertSql = "INSERT INTO demandeCredit (montant, duree, remarques, Client_code) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = cnx.prepareStatement(insertSql);
            preparedStatement.setDouble(1, demande.getSimulation().getCapitalEmprunte());
            preparedStatement.setDouble(2, demande.getSimulation().getNombreMensualite());
            preparedStatement.setString(3, demande.getRemarques());
            preparedStatement.setString(4, demande.getClient().getCode());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return Optional.ofNullable(demande);
            }
            preparedStatement.close();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
        return Optional.empty();
    }
}
