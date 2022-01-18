package RexProf.Service.NotificationService;

import RexProf.Entity.Notification;
import RexProf.Entity.Users;
import RexProf.modelDto.NotificationDto;
import RexProf.modelDto.UsersDto;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface INotificationService {
    int countNotif(Long id_user);
    //get notification unread for each user
    List<NotificationDto> userNotification(Long id, Integer pageNo, Integer pageSize);


    //get all notification for each user
    List<NotificationDto> listNotification(Long id);
   void isRead(long id);

    Notification save(Notification notification);
    void UpdateNotification(Long id, boolean read)throws IOException;
}


