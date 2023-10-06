package view;

import DAO.ImpAgence;
import DTO.Agence;
import DTO.Client;
import DTO.Empagence;
import services.AgenceService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public void rechercherParAdresse(){
        System.out.print("adresse :");
        String adresse=sc.nextLine();
        Optional<Agence>opt=agenceService.rechercheParAdresse(adresse);
        opt.ifPresentOrElse(
                valeur -> System.out.print(valeur.getCode()+" "+valeur.getNom()+" "+valeur.getAdresse()+" "+valeur.getTelephone()+"\n"),
                () -> System.out.println("CETTE AGENCE N'EXISTE PAS")
        );
    }

    public void afficheContacts(){
        HashMap<String, String> contacts=agenceService.AfficheContact();
        contacts.forEach((key, value) -> {
            System.out.println("Adresse: " + key + ", Telephone: " + value);
        });
    }

    public void update(){
        System.out.print("code :");
        int code=sc.nextInt();
        Optional<Agence>opt=agenceService.rechercheParCode(code);
        opt.ifPresentOrElse(
                valeur -> System.out.print(valeur.getCode()+" "+valeur.getNom()+" "+valeur.getAdresse()+" "+valeur.getTelephone()+"\n"),
                () -> System.out.println("CETTE AGENCE N'EXISTE PAS")
        );
        Agence ag= opt.get();
        System.out.print("Modifier le nom d'agence (enter pour laisser la valeur) :");
        String nom=sc.next();
        if(!nom.isEmpty()){
            ag.setNom(nom);
        }
        System.out.print("Modifier l'adresse d'agence (enter pour laisser la valeur) :");
        String adresse=sc.next();
        if(!adresse.isEmpty()){
            ag.setAdresse(adresse);
        }
        System.out.print("Modifier le tele d'agence (enter pour laisser la valeur) :");
        String tele=sc.next();
        if(!tele.isEmpty()){
            ag.setAdresse(tele);
        }
        Optional<Agence> agence= agenceService.update(ag);
        agence.ifPresent(val->{
            System.out.printf("L'AGENCE A ETE MODIFIE");
        });
    }
}
