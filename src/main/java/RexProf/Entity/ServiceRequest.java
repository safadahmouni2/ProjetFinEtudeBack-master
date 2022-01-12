package RexProf.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "serviceRequest")
public class ServiceRequest implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean visibility;
    private boolean enable;
    private String title;
    private String description;
    private String link;
    private int duration;
    private Date dateCreation;
    private Date start_date;
    private Date closing_date;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @OneToMany(cascade = {
            CascadeType.ALL
    },mappedBy = "serviceRequest")
    private Set<Postule> postules;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @OneToMany(cascade = {
            CascadeType.ALL
    },mappedBy = "serviceRequest")
    private Set<matchingOffre> matchingOffres;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    private Users user;


}
