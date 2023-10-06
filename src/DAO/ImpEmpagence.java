package DAO;

import Config.Database;
import DTO.Agence;
import DTO.Empagence;
import DTO.Employe;
import Interfaces.IEmpEmploye;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

public class ImpEmpagence implements IEmpEmploye {
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
}
