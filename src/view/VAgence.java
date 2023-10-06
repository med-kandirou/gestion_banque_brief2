package view;

import DAO.ImpAgence;
import DTO.Agence;
import DTO.Client;
import services.AgenceService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class VAgence {
    ImpAgence impag = new ImpAgence();
    AgenceService agenceService= new AgenceService(impag);
    Scanner sc = new Scanner(System.in);
    Agence agence;
    public void ajouter(){
        System.out.print("nom :");
        String nom=sc.nextLine();
        System.out.print("Adresse :");
        String adresse=sc.nextLine();
        System.out.print("Telephone :");
        String telephone=sc.nextLine();
        agence = new Agence(nom,adresse,telephone);
        boolean added=agenceService.ajouter(agence);
        if(added){
            System.out.printf("AGENCE AJOUTÉE AVEC SUCCÈS \n");
        }else{
            System.out.printf("ERROR EST PRODUIT \n");
        }
    }
    public void supprimer(){
        System.out.print("code :");
        int code=sc.nextInt();
        boolean deleted=agenceService.supprimer(code);
        if(deleted){
            System.out.printf("AGENCE SUPPRIME AVEC SUCCÈS \n");
        }
        else {
            System.out.printf("CETTE AGENCE AVEC CE CODE N'EXISTE PAS \n");
        }
    }

    public void rechercherParCode(){
        System.out.print("code :");
        int code=sc.nextInt();
        Optional<Agence>opt=agenceService.rechercheParCode(code);
        opt.ifPresentOrElse(
                valeur -> System.out.print(valeur.getCode()+" "+valeur.getNom()+" "+valeur.getAdresse()+" "+valeur.getTelephone()+"\n"),
                () -> System.out.println("CETTE AGENCE N'EXISTE PAS")
        );
    }
}
