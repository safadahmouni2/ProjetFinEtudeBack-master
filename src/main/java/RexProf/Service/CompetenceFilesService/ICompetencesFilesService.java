package RexProf.Service.CompetenceFilesService;


import RexProf.modelDto.CompetanceFilesDto;
import RexProf.modelDto.CompetanceFilesSkillsDto;
import RexProf.modelDto.CompetanceFilesWithSkillsDto;
import java.util.List;

public interface ICompetencesFilesService {
            void addCompetancesFiles(CompetanceFilesDto c);
            List<Object[]> getAllCompetancesFiles(long id);
            List<String> getskills(long id);
            void deleteCompetancesFiles(long id);
            CompetanceFilesWithSkillsDto getCV(long id);
            void UpdateCompetancesFiles(CompetanceFilesWithSkillsDto c);
            List<CompetanceFilesWithSkillsDto> getMyCompetancesFiles(long id);
            void accept(long id);
            void reffuse(long id );
            List<CompetanceFilesSkillsDto> getCompetancesFilesSkills( );


}
