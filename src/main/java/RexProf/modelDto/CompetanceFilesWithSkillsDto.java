package RexProf.modelDto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CompetanceFilesWithSkillsDto {
    private Long id;
    private String name;
    private String mail;
    private String phone;
    private Date date;

    private PosteDto[] poste;
    private SkillsDto[] skills;
    private ExperienceDto[] experiences;
    private LanguagesDto[] languages;
    private EcoleDto[] ecole;
}
