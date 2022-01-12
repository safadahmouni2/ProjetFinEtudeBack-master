package RexProf.Repository;

import RexProf.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    //Optional<Users> findByUsername(String name_user);
    Optional<Users> findByLogin(String login);
   // Boolean existsByUsername(String name_user);
    Boolean existsByLogin(String login);


}