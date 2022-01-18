package RexProf.modelDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompaniesDto {
    private Long id_companies;
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
    private String[] groups;


}
