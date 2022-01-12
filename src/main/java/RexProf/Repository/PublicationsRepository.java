package RexProf.Repository;


import RexProf.Entity.CompetanceFiles;
import RexProf.Entity.Publications;
import RexProf.Entity.Roles;
import RexProf.Entity.Users;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PublicationsRepository extends CrudRepository<Publications,Long> {
    @Query(value = "select (d) from Publications d where d.id=:#{#id}")
    Publications findbyId(@Param("id")long id);
    @Query(value = "select (d) from Publications d ")
    List<Publications> getAll();
    @Query(value = "select (d) from Publications d where d.signaler<5 order by d.start_date desc ")
    public Page<Publications> findAll(Pageable pageable);
    @Query(value = "select (d) from Publications d where d.users.id=:#{#id} order by d.start_date desc ")
    Page<Publications> getMesPub(@Param("id")long id,Pageable pageable);
    public static final String FIND_PROJECTS = "select image from Publications d where d.users.id=:#{#id} order by d.start_date desc ";
    @Query(value = "select (d) from Publications d where d.id=:#{#id}  ")
    Publications findByUser(@Param("id")long id);

}
