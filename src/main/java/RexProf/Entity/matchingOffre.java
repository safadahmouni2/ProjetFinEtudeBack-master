package RexProf.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@Entity
public class matchingOffre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long score;


    @ManyToOne
    @JoinColumn(name = "Service_id")
    ServiceRequest serviceRequest;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users users;
}
