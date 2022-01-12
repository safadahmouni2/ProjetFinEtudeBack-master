package RexProf.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private String current_domination;
    private String address;
    private String function;
    private String responsable;
    private String naf_code;
    private String siret;
    private String siren;
    private String social_reason;
    private int fax_num;
    private int phone_num;
   @OneToMany(cascade = CascadeType.ALL,mappedBy="companies",fetch=FetchType.LAZY)
   private Set<Groups> groups;


}
