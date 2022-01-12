package RexProf.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "competanceFiles")
public class CompetanceFiles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String mail;
    private String phone;
    private Date date;

    @JsonIgnore
    @ManyToOne
    private Users users;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @OneToMany(cascade = {
            CascadeType.ALL
    },mappedBy = "competanceFiles")
    private Set<Postule> postules;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(targetEntity = Skills.class,cascade = CascadeType.ALL,mappedBy="competanceFiles",fetch=FetchType.LAZY)
    private Set<Skills> skills;
    @OnDelete(action = OnDeleteAction.CASCADE)

    @OneToMany(targetEntity = Experiences.class,cascade = CascadeType.ALL,mappedBy="competanceFiles",fetch=FetchType.LAZY)
    private Set<Experiences> experiences;
    @OnDelete(action = OnDeleteAction.CASCADE)

    @OneToMany(targetEntity = Ecole.class,cascade = CascadeType.ALL,mappedBy="competanceFiles",fetch=FetchType.LAZY)
    private Set<Ecole> ecole;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(targetEntity = Languages.class,cascade = CascadeType.ALL,mappedBy="competanceFiles",fetch=FetchType.LAZY)
    private Set<Languages> languages;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(targetEntity = Poste.class,cascade = CascadeType.ALL,mappedBy="competanceFiles",fetch=FetchType.LAZY)
    private Set<Poste> poste;

    }
