package RexProf.Controller;

import RexProf.Entity.CompetanceFiles;
import RexProf.Entity.Postule;
import RexProf.Entity.ServiceRequest;
import RexProf.Entity.Skills;
import RexProf.Service.CompetenceFilesService.CompetencesFilesService;
import RexProf.modelDto.CompetanceFilesDto;
import RexProf.modelDto.CompetanceFilesSkillsDto;
import RexProf.modelDto.CompetanceFilesWithSkillsDto;
import RexProf.modelDto.PostuleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/CompetenceFiles")
@RestController
public class CompetenceFilesController {
    @Autowired
    CompetencesFilesService competencesFilesService;

    @RequestMapping(value = "/Accept", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void accept(@RequestParam("id") long id) {
        competencesFilesService.accept(id);
    }
    @RequestMapping(value = "/Reffuse", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void reffuse(@RequestParam("id") long id) {
        competencesFilesService.reffuse(id);
    }

    @RequestMapping(value = "/getCompetencesFilesID", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public CompetanceFilesWithSkillsDto getCVID(@RequestParam("id") long id) {
        return competencesFilesService.getCV(id);
    }
    @RequestMapping(value = "/getCompetancesFilesSkills", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<CompetanceFilesSkillsDto> getCompetancesFilesSkills() {
        return competencesFilesService.getCompetancesFilesSkills();
    }

    @GetMapping("/getCompetencesFiles")
    public List<Object[]> getAlldem(
            @RequestParam("id") long id
               ) {
        return competencesFilesService.getAllCompetancesFiles(id);
    }

    @RequestMapping(value = "/getMine", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<CompetanceFilesWithSkillsDto> getMine(@RequestParam("id") long id) {
        return competencesFilesService.getMyCompetancesFiles(id);
    }
    @RequestMapping(value = "/getSkill", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<String> getSkills(@RequestParam("id") long id) {
        return competencesFilesService.getskills(id);
    }

    @RequestMapping(value = "/addCompetencesFiles", method = RequestMethod.POST)
    @ResponseBody
    public void addClasse(
            @RequestBody CompetanceFilesDto c
    ) {
        competencesFilesService.addCompetancesFiles(c);
    }

    @RequestMapping(value = "/deleteCompetencesFiles", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void deleteRole(@RequestParam("id") long id) {
        competencesFilesService.deleteCompetancesFiles(id);
    }

    @RequestMapping(value = "/updateCompetencesFiles", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void ModifierFile(
            @RequestBody CompetanceFilesWithSkillsDto c
           )  {
        competencesFilesService.UpdateCompetancesFiles(c);
    }
}
