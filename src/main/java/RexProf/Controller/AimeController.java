package RexProf.Controller;

import RexProf.Service.GroupsService.IGroupsService;
import RexProf.Service.aimeService.IAimeService;
import RexProf.modelDto.aimeDto;
import RexProf.modelDto.GroupsRoleDto;
import RexProf.modelDto.inputPostuleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/Aime")
@RestController
public class AimeController {
    @Autowired
    IAimeService aimeService;

    @RequestMapping(value = "/getNBRAime", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public int getNBRAime(@RequestParam("id") long id) {
        return aimeService.getNBRAime(id);
    }


    @RequestMapping(value = "/aime", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void aime(@RequestBody aimeDto g) { aimeService.aime(g); }


    @RequestMapping(value = "/aimepas", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void aimepas(@RequestParam("id") long id,@RequestParam("idP") long idP) {
         aimeService.aimepas(id,idP);
    }

}

