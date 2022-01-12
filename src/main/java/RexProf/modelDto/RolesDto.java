package RexProf.modelDto;

import RexProf.Entity.Groups;
import RexProf.Entity.Roles;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class RolesDto {
    private long id;
    private String name_roles;
    private String desc_roles;
    private boolean condition;
   // private Set<Groups> groups=new HashSet<Groups>() ;



}
