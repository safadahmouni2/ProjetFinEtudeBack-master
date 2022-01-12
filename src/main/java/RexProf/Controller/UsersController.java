package RexProf.Controller;

import RexProf.Entity.Users;
import RexProf.Repository.UsersRepository;
import RexProf.Service.UsersService.IUsersService;
import RexProf.modelDto.AuthResult;
import RexProf.modelDto.CompetanceFilesDto;
import RexProf.modelDto.CompetanceFilesWithSkillsDto;
import RexProf.modelDto.UsersDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/Users")
@RestController
public class UsersController {
    @Autowired
    IUsersService usersService;
    @Autowired
    UsersRepository usersRepository;
    @PostMapping("/findByNameLike")
    public List<Users> findAllByNameLike(@RequestBody UsersDto userSearchDTO)
    {
        try
        {
            if (userSearchDTO.getName_user().length()>=3)
            {
                return usersRepository.findByNameLike(userSearchDTO.getName_user());
            }

        }
        catch(Exception e)
        {

        }
        return null ;
    }
    @RequestMapping(value = "/doLogin", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public AuthResult DoLogin(@RequestParam("email") String email, @RequestParam("pwd") String pwd) {

        /*Users e = usersService.DoLogin(email, pwd);
        if (e != null && e.getToken()==null) {
            String token = getJWTToken(e);
            e.setToken(token);
        }
        return e;*/

        return usersService.DoLogin(email,pwd);
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public void addUser(
            @RequestPart("u") final UsersDto u, @RequestPart(value="file",required=false)  final MultipartFile file
    ) throws IOException {
        usersService.addUser(u, file);

    }


    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<UsersDto> getUsers() {
        return usersService.getAllUsers();
    }


    @RequestMapping(value = "/getUserID", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public UsersDto getUserID(@RequestParam("id") long id) {
        return usersService.getUser(id);
    }



    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void deleteRole(@RequestParam("id") long id) {
        usersService.deleteUsers(id);
    }



    @RequestMapping(value = "/updateUsers", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void ModifierFile(
    @RequestPart("u") final UsersDto u, @RequestPart(value="file",required=false)  final MultipartFile file) throws IOException {
        usersService.UpdateUsers(u,file);
    }
    @RequestMapping(value = "/Bloque", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void Bloque
            (@RequestParam("id") long id)
     {
        usersService.bloque(id);
    }
    @RequestMapping(value = "/Active", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void Activer
            (@RequestParam("id") long id)
      {
        usersService.activer(id);
    }
    @RequestMapping(value = "/getNBRUsers", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public int getNBR() {
        return usersService.getNBRuser();
    }
    @RequestMapping(value = "/getNBRuserA", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public int getNBRuserA() {
        return usersService.getNBRuserA();
    }
    @RequestMapping(value = "/getNBRuserD", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public int getNBRuserD() {
        return usersService.getNBRuserD();
    }
    @RequestMapping(value = "/getNBRuserB", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public int getNBRuserB() {
        return usersService.getNBRuserB();
    }
}
