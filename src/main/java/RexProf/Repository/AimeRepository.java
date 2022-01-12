package RexProf.Repository;


import RexProf.Entity.Aime;
import RexProf.Entity.Groups;
import RexProf.Entity.Publications;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AimeRepository extends CrudRepository<Aime,Long> {
    @Query("select (count(e)) from Aime e where e.publications.id=:#{#id}")
    int findNBRAime(@Param("id")long id);
    @Transactional
    @Modifying
    @Query("delete  from Aime e where e.users.id=:#{#id} and e.publications.id=:#{#idP}")
    int deleteAimeByUser(@Param("id")long id,@Param("idP")long idP);
    @Query(value = "select (d) from Aime d where d.users.id=:#{#id}  ")
    Aime findByUser(@Param("id")long id);

    @Query(value = "select (d.users.id) from Aime d where d.publications.id=:#{#id}  ")
    List<Long> findLikesOfPub(@Param("id")long id);


}
