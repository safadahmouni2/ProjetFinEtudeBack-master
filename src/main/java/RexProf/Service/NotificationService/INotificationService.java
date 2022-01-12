package RexProf.Service.NotificationService;

import RexProf.Entity.Notification;
import RexProf.Entity.Users;
import RexProf.modelDto.NotificationDto;

import java.util.List;

public interface INotificationService {
    List<Notification> userNotification(Long id, Integer pageNo, Integer pageSize);
    Notification findByUserAndId(Users user, Long id);
   // void save(NotificationDto notification);
   List<Notification> gettAllNotification(long id_user);

    Notification save(Notification notification);
    NotificationDto findByUser(Users user);
}


