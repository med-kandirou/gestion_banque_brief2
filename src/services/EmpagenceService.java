package services;

import DAO.ImpEmpagence;
import DTO.Agence;
import DTO.Empagence;

import java.util.List;
import java.util.Optional;

public class EmpagenceService {

    private ImpEmpagence impEmpagence;
    public EmpagenceService(ImpEmpagence impEmpagence){
        this.impEmpagence=impEmpagence;
    }

    public boolean affecter(Empagence empagence) {
        int affectered = impEmpagence.affecter(empagence);
        if (affectered==1) {
            return true;
        } else {
            return false;
        }
    }

    public List<Empagence> statistique() {
        List<Empagence> stats = impEmpagence.statistique();
        return stats;
    }
}
