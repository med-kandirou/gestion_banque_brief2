package DTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Transfert {
    private int numero;
    @NonNull private Compte sourceId;
    @NonNull private Compte destinataireId;
    @NonNull private double montant;
    private LocalDate date;
}
