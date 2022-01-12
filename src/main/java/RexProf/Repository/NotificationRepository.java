package RexProf.Repository;
import RexProf.Entity.Notification;
import RexProf.Entity.Users;
import RexProf.modelDto.NotificationDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface NotificationRepository extends CrudRepository<Notification,Long>{
        NotificationDto findByUser(Users user);

       @Query("select (n) from Notification n where n.user.id=:#{#id} order by n.createdAt desc")
       List<Notification> userNotification(@Param("id") Long id, Pageable pageable);


        Notification findByUserAndId (Users user,Long id);
    //get list Notification
    @Query("select n  from Notification n where n.user.id=:#{#id_user} order by n.createdAt desc")
    List<Notification> getAllNotifications(@Param("id_user") long id);




}
