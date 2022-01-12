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
public class Commentaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Date date;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "publication_id")
    Publications publications;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users users;
}
