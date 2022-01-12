package RexProf.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "publications")
public  class Publications implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;
    private int signaler;
    private int aimes;

    private byte[] video;
    private byte[] image;
    private Date start_date;
    private Date last_modif;
    private boolean visibility;
    //private boolean enable;
    @OnDelete(action = OnDeleteAction.CASCADE)

    @ManyToOne
    private Users users;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(cascade = {
            CascadeType.ALL
    },mappedBy = "publications")
    private Set<Aime> aime;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(cascade = {
            CascadeType.ALL
    },mappedBy = "publications")
    private Set<Commentaire> commentaire;


}
