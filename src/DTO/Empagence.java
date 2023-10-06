package DTO;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Empagence {

    private Date datechangement;
    @NonNull private Employe employe;
    @NonNull private Agence agence;

}
