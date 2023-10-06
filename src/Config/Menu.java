package Config;

import view.*;

import java.util.Scanner;

public class Menu {
    VEmploye vEmploye = new VEmploye();
    VClient vClient = new VClient();
    VMission vMission =new VMission();
    VCompte vCompte =new VCompte();
    VAffectation vAffectation =new VAffectation();
    VOperation vOperation =new VOperation();
    VAgence vAgence =new VAgence();

    VEmpAgence vEmpAgence =new VEmpAgence();
    VTransfert vTransfert =new VTransfert();
    public void menu(){
        boolean quitter=false;
        System.out.printf("Welcome to EasyBank!");
        do {
            System.out.println("Veuillez choisir une option: ");
            System.out.println("1. Administration des employés");
            System.out.println("2. Administration des clients");
            System.out.println("3. Administration des comptes");
            System.out.println("4. Administration des Opérations");
            System.out.println("5. Administration des missions");
            System.out.println("6. Administration des agence");
            System.out.println("7. Administration des agence employes");
            System.out.println("8. Administration des transferts");
            System.out.println("9. Quitter");
            System.out.println("Votre choix: ");
            //get the user input
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("Veuillez choisir une option: ");
                        System.out.println("1. Ajouter un employé");
                        System.out.println("2. Modifier un employé");
                        System.out.println("3. Supprimer un employé");
                        System.out.println("4. Afficher tous les employés");
                        System.out.println("5. Chercher un employé par matricule");
                        System.out.println("6. Chercher un employé");
                        System.out.println("7. Retour");
                        System.out.println("Votre choix: ");
                        Scanner sc1 = new Scanner(System.in);
                        int choice1 = sc1.nextInt();
                        switch (choice1) {
                            case 1:
                                vEmploye.ajouterEmploye();
                                break;
                            case 2:
                                System.out.println("Modifier un employé");
                                break;
                            case 3:
                                vEmploye.supprierEmploye();
                                break;
                            case 4:
                                vEmploye.afficherListe();
                                break;
                            case 5:
                                vEmploye.chercherEmploye();
                                break;
                            case 6:
                                vEmploye.chercherParAtt();
                                break;
                            case 7:
                                System.out.println("Retour");
                                break;
                            default:
                                System.out.println("Choix invalide");
                                break;
                        }
                        if (choice1 == 7) {
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("< Administration des clients >");
                    while (true){
                        System.out.println("Veuillez choisir une option: ");
                        System.out.println("1. Ajouter un client");
                        System.out.println("2. Modifier un client");
                        System.out.println("3. Supprimer un client");
                        System.out.println("4. Afficher tous les clients");
                        System.out.println("5. Chercher un client par code");
                        System.out.println("6. Chercher un client");
                        System.out.println("7. Retour");
                        System.out.println("Votre choix: ");
                        Scanner sc2 = new Scanner(System.in);
                        int choice2 = sc2.nextInt();
                        switch (choice2) {
                            case 1:
                                vClient.ajouterClient();
                                break;
                            case 2:
                                System.out.println("Modifier un client");
                                break;
                            case 3:
                                vClient.supprierClient();
                                break;
                            case 4:
                                vClient.afficherListe();
                                break;
                            case 5:
                                vClient.chercherClientParCode();
                                break;
                            case 6:
                                vClient.chercherParAtt();
                                break;
                            case 7:
                                System.out.println("Retour");
                                break;
                            default:
                                System.out.println("Choix invalide");
                                break;
                        }
                        if (choice2 == 7) {
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("< Administration des comptes >");
                    do {
                        System.out.println("Veuillez choisir une option: ");
                        System.out.println("1. Ajouter un compte");
                        System.out.println("2. Modifier un compte");
                        System.out.println("3. Changement de statut");
                        System.out.println("4. Supprimer un compte");
                        System.out.println("5. Afficher tous les comptes");
                        System.out.println("6. Afficher les comptes par statut");
                        System.out.println("7. Afficher les comptes par Date de création");
                        System.out.println("8. Chercher un compte par client");
                        System.out.println("9. Chercher un compte par numéro d'opération");
                        System.out.println("10. Retour");
                        System.out.println("Votre choix: ");
                        Scanner sc3 = new Scanner(System.in);
                        int choice3 = sc3.nextInt();
                        switch (choice3) {
                            case 1:
                                System.out.println("1-Courant\n2-Epargne");
                                System.out.println("choix");
                                int choix = sc.nextInt();
                                vCompte.ajouterCompte(choix);
                                break;
                            case 2:
                                System.out.println("Modifier un compte");
                                break;
                            case 3:
                                System.out.println("Changement de statut");
                                break;
                            case 4:
                                vCompte.supprierCompte();
                                break;
                            case 5:
                                vCompte.afficherList();
                                break;
                            case 6:
                                vCompte.afficherParStatut();
                                break;
                            case 7:
                                vCompte.afficherPardateCreation();
                                break;
                            case 8:
                                vCompte.rechercheCompteParClient();
                                break;
                            case 9:
                                System.out.println("Chercher un compte par numéro d'opération");
                                break;
                            case 10:
                                System.out.println("Retour");
                                break;
                            default:
                                System.out.println("Choix invalide");
                                break;
                        }
                        if (choice3 == 10) {
                            break;
                        }
                    }while (true);
                    break;
                case 4:
                    System.out.println("< Administration des Opérations >");
                    while (true){
                        System.out.println("Veuillez choisir une option: ");
                        System.out.println("1. Ajouter une opération");
                        System.out.println("2. Supprimer une opération");
                        System.out.println("3. Chercher une opération par numéro");
                        System.out.println("4. Retour");
                        System.out.println("Votre choix: ");
                        //get the user input
                        Scanner sc4 = new Scanner(System.in);
                        int choice4 = sc4.nextInt();
                        switch (choice4) {
                            case 1:
                                vOperation.ajouterOperation();
                                break;
                            case 2:
                                vOperation.supprierEmploye();
                                break;
                            case 3:
                                vOperation.chercherbyNum();
                                break;
                            case 4:
                                System.out.println("Retour");
                                break;
                            default:
                                System.out.println("Choix invalide");
                                break;
                        }
                        if (choice4 == 4) {
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println(" < Administration des missions >");
                    while (true){
                        System.out.println("Veuillez choisir une option: ");
                        System.out.println("1. Ajouter une mission");
                        System.out.println("2. Supprimer une mission");
                        System.out.println("3. Afficher toutes les missions");
                        System.out.println("4. Ajouter nouvelle affectation");
                        System.out.println("5. Supprimer une affectation");
                        System.out.println("6. Afficher l'historique des affectations d'une employé");
                        System.out.println("7. Statistiques des affectations");
                        System.out.println("8. Retour");
                        System.out.println("Votre choix: ");
                        //get the user input
                        Scanner sc5 = new Scanner(System.in);
                        int choice5 = sc5.nextInt();
                        switch (choice5) {
                            case 1:
                                vMission.ajouterMission();
                                break;
                            case 2:
                                vMission.supprimerMission();
                                break;
                            case 3:
                                vMission.afficherListe();
                                break;
                            case 4:
                                vAffectation.ajouterMission();
                                break;
                            case 5:
                                vAffectation.supprimerMission();
                                break;
                            case 6:
                                vAffectation.Historique();
                                break;
                            case 7:
                                vAffectation.statistique();
                                break;
                            case 8:
                                System.out.println("Retour");
                                break;
                            default:
                                System.out.println("Choix invalide");
                                break;
                        }
                        if (choice5 == 8) {
                            break;
                        }
                    }
                    break;
                case 6:
                    while (true) {
                        System.out.println("Veuillez choisir une option: ");
                        System.out.println("1. Ajouter une Agence");
                        System.out.println("2. Modifier un employé");
                        System.out.println("3. Supprimer unae agence");
                        System.out.println("4. Chercher une agence par code");
                        System.out.println("5. Chercher une agence par adresse");
                        System.out.println("6. afficher la liste des contact");
                        System.out.println("7. afficher la liste des contact");
                        System.out.println("8. chercher une agence par employe");
                        System.out.println("Votre choix: ");
                        Scanner sc1 = new Scanner(System.in);
                        int choice1 = sc1.nextInt();
                        switch (choice1) {
                            case 1:
                                vAgence.ajouter();
                                break;
                            case 2:
                                vAgence.update();
                                break;
                            case 3:
                                vAgence.supprimer();
                                break;
                            case 4:
                                vAgence.rechercherParCode();
                                break;
                            case 5:
                                vAgence.rechercherParAdresse();
                                break;
                            case 6:
                                vAgence.afficheContacts();
                                break;
                            case 7:
                                //vAgence.afficheContacts();
                                break;
                            default:
                                System.out.println("Choix invalide");
                                break;
                        }
                    }
                case 7:
                    while (true) {
                        System.out.println("Veuillez choisir une option: ");
                        System.out.println("1. Affecter un employe a une agence");
                        System.out.println("2. Mutter un employé");
                        System.out.println("3. Historique des affectations");
                        System.out.println("Votre choix: ");
                        Scanner sc1 = new Scanner(System.in);
                        int choice1 = sc1.nextInt();
                        switch (choice1) {
                            case 1:
                                vEmpAgence.affecter();
                                break;
                            case 2:
                                System.out.println("Modifier un employé");
                                break;
                            case 3:
                                vEmpAgence.statistique();
                                break;
                            default:
                                System.out.println("Choix invalide");
                                break;
                        }
                    }
                case 8:
                    while (true) {
                        System.out.println("Veuillez choisir une option: ");
                        System.out.println("1. Affecter une transaction");
                        System.out.println("2. supprimer une transaction");
                        System.out.println("3. Afficher la liste des transactions");
                        System.out.println("Votre choix: ");
                        Scanner sc1 = new Scanner(System.in);
                        int choice1 = sc1.nextInt();
                        switch (choice1) {
                            case 1:
                                vTransfert.ajouter();
                                break;
                            case 2:
                                System.out.println("Modifier un employé");
                                break;
                            case 3:
                                vEmpAgence.statistique();
                                break;
                            default:
                                System.out.println("Choix invalide");
                                break;
                        }
                    }
            }
        }while (quitter==false);
    }
}
