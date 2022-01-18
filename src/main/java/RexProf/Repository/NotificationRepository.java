package RexProf.Repository;
import RexProf.Entity.Notification;
import RexProf.Entity.Users;
import RexProf.modelDto.NotificationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface NotificationRepository extends CrudRepository<Notification,Long>{

    //get number of notif unread for each user
    @Query("select distinct (count(n)) from Notification n  where n.user.id=:#{#id_user} AND n.isRead =false" )
    int countNotif(@Param("id_user") long id_user);

   // NotificationDto findByUser(Users user);
   // Notification findByUserAndId (Users user,Long id);
//get notification unread for each user
     @Query("select new RexProf.modelDto.NotificationDto (d.id,d.message,d.createdAt,d.isRead,d.userAbonne.name_user,d.userAbonne.first_name,d.userAbonne.picture,d.userAbonne.id) from Notification d where d.user.id=:#{#id} AND d.isRead =false order by d.createdAt desc")
     Page<NotificationDto> userNotification(@Param("id") Long id, Pageable pageable);

    //get all notification for each user
    @Query("select new RexProf.modelDto.NotificationDto (d.id,d.message,d.createdAt,d.isRead,d.userAbonne.name_user,d.userAbonne.first_name,d.userAbonne.picture,d.userAbonne.id) from Notification d where d.user.id=:#{#id} order by d.createdAt desc")
    List<NotificationDto> listNotification(@Param("id") Long id);




}
