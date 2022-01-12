package RexProf.Repository;


import RexProf.Entity.matchingOffre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MatchingRepository extends CrudRepository<matchingOffre,Long> {
    @Query(value = "select (d) from matchingOffre d  ")
    public Page<matchingOffre> findAll(Pageable pageable);
    @Query(value = "select d.serviceRequest from matchingOffre d where d.users.id=:#{#id} order by d.serviceRequest.start_date desc  ")
    Page<matchingOffre> getMesDemMatche(@Param("id")long id,Pageable pageable);

   }
