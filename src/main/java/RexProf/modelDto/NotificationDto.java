package RexProf.modelDto;

import RexProf.Entity.Abonnee;
import RexProf.Entity.Users;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NotificationDto {
    private  Long id;
    private String message;

    private Date createdAt;

    private boolean isRead;
    private String userNom;
    private String userPre;
    private byte[]  picture;
    private Long id_userAbonnee;
private Long id_user;
    public NotificationDto() {
    }
    public NotificationDto(Long id, String message, Date createdAt, boolean isRead, String userNom, String userPre, byte[]  picture, Long id_userAbonnee) {
        this.id = id;
        this.message = message;
        this.createdAt = createdAt;
        this.isRead = isRead;
        this.userNom = userNom;
        this.userPre = userPre;
        this.picture = picture;
        this.id_userAbonnee=id_userAbonnee;


    }

    public NotificationDto(Long id, String message, Date createdAt, boolean isRead) {
        this.id = id;
        this.message = message;
        this.createdAt = createdAt;
        this.isRead = isRead;
    }
}
