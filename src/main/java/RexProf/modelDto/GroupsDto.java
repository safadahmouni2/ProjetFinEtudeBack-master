package RexProf.modelDto;

import RexProf.Entity.Companies;
import RexProf.Entity.Roles;
import RexProf.Entity.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class GroupsDto {
    private long id;
    private String name_grp;
    private String desc_grp;
    private Date creation_date;
    private boolean condition;
    private Set<RolesDto> roles;
    private Set<UsersDto> users;
    //private Set<Roles> roles=new HashSet<Roles>() ;

   // private Set<Users> users;



}
