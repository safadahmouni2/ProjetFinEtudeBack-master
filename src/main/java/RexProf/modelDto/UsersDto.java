package RexProf.modelDto;

import RexProf.Entity.CompetanceFiles;
import RexProf.Entity.Groups;
import RexProf.Entity.Publications;
import RexProf.Enum.CompeteEtat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class UsersDto {
    private long id;

    private String name_user;
    private String first_name;
    private String email;
    private String title;
    private String login;
    private String pwd;
    private String gender;
    private String pays;

    private int age;
    private String phone;
    private Date date_birth;
    private String description;

    private CompeteEtat etat;

    private byte[]  picture;



}
