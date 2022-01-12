package RexProf.Repository;


import RexProf.Entity.Aime;
import RexProf.Entity.Commentaire;
import RexProf.Entity.Publications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CommentRepository extends CrudRepository<Commentaire,Long> {

    @Query(value = "select (d) from Commentaire d where d.publications.id=:#{#id} order by d.date desc ")
    Page<Commentaire> getComment(@Param("id")long id, Pageable pageable);
}
