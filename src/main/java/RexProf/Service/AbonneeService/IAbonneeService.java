package RexProf.Service.AbonneeService;

import RexProf.Entity.Abonnee;
import RexProf.Entity.Users;
import RexProf.modelDto.abonneeDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAbonneeService {
    int countAbonnements(long id_abonnee);
    int  countAbonnees(long id_prestataire);

   void addAbonnee(abonneeDto ab);
    Boolean getEtatAbonnement(long id_prestataire, long id_abonnee);
    Boolean getEtatAbonne(long id_abonnee , long id_prestataire);
    List<Users> gettAllAbonnement(long id_abonnee);
    List<Users> getAllAbonnes(long id_prestataire);

    void deleteAbonnee ( Long id_abonnee,long id_prestataire);
}
