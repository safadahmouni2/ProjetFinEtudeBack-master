package RexProf.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
@Entity
@Data
@Table(name = "roles")
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name_roles;
    private String desc_roles;
    private boolean condition;
    @OnDelete(action = OnDeleteAction.CASCADE)
   // @JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.ALL
    },mappedBy = "roles")
    private Set<Groups> groups;

   }