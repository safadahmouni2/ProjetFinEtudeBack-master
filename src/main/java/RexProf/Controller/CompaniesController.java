package RexProf.Controller;

import RexProf.Repository.CompaniesRepository;
import RexProf.modelDto.CompaniesDto;
import RexProf.modelDto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/companies")
@RestController
public class CompaniesController {

    @Autowired
    CompaniesRepository companiesRepository;
   /* @RequestMapping(value = "/https://entreprise.data.gouv.fr/api/sirene/v3/", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
   /public  getSiret() {
     //   return companiesRepository.findById();
    }*/


}
