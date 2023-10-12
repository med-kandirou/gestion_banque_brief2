package DTO;

import java.time.LocalDate;
import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Empagence {

    private LocalDate datechangement;
    @NonNull private Employe employe;
    @NonNull private Agence agence;

}
