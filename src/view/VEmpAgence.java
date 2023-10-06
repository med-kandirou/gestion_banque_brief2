package view;

import DAO.ImpEmpagence;
import DTO.Agence;
import DTO.Empagence;
import DTO.Employe;
import lombok.NonNull;
import services.EmpagenceService;

import java.util.Scanner;

public class VEmpAgence {
    ImpEmpagence imp =new ImpEmpagence();
    EmpagenceService empagenceService= new EmpagenceService(imp);
    Scanner sc = new Scanner(System.in);
    Empagence empagence;
    public void affecter(){
        System.out.print("le code d'employe :");
        String codeEmp=sc.nextLine();
        System.out.print("le code d'agence :");
        int codeAgence=sc.nextInt();
        Employe emp= new Employe();
        emp.setMatricule(codeEmp);
        Agence agence= new Agence();
        agence.setCode(codeAgence);
        empagence = new Empagence(emp,agence);
        boolean added=empagenceService.affecter(empagence);
        if(added){
            System.out.printf("EMPLOYE AFFECTE AVEC SUCCÈS \n");
        }else{
            System.out.printf("ERROR EST PRODUIT \n");
        }
    }
}
