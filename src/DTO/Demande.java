package DTO;


import java.time.LocalDate;

import Enums.demandeEtat;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Demande {
    private int numero;
    @NonNull private demandeEtat etat;
    @NonNull private Simulation simulation;
    @NonNull private String remarques;
    @NonNull private LocalDate date;
    @NonNull private Client client;
}
