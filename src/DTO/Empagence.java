package DTO;

import java.util.Date;

public class Empagence {

    private Date datechangement;
    private Employe employe;
    private Agence agence;

    public Empagence() {}

    public Date getDatechangement() {
        return datechangement;
    }

    public void setDatechangement(Date datechangement) {
        this.datechangement = datechangement;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
}
