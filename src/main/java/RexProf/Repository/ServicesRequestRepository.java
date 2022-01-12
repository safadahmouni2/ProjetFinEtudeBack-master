package RexProf.Repository;


import RexProf.Entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicesRequestRepository extends CrudRepository<ServiceRequest,Long> {
    @Query(value = "select (d) from ServiceRequest d where  d.closing_date >= current_date  order by d.dateCreation desc ")
    public Page<ServiceRequest> findAll(Pageable pageable);
    @Query(value = "select (d) from ServiceRequest d where d.id=:#{#id}")
    ServiceRequest findbyId(@Param("id")long id);
    @Query(value = "select (d) from ServiceRequest d where d.user.id=:#{#id} order by d.start_date desc  ")
    Page<ServiceRequest> getMesDem(@Param("id")long id,Pageable pageable);
    @Query(value = "select d.id from ServiceRequest d where d.id=:#{#id}")
    int findIdDemande(@Param("id")long id);

}
