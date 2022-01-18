package RexProf.Repository;

import RexProf.Entity.Abonnee;
import RexProf.Entity.CompetanceFiles;
import RexProf.Entity.Groups;
import RexProf.Entity.Users;
import RexProf.modelDto.abonneeDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AbonneeRepository extends CrudRepository<Abonnee, Long> {
    //get number of abonnee for each user
    @Query("select distinct (count(ab)) from Abonnee ab  where ab.users2.id=:#{#id_abonnee}")
    int countAbonnements(@Param("id_abonnee") long id);

    //get number of abonnements for each user
    @Query("select distinct (count(ab)) from Abonnee ab  where ab.users1.id=:#{#id_prestataire}")
    int  countAbonnees(@Param("id_prestataire") long id);

//getEtat abonnement
    @Query("select d.etat from Abonnee d where d.users1.id=:#{#id_prestataire} and d.users2.id=:#{#id_abonnee} ")
    Boolean getEtatAbonnement(@Param("id_prestataire") long id_prestataire,@Param("id_abonnee") Long id_abonnee);

    //getEtat abonne
    @Query("select d.etat from Abonnee d where d.users1.id=:#{#id_prestataire} and d.users2.id=:#{#id_abonnee} ")
    Boolean getEtatAbonne(@Param("id_abonnee") Long id_abonnee,@Param("id_prestataire") long id_prestataire);


//get list abonnement
    @Query("select  distinct  d.users1  from Abonnee d where  d.users2.id=:#{#id_abonnee} ")
    List<Users> getAllAbonnements(@Param("id_abonnee") long id);

    //get list abonnes
    @Query("select  distinct  d.users2  from Abonnee d where  d.users1.id=:#{#id_prestataire} ")
    List<Users> getAllAbonnes(@Param("id_prestataire") long id);

   /*@Query("select d.id, d.users2.id from Abonnee d")
    List<Abonnee>  getAllAbonnee();*/

  /* @Query("select  distinct new RexProf.modelDto.abonneeDto ( d.users2.id) from Abonnee d where d.users1.id=:#{#id_prestataire}")
    List<abonneeDto> getAllAbonnee(@Param("id_prestataire") long id);*/

    //delete abonnement
    @Transactional
    @Modifying
    @Query("delete from Abonnee ab where   ab.users2.id=:#{#id_abonnee} and ab.users1.id=:#{#id_prestataire}")
    void deleteAbonnee (@Param("id_abonnee") Long id_abonnee,@Param("id_prestataire") long id_prestataire);
}
