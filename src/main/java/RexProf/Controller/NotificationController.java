package RexProf.Controller;

import RexProf.Entity.Notification;
import RexProf.Entity.Publications;
import RexProf.Entity.Users;
import RexProf.Repository.NotificationRepository;
import RexProf.Service.NotificationService.NotificationService;
import RexProf.modelDto.NotificationDto;
import RexProf.modelDto.PublicationsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/notifications")
@RestController
public class NotificationController {
    @Autowired
    NotificationService notificationService;
    @Autowired
    NotificationRepository notificationRepository;
    //********add Notif***********
    @RequestMapping(value = "/addNotif", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void addNotif(@RequestBody Notification notif) {
        notificationService.save(notif);
    }

    @RequestMapping(value="/getNotificationsByUser",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Notification>> getNotificationsByUser(
            @RequestParam ("id") Long id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "2") Integer pageSize){
        List<Notification> list=notificationService.userNotification(id,pageNo, pageSize);
        return new ResponseEntity<List<Notification>>(list, new HttpHeaders(), HttpStatus.OK);}


   /* @RequestMapping(value="/getNotificationsByUser",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<NotificationDto>> getNotificationsByUser(){
        return notificationRepository.f();
    }*/
    //***getAll Notification*****

    @RequestMapping(value = "/getAllNotification", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Notification> getAllNotification(@RequestParam ("id_user") Long id_user ) {
        return  this.notificationService.gettAllNotification(id_user);
    }

}
