package RexProf.Service.NotificationService;

import RexProf.Entity.Notification;
import RexProf.Entity.Users;
import RexProf.Repository.NotificationRepository;
import RexProf.Repository.UsersRepository;
import RexProf.modelDto.NotificationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService implements INotificationService{
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    UsersRepository usersRepository;

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);



    @Override
    public List<Notification> userNotification(Long id, Integer pageNo, Integer pageSize) {
        PageRequest paging = PageRequest.of(pageNo, pageSize);

        try{

            return notificationRepository.userNotification(usersRepository.findbyId(id).getId(),paging);

        }catch (Exception e) {
            logger.error("Exception occur while fetch Notification by User ",e);
            return null;
        }
    }

    @Override
        public Notification findByUserAndId (Users user,Long id){
        try{
            return notificationRepository.findByUserAndId(user,id);
        }catch (Exception e) {
            logger.error("Exception occur while fetch Notification by User and Notification Id ",e);
            return null;
        }
    }

    @Override
    public List<Notification> gettAllNotification(long id_user) {
           return notificationRepository.getAllNotifications(id_user);
        }

    @Override
    public Notification save(Notification notification){
        try{
            return notificationRepository.save(notification);
        }catch (Exception e) {
            logger.error("Exception occur while save Notification ",e);
            return null;
        }
    }

  /*  @Override
    public void save(NotificationDto notif) {
        Notification notification=new Notification();
       // abonnee.setUsers1(usersRepository.findById(ab.getId_prestataire()).get());
        notification.setUser(usersRepository.findById(notif.getUser().getId()));
        notification.setRead(false);
        notificationRepository.save(notification);
    }*/

  @Override
    public NotificationDto findByUser(Users user){
        try{
            return notificationRepository.findByUser(user);
        }catch (Exception e) {
            logger.error("Exception occur while fetch Notification by User ",e);
            return null;
        }
    }


}

