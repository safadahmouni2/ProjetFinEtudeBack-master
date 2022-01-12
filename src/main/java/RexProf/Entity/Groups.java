package RexProf.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "groups")
public class Groups implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name_grp;
    private String desc_grp;
    private Date creation_date;
    private boolean condition;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @ManyToOne
    private Companies companies;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @ManyToMany( cascade = { CascadeType.ALL })
    private Set<Roles> roles;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @ManyToMany( cascade = { CascadeType.ALL })
    private Set<Users> users;


}
