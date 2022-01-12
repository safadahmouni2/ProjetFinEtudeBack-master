package RexProf.Entity;


import RexProf.Enum.AbonneeEtat;
import RexProf.Enum.CompeteEtat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "abonnes")
public class Abonnee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   private Boolean etat;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @ManyToOne

    @JoinColumn(name = "id_prestataire")
    Users users1;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @ManyToOne

    @JoinColumn(name = "id_abonnee")
    Users users2;


}