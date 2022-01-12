package RexProf.Repository;


import RexProf.Entity.Roles;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Roles,Long> {

}
