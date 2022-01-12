package RexProf.Repository;


import RexProf.Entity.Groups;
import RexProf.Entity.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface GroupsRepository extends CrudRepository<Groups,Long> {
    @Query("select (count(e)) from Groups e ")
    int findNBRGroupe();
    @Query(value = "select (d) from Groups d where d.id=:#{#id}")
    Groups findbyId(@Param("id")long id);
    @Query(value = "select (d) from Groups d ")
    List<Groups> getAll();
    @Query("select (count(e)) from Groups e where e.condition=true")
    int findNBRGroupA();
    @Query("select (count(e)) from Groups e where e.condition=false")
    int findNBRGroupD();
    @Query(nativeQuery = true, value="select groups_id from groups_users   where users_id=:#{#id}")
   // @Query(nativeQuery = true,value = "select * from groups_users  where users_id='"++"'")
    List<Groups> findbyUserid(@Param("id")long id);
}
