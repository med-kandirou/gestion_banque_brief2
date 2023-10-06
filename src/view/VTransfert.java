package view;

import DAO.ImpTransfert;
import DTO.Affectation;
import DTO.Compte;
import DTO.Mission;
import DTO.Transfert;
import services.TransfertService;

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
}
