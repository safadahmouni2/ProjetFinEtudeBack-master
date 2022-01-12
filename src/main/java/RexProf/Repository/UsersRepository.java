package RexProf.Repository;



import RexProf.Entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users,Long> {
    @Query("select (e) from Users e where e.email=:#{#email} and e.pwd=:#{#pwd}")
    List<Users> DoLogin(@Param("email")String email, @Param("pwd")String pwd);
    @Query("select (e) from Users e where e.email=:#{#email}")
    Users findByEMail(@Param("email")String email);
    @Query(value = "select (d) from Users d where d.id=:#{#id}")
    Users findbyId(@Param("id")long id);
    @Query(value = "select (d) from Users d order by d.date_birth desc ")
    List<Users> getAll();
    @Query("select (count(e)) from Users e ")
    int findNBR();
    @Query("select (count(e)) from Users e where e.etat=0")
    int findNBRUserA();
    @Query("select (count(e)) from Users e where e.etat=1")
    int findNBRUserD();
    @Query("select (count(e)) from Users e where e.etat=2")
    int findNBRUserB();
    @Query("SELECT user FROM Users user where user.name_user like %?1%")
    List<Users> findByNameLike(String name);
   /* Optional<Users> findByEmail(String email);

    Optional<Users> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);*/
}
