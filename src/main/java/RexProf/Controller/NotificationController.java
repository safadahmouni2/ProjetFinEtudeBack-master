package RexProf.Controller;

import RexProf.Entity.Notification;
import RexProf.Repository.NotificationRepository;
import RexProf.Service.NotificationService.NotificationService;
import RexProf.modelDto.NotificationDto;
import RexProf.modelDto.PublicationsDto;
import RexProf.modelDto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/notifications")
@RestController
public class NotificationController {
    @Autowired
    NotificationService notificationService;
    @Autowired
    NotificationRepository notificationRepository;

    //*********count Notifications******
    @RequestMapping(value = "/countNotif", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public int countNotif (@RequestParam ("id_user") long id_user) {
        return notificationService.countNotif(id_user);
    }
    //********add Notif***********
    @RequestMapping(value = "/addNotif", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void addNotif(@RequestBody Notification notif) {
        notificationService.save(notif);
    }
    //get notification unread for each user
    @GetMapping(value="/getNotificationsByUser")
    public ResponseEntity<List<NotificationDto>> getNotificationsByUser(
            @RequestParam ("id") Long id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "2") Integer pageSize){
        List<NotificationDto> list=notificationService.userNotification(id,pageNo, pageSize);
        return new ResponseEntity<List<NotificationDto>>(list, new HttpHeaders(), HttpStatus.OK);}
    //get all notification for each user
    @GetMapping(value="/listNotificationsByUser")
    public ResponseEntity<List<NotificationDto>> listNotificationsByUser(
            @RequestParam ("id") Long id){
        List<NotificationDto> list=notificationService.listNotification(id);
        return new ResponseEntity<List<NotificationDto>>(list, new HttpHeaders(), HttpStatus.OK);}


   /* @RequestMapping(value="/getNotificationsByUser",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<NotificationDto>> getNotificationsByUser(){
        return notificationRepository.f();
    }*/

    @RequestMapping(value = "/isRead", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void isRead
            (@RequestParam("id") long id)
    {
        notificationService.isRead(id);
    }

    @RequestMapping(value = "/updateNotification", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void updateNotification
            (@RequestParam("id") long id,
             @RequestParam("read") boolean read) throws IOException {
        notificationService.UpdateNotification(id,read);
    }
}
