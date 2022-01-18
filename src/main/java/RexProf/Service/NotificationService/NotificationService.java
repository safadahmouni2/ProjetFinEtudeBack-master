package RexProf.Service.NotificationService;

import RexProf.Entity.Commentaire;
import RexProf.Entity.Notification;
import RexProf.Entity.Publications;
import RexProf.Entity.Users;
import RexProf.Repository.NotificationRepository;
import RexProf.Repository.UsersRepository;
import RexProf.modelDto.NotificationDto;
import RexProf.modelDto.PublicationsDto;
import RexProf.modelDto.UsersDto;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class NotificationService implements INotificationService{
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    UsersRepository usersRepository;

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    //get number of notif unread for each user
    @Override
    public int countNotif(Long id_user) {

            return notificationRepository.countNotif(id_user);
        }



    /*@Override
        public List<NotificationDto> userNotification(Long id, Integer pageNo, Integer pageSize) {
            PageRequest paging = PageRequest.of(pageNo, pageSize);
            return (notificationRepository.userNotification(usersRepository.findbyId(id).getId(),paging).stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        }
    */
    @Override
    public List<NotificationDto> userNotification(Long id, Integer pageNo, Integer pageSize) {
        PageRequest paging = PageRequest.of(pageNo, pageSize);

           Page<NotificationDto> pagedResult=
                     notificationRepository.userNotification(id,paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<NotificationDto>();
        }
    }

   /* @Override
        public Notification findByUserAndId (Users user,Long id){
        try{
            return notificationRepository.findByUserAndId(user,id);
        }catch (Exception e) {
            logger.error("Exception occur while fetch Notification by User and Notification Id ",e);
            return null;
        }
    }*/

    @Override
    public List<NotificationDto> listNotification(Long id) {

        return notificationRepository.listNotification(id);
    }

    @Override
    public void isRead(long id) {
        Notification notif=notificationRepository.findById(id).get();
        notif.setRead(true);
        notif= notificationRepository.save(notif);

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
//update notification
    @Override
    public void UpdateNotification(Long id,  boolean read) throws IOException {
        Notification notification=new Notification();
          Notification cc = notificationRepository.findById(notification.getId()).get();

            cc.setRead(notification.isRead());

            notificationRepository.save(cc);
        }

  /*  @Override
    public void save(NotificationDto notif) {
        Notification notification=new Notification();
       // abonnee.setUsers1(usersRepository.findById(ab.getId_prestataire()).get());
        notification.setUser(usersRepository.findById(notif.getUser().getId()));
        notification.setRead(false);
        notificationRepository.save(notification);
    }*/

 /* @Override
    public NotificationDto findByUser(Users user){
        try{
            return notificationRepository.findByUser(user);
        }catch (Exception e) {
            logger.error("Exception occur while fetch Notification by User ",e);
            return null;
        }
    }*/


}

