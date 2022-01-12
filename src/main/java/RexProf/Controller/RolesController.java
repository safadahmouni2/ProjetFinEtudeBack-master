package RexProf.Controller;

import RexProf.Entity.Roles;
import RexProf.Service.RolesService.IRolesService;
import RexProf.modelDto.RolesDto;
import RexProf.modelDto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/Roles")
@RestController
public class RolesController {
    @Autowired
    IRolesService rolesService;



    @RequestMapping(value = "/getAllRoles", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<RolesDto> getAllRoles() {
        return rolesService.getAllRoles();
    }

    @RequestMapping(value = "/addRole", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void addClasse(@RequestParam("nom") String nom,@RequestParam("x") String des) {
        rolesService.addRole(nom,des);
    }

    @RequestMapping(value = "/deleterole", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void deleteRole(@RequestParam("id") long id) {
        rolesService.deleteRole(id);
    }

    @RequestMapping(value = "/updateRole", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void ModifierFile(@RequestBody Roles r)  {
        rolesService.UpdateRoles(r);
    }
    @RequestMapping(value = "/Desactive", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void Desactive
            (@RequestParam("id") long id)
    {
        rolesService.desactive(id);
    }
    @RequestMapping(value = "/Active", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void Activer
            (@RequestParam("id") long id)
    {
        rolesService.Active(id);
    }
    @RequestMapping(value = "/getRolesID", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public RolesDto getRoleID(@RequestParam("id") long id) {
        return rolesService.getRole(id);
    }
    @RequestMapping(value = "/Change", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void Change
            (@RequestParam("id") long id)
    {
        rolesService.change(id);
    }
    @RequestMapping(value = "/getNBRole", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public int getNBRole() {
        return rolesService.getNBRole();
    }
    @RequestMapping(value = "/getNBRoleA", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public int getNBRoleA() {
        return rolesService.getNBRoleA();
    }
    @RequestMapping(value = "/getNBRoleD", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public int getNBRoleD() {
        return rolesService.getNBRoleD();
    }
}
