package DTO;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Transfert {
    private int numero;
    @NonNull private Compte sourceId;
    @NonNull private Compte destinataireId;
    @NonNull private double montant;
    private LocalDateTime date;
}
