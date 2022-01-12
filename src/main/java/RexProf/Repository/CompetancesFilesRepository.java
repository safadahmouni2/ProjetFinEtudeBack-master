package RexProf.Repository;


import RexProf.Entity.CompetanceFiles;
import RexProf.Entity.Roles;
import RexProf.Entity.Skills;
import RexProf.modelDto.CompetanceFilesSkillsDto;
import RexProf.modelDto.CompetanceFilesWithSkillsDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompetancesFilesRepository extends CrudRepository<CompetanceFiles,Long> {
    @Query(value = "select (d) from CompetanceFiles d where d.id=:#{#id}")
    CompetanceFiles findbyId(@Param("id")long id);


    @Query(value = "select (d) from CompetanceFiles d where d.users.id=:#{#id} order by d.date desc ")
    List<CompetanceFiles> getMine(@Param("id")long id);


    @Query(value = "select d from CompetanceFiles d  ")
    List<CompetanceFiles> getALl();
}
