package RexProf.modelDto;

import RexProf.Entity.Abonnee;
import RexProf.Entity.Users;
import lombok.Data;

import java.util.Date;

@Data
public class NotificationDto {
    private  Long id;
    private String message;

    private Date createdAt;

    private boolean isRead;
    private Users user;
    private Abonnee abonnee;

    public NotificationDto(Long id, Users user) {
        this.id = id;
        this.user = user;
    }
}
