package RexProf.Repository;


import RexProf.Entity.Postule;
import RexProf.Entity.ServiceRequest;
import RexProf.modelDto.PostuleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostuleRepository extends CrudRepository<Postule,Long> {

//Users.competanceFiles=d.competanceFiles and
    @Query(value = "select d from Postule d  where  d.competanceFiles.users.id=:#{#id}")
    Page<Postule> getMesPostule(@Param("id")long id, Pageable pageable);
   /* @Query(value = "select d from Postule d  where  d.serviceRequest.id=:#{#id}")
    Page<Postule> getCvOfPost(@Param("id")long id, Pageable pageable);*/
    @Query(value = "select d,m from Postule d JOIN matchingOffre m ON d.serviceRequest.id = m.serviceRequest.id "
            + " where d.competanceFiles.users.id=m.users.id  and d.serviceRequest.id=:#{#id}")
    List<Object[]> getCvOfPost(@Param("id")long id);
}
