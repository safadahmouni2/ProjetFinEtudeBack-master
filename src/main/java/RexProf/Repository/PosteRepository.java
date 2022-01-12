package RexProf.Repository;


import RexProf.Entity.Ecole;
import RexProf.Entity.Poste;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface PosteRepository extends CrudRepository<Poste,Long> {
    @Query("select (e) from Poste e where e.name=:#{#name}")
    Ecole findByEName(@Param("name")String name);
    @Transactional
    @Modifying
    @Query("delete  from Poste e where e.competanceFiles.id=:#{#id}")
    void deleteCompetanceFiles(@Param("id")long id);
}
