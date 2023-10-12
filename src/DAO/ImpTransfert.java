package DAO;

import Config.Database;
import DTO.Agence;
import DTO.Compte;
import DTO.Transfert;
import Interfaces.ITransfert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImpTransfert implements ITransfert {

    Connection cnx= Database.getconn();
    @Override
    public Optional<Transfert> ajouter(Transfert transfert) {
        try {
            String insertSql = "insert into transactions (montant,source_id,destinatair_id) values (?,?,?)";
            PreparedStatement preparedStatement = cnx.prepareStatement(insertSql);
            preparedStatement.setDouble(1, transfert.getMontant());
            preparedStatement.setString(2, transfert.getSourceId().getCode());
            preparedStatement.setString(3, transfert.getDestinataireId().getCode());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return Optional.ofNullable(transfert);
            }
            preparedStatement.close();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public int supprimer(int code) {
        try {
            String deleteSql = "DELETE FROM transactions WHERE numero = ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(deleteSql);
            preparedStatement.setInt(1, code);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return 1;
            }
            preparedStatement.close();
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return 0;
    }

    @Override
    public List<Transfert> trasactParDate(LocalDateTime date) {
        List<Transfert> transferts = new ArrayList<>();
        try {
            String selectSql = "SELECT * FROM transactions WHERE date = '" + date + "'";
            PreparedStatement preparedStatement = cnx.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Transfert transfert = new Transfert();
                transfert.setMontant(resultSet.getInt("montant"));
                Compte dest= new Compte();
                dest.setCode(resultSet.getString("destinatair_id"));
                transfert.setDestinataireId(dest);
                Compte source= new Compte();
                source.setCode(resultSet.getString("source_id"));
                transfert.setDestinataireId(dest);
                transfert.setSourceId(source);
                transferts.add(transfert);
            }
            resultSet.close();
            preparedStatement.close();
            return transferts;
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return transferts;
    }
}
