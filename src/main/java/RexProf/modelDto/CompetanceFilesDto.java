package RexProf.modelDto;

import RexProf.Entity.Users;
import RexProf.security.services.UserPrinciple;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CompetanceFilesDto {
    private Long id;

    private String name;
    private String mail;
    private String phone;
    private Date date;
    private Users users;
    private String[] poste;
    private String[] skills;
    private String[] experiences;
    private String[] languages;
    private String[] ecole;


}
