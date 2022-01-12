package RexProf.modelDto;

import RexProf.Entity.CompetanceFiles;
import RexProf.Entity.Roles;
import RexProf.Entity.ServiceRequest;
import RexProf.Entity.Users;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DemandeCompDto {
private long id;
    //private Set<Groups> groups=new HashSet<Groups>();
    //private Set<ServiceRequest> serviceRequests;
  private CompetanceFiles competanceFiles;

   // private Set<Users> users;



}
