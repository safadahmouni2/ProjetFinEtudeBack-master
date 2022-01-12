package RexProf.modelDto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CompetanceFilesSkillsDto {
    private Long id;
    private SkillsDto[] skills;
    private UsersDto users;
}
