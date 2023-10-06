package DAO;

import Config.Database;
import DTO.Transfert;
import Interfaces.ITransfert;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        return 0;
    }
}
