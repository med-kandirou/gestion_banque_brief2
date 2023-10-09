package view;

import DAO.ImpDemande;
import DAO.ImpTransfert;
import DTO.Client;
import DTO.Demande;
import DTO.Simulation;
import DTO.Transfert;
import services.TransfertService;
import services.demandeService;

import java.util.Optional;
import java.util.Scanner;

public class VSimulation {

    Scanner sc= new Scanner(System.in);
    ImpDemande imp= new ImpDemande();
    demandeService service = new demandeService(imp);
    Demande demande;
    public void simuler(){
        System.out.printf("le Capitale : ");
        Double capitale=sc.nextDouble();
        System.out.printf("le Taux : ");
        Double taux=sc.nextDouble();
        System.out.printf("le Nombre mensualité : ");
        int nombremensualité=sc.nextInt();
        double tauxMensuel = (taux / 12) / 100;
        double mensualite = (capitale * tauxMensuel * Math.pow(1 + tauxMensuel, nombremensualité))
                / (Math.pow(1 + tauxMensuel, nombremensualité) - 1);
        System.out.printf("La mensualité est d'environ %.2f euros par mois.%n", mensualite);
        System.out.printf("1-Confirmer\n2-abondonner");
        int choix = sc.nextInt();
        if(choix==1){
            demande= new Demande();
            Simulation s= new Simulation(capitale,taux,nombremensualité);
            demande.setSimulation(s);
            System.out.printf("entrer le code d'un client : ");
            Client c= new Client();
            c.setCode(sc.next());
            demande.setClient(c);
            System.out.printf("Remarque : ");
            demande.setRemarques(sc.nextLine());
            boolean optDm=service.ajouter(demande);
            if(optDm)
            {
                System.out.printf("Le demande a ete bien traite et enregistré\n");
            }
        }
    }
}
