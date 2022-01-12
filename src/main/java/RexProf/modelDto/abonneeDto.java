package RexProf.modelDto;

import RexProf.Entity.Users;
import RexProf.Enum.AbonneeEtat;
import RexProf.Enum.CompeteEtat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Data
public class abonneeDto {
    private  Long id;
    private Long id_prestataire;
    private Long  id_abonnee;
    private Boolean etat;


}
