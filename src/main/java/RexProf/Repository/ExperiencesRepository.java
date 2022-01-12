package RexProf.Repository;


import RexProf.Entity.Experiences;
import RexProf.Entity.Roles;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ExperiencesRepository extends CrudRepository<Experiences,Long> {
    @Transactional
    @Modifying
    @Query("delete  from Experiences e where e.competanceFiles.id=:#{#id}")
    void deleteExperience(@Param("id")long id);
}
