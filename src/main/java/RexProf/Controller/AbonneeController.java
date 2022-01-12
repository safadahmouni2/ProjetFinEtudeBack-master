package RexProf.Controller;

import RexProf.Entity.Abonnee;
import RexProf.Entity.Users;
import RexProf.Repository.AbonneeRepository;
import RexProf.Service.AbonneeService.IAbonneeService;
import RexProf.modelDto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/abonnees")
@RestController

public class AbonneeController {

    @Autowired
    IAbonneeService abonneeService;
    @Autowired
    AbonneeRepository abonneeRepository;

    //*********count abonnee******
    @RequestMapping(value = "/countAbonnements", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public int countAbonnements(@RequestParam ("id_abonnee") long id_abonnee) {
        return abonneeService.countAbonnements(id_abonnee);
    }
    //*********count abonnements******

    @RequestMapping(value = "/countAbonnees", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public int countAbonnees (@RequestParam ("id_prestataire") long id_prestataire) {
        return abonneeService.countAbonnees(id_prestataire);
    }

//***getAll Abonnemenets*****

    @RequestMapping(value = "/getAllAbonnement", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Users> getAllAbonement(@RequestParam ("id_abonnee") Long id_abonnee ) {
        return  this.abonneeService.gettAllAbonnement(id_abonnee);
    }
    //***getAll Abonnés*****

    @RequestMapping(value = "/getAllAbonnes", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Users> getAllAbonees(@RequestParam ("id_prestataire") Long id_prestataire ) {
        return  this.abonneeService.getAllAbonnes(id_prestataire);
    }


    //***get etat Abonnement *****
    @RequestMapping(value = "/getEtatAbonnement", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Boolean getEtatAbonnement(@RequestParam("id_prestataire") Long id_prestataire,
                                   @RequestParam("id_abonnee") Long id_abonnee ) {
        return this.abonneeService.getEtatAbonnement(id_prestataire ,id_abonnee);
    }
    //***get etat Abonne *****
    @RequestMapping(value = "/getEtatAbonne", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Boolean getEtatAbonne(
            @RequestParam("id_abonnee") Long id_abonnee,
            @RequestParam ("id_prestataire") Long id_prestataire)
                                      {
        return this.abonneeService.getEtatAbonne(id_prestataire,id_abonnee );
    }

    //********add abonee***********
    @RequestMapping(value = "/addAbonnee", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void addAbonnee(@RequestBody abonneeDto ab) {
        abonneeService.addAbonnee(ab);
    }


    //*********delete abonnee (se désabonner)******
   /* @RequestMapping(value = "/desabonner", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void deleteAbonnee(@RequestParam("id") long id) {
        abonneeRepository.deleteById(id);
    }*/
    @DeleteMapping("/desabonner/{id}")
    void deleteAbonnnee(@PathVariable("id") Long id) {
        abonneeRepository.deleteById(id);
    }

    /*@RequestMapping(value = "/desabonner", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void deleteAbon(@RequestParam("id") long id) {
        abonneeService.deleteAbonnee(id);
    }*/
}
