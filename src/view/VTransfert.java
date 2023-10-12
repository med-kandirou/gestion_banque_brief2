package view;

import DAO.ImpTransfert;
import DTO.Affectation;
import DTO.Compte;
import DTO.Mission;
import DTO.Transfert;
import services.TransfertService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class VTransfert {
    ImpTransfert imp= new ImpTransfert();

    TransfertService service = new TransfertService(imp);
    Transfert transfert;

    Scanner sc= new Scanner(System.in);
    public void ajouter(){
        System.out.print("Code de l'envoyeur :");
        Compte c1= new Compte();
        c1.setCode(sc.nextLine());
        System.out.print("Code de recepteur :");
        Compte c2 = new Compte();
        c2.setCode(sc.nextLine());
        System.out.print("le prix :");
        double prix = sc.nextDouble();
        transfert = new Transfert(c1,c2,prix);
        Optional<Transfert> opt=service.ajouter(transfert);
        opt.ifPresent(val->{
            System.out.printf("TRANSFERT A ETE EFFECTUE AVEC SUCCES \n");
        });

    }

    public void supprimer(){
        System.out.print("code :");
        int code=sc.nextInt();
        boolean deleted=service.supprimer(code);
        if(deleted){
            System.out.printf("TRANSFERT SUPPRIME AVEC SUCCÈS \n");
        }
        else {
            System.out.printf("CETTE TRANSFERT AVEC CE CODE N'EXISTE PAS \n");
        }
    }
    public void trasactParDate(){
        System.out.print("DATE :");
        LocalDateTime dt= LocalDateTime.parse(sc.nextLine());
        List<Transfert> list= service.trasactParDate(dt);
        list.forEach(item -> {
            System.out.println("NUMERO : " + item.getNumero() + " Source : " + item.getSourceId().getCode() + " Destinataire : " + item.getDestinataireId().getCode() + " Montant " + item.getMontant());
        });
    }
}
