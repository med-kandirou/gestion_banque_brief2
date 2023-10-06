package DAO;

import Config.Database;
import DTO.Agence;
import DTO.Empagence;
import DTO.Employe;
import Interfaces.IEmpAgence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImpEmpagence implements IEmpAgence {
    Connection cnx= Database.getconn();
    @Override
    public int affecter(Empagence empagence) {
        try {
            String insertSql = "insert into empagence (agence_code, emp_mat) values (?,?)";
            PreparedStatement preparedStatement = cnx.prepareStatement(insertSql);
            preparedStatement.setInt(1, empagence.getAgence().getCode());
            preparedStatement.setString(2, empagence.getEmploye().getMatricule());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return 1;
            }
            preparedStatement.close();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
        return 0;
    }

    @Override
    public List<Empagence> statistique() {
        List<Empagence> emps=new ArrayList<>();
        try {
            String selectSql = "SELECT e.nom,e.prenom,a.nom as nomAgence,a.adresse,a.telephone,ea.date_affectation FROM empagence ea inner join agence a on ea.agence_code=a.code inner join employe e on e.matricule=ea.emp_mat;";
            PreparedStatement preparedStatement = cnx.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Empagence empagence= new Empagence();
                Employe employe= new Employe();
                employe.setNom(resultSet.getString("nom"));
                employe.setPrenom(resultSet.getString("prenom"));
                Agence agence= new Agence();
                agence.setNom(resultSet.getString("nomagence"));
                agence.setAdresse(resultSet.getString("adresse"));
                agence.setTelephone(resultSet.getString("telephone"));
                empagence.setAgence(agence);
                empagence.setEmploye(employe);
                empagence.setDatechangement(resultSet.getDate("date_affectation"));
                emps.add(empagence);
            }
            resultSet.close();
            preparedStatement.close();
            return emps;
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return emps;
    }
}
