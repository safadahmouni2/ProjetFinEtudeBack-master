package RexProf.modelDto;

import RexProf.Entity.CompetanceFiles;
import RexProf.Entity.Publications;
import RexProf.Entity.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class ServiceRequestDto {
    private Long id;

    private boolean visibility;
    private boolean enable;
    private String title;
    private String description;
    private String link;
    private int duration;
    private Date start_date;
    private Date closing_date;
    private Date dateCreation;

    private Set<CompetanceFiles> competanceFiles;
    private Users users ;

}
