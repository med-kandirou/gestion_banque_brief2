package DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Agence {
    private int code;
    @NonNull private String nom;
    @NonNull private String adresse;
    @NonNull private String telephone;

}
