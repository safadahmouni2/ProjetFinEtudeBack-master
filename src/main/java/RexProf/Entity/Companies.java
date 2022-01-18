package RexProf.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "companies")
public class Companies implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String societe_nom;
    private String address;
    private String fonction;
    private String responsable;
    private String naf_code;
    private String siret;

    private String social_reason;
    private int fax_num;
    private int phone_num;
   @OneToMany(cascade = CascadeType.ALL,mappedBy="companies",fetch=FetchType.LAZY)
   private Set<Groups> groups;


}
