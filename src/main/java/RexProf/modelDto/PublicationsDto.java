package RexProf.modelDto;

import RexProf.Entity.Commentaire;
import RexProf.Entity.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public  class PublicationsDto   {

    private Long id;
    private String status;
    private byte[] video;
    private byte[] image;
    private Date start_date;
   // private Date last_modif;
    private boolean visibility;
  //  private boolean enable;
    private UsersDto users;
    private Set<Commentaire> commentaire;

    private List<Long> likes;


}
