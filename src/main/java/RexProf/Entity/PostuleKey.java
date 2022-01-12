package RexProf.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Getter
@Setter
@Embeddable
public class PostuleKey implements Serializable {

        @Column(name = "serv_id")
        Long servId;

        @Column(name = "comp_id")
        Long compId;

        // standard constructors, getters, and setters
        // hashcode and equals implementation
    }

