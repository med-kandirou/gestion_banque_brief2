package DAO;

import Config.Database;
import DTO.Agence;
import DTO.Employe;
import Interfaces.IAgence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ImpAgence implements IAgence {

    Connection cnx= Database.getconn();
    @Override
    public Optional<Agence> ajouter(Agence agence) {
        try {
            String insertSql = "insert into agence (nom, adresse, telephone) values (?,?,?)";
            // Create a PreparedStatement
            PreparedStatement preparedStatement = cnx.prepareStatement(insertSql);
            preparedStatement.setString(1, agence.getNom());
            preparedStatement.setString(2, agence.getAdresse());
            preparedStatement.setString(3,agence.getTelephone());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return Optional.ofNullable(agence);
            }
            preparedStatement.close();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public int supprimer(Integer id) {
        try {
            String deleteSql = "DELETE FROM agence WHERE code = ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);
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
    public Optional<Agence> update(Agence agence) {
        try {
            String insertSql = "update agence set nom= ? , adresse= ? ,telephone=? where code= ?";
            // Create a PreparedStatement
            PreparedStatement preparedStatement = cnx.prepareStatement(insertSql);
            preparedStatement.setString(1, agence.getNom());
            preparedStatement.setString(2, agence.getAdresse());
            preparedStatement.setString(3,agence.getTelephone());
            preparedStatement.setInt(4,agence.getCode());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return Optional.ofNullable(agence);
            }
            preparedStatement.close();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Agence> cherchebyId(Integer id) {
        Agence agence = new Agence();
        try {
            String selectSql = "SELECT * FROM agence WHERE code = '" + id + "'";
            PreparedStatement preparedStatement = cnx.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                agence.setCode(resultSet.getInt("code"));
                agence.setNom(resultSet.getString("nom"));
                agence.setTelephone(resultSet.getString("telephone"));
                agence.setAdresse(resultSet.getString("adresse"));
            }
            resultSet.close();
            preparedStatement.close();
            return Optional.ofNullable(agence);
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return Optional.empty();
    }
    @Override
    public List<Agence> afficher() {
        return null;
    }

    @Override
    public Optional<Agence> cherchebyAdresse(String adresse) {
        Agence agence = new Agence();
        try {
            String selectSql = "SELECT * FROM agence WHERE adresse = '" + adresse + "'";
            PreparedStatement preparedStatement = cnx.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                agence.setCode(resultSet.getInt("code"));
                agence.setNom(resultSet.getString("nom"));
                agence.setTelephone(resultSet.getString("telephone"));
                agence.setAdresse(resultSet.getString("adresse"));
            }
            resultSet.close();
            preparedStatement.close();
            return Optional.ofNullable(agence);
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public HashMap<String, String> afficherContact() {
        HashMap<String,String> contacts= new HashMap<>();
        try {
            String selectSql = "SELECT adresse,telephone FROM agence";
            PreparedStatement preparedStatement = cnx.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                contacts.put(resultSet.getString("adresse"),resultSet.getString("telephone"));
            }
            resultSet.close();
            preparedStatement.close();
            return contacts;
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return contacts;
    }


}
