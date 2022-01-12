package RexProf.Repository;


import RexProf.Entity.Languages;
import RexProf.Entity.Roles;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface LanguagesRepository extends CrudRepository<Languages,Long> {
    @Transactional
    @Modifying
    @Query("delete  from Languages e where e.competanceFiles.id=:#{#id}")
    void deleteLangues(@Param("id")long id);
}
