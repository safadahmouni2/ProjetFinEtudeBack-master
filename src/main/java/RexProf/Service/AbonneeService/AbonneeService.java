package RexProf.Service.AbonneeService;

import RexProf.Entity.Abonnee;
import RexProf.Entity.Users;
import RexProf.Repository.AbonneeRepository;

import RexProf.Repository.UsersRepository;
import RexProf.modelDto.abonneeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonneeService implements IAbonneeService{
    @Autowired
    AbonneeRepository abonneeRepository;
@Autowired
UsersRepository usersRepository;
//get count  abonnements
    @Override
    public int countAbonnements(long id_abonnee) {
        return abonneeRepository.countAbonnements(id_abonnee);
    }
//get count abonnés
    @Override
    public int countAbonnees(long id_prestataire) {
        return abonneeRepository.countAbonnees(id_prestataire);
    }

    /*@Override
    public void addAbonnee(long id_prestataire, long id_abonnee) {
        Users users=usersRepository.findbyId(id_prestataire);
        users.set(users.getId());
        abonnee.setUsers1(usersRepository.findById(id_prestataire.getId_prestataire()).get());
        abonnee.setUsers2(usersRepository.findById(getId_abonnee()).get());

        abonneeRepository.save(abonnee);}*/

    @Override
    public void addAbonnee(abonneeDto ab) {
        Abonnee abonnee=new Abonnee();
        abonnee.setUsers1(usersRepository.findById(ab.getId_prestataire()).get());
        abonnee.setUsers2(usersRepository.findById(ab.getId_abonnee()).get());
        abonnee.setEtat(true);
        abonneeRepository.save(abonnee);
    }
// get etat abonnement
    @Override
    public Boolean getEtatAbonnement(long id_prestataire ,long id_abonnee) {
   return abonneeRepository.getEtatAbonnement(id_prestataire,id_abonnee);

    }
    // get etat abonne
    @Override
    public Boolean getEtatAbonne(long id_abonnee, long id_prestataire) {
        return abonneeRepository.getEtatAbonnement(id_abonnee,id_prestataire);
    }

    // get list abonnement
    @Override
    public List<Users> gettAllAbonnement(long id_abonnee) {
        return abonneeRepository.getAllAbonnements(id_abonnee);
    }
    // get list abonnes
    @Override
    public List<Users> getAllAbonnes(long id_prestataire) {
        return abonneeRepository.getAllAbonnes(id_prestataire);
    }


}
