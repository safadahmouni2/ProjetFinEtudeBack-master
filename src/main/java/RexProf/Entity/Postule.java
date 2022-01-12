package RexProf.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Postule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @ManyToOne
    @JoinColumn(name = "service_id")
    ServiceRequest serviceRequest;

    @ManyToOne
    @JoinColumn(name = "comp_id")
    CompetanceFiles competanceFiles;

    int selected ;
}
