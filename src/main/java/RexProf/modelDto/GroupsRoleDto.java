package RexProf.modelDto;

import RexProf.Entity.Groups;
import RexProf.Entity.Roles;
import RexProf.Entity.Users;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class GroupsRoleDto {
private long id;
    //private Set<Groups> groups=new HashSet<Groups>();
    private Set<Roles> roles;
    private Set<Users> users;

   // private Set<Users> users;



}
