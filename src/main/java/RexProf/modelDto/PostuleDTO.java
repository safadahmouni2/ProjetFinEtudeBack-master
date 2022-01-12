package RexProf.modelDto;

import RexProf.Entity.CompetanceFiles;
import RexProf.Entity.ServiceRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostuleDTO {
    long id;
    ServiceRequest serviceRequest;
    //CompetanceFiles competanceFiles;
    int selected ;
    private long score;
}
