package RexProf.Repository;


import RexProf.Entity.Roles;
import RexProf.Entity.Skills;
import RexProf.Entity.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface SkillsRepository extends CrudRepository<Skills,Long> {
    @Query("select (e) from Skills e where e.name=:#{#name}")
    Skills findByEName(@Param("name")String name);
    @Transactional
    @Modifying
    @Query("delete  from Skills e where e.competanceFiles.id=:#{#id}")
    void deleteCompetanceFiles(@Param("id")long id);
    @Query("select name from Skills d where d.competanceFiles.id=:#{#id}")
    List<String> findskills(@Param("id") long id);

}
