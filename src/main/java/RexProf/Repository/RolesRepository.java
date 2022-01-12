package RexProf.Repository;


import RexProf.Entity.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RolesRepository extends CrudRepository<Roles,Long> {
    @Query(value = "select (d) from Roles d where d.id=:#{#id}")
    Roles findbyId(@Param("id")long id);
    @Query(value = "select (d) from Roles d ")
    List<Roles> getAll();
    @Query("select (count(e)) from Roles e ")
    int findNBRRole();
    @Query("select (count(e)) from Roles e where e.condition=true")
    int findNBRRoleA();
    @Query("select (count(e)) from Roles e where e.condition=false")
    int findNBRRoleD();
    /*Optional<Roles> findByName(RoleName roleName);*/

}
