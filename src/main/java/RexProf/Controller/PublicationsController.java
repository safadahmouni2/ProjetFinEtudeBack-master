package RexProf.Controller;

import RexProf.Entity.Publications;
import RexProf.Service.PublicationsService.IPublicationsService;
import RexProf.Service.UsersService.IUsersService;
import RexProf.modelDto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/Pub")
@RestController
public class PublicationsController {
    @Autowired
    IPublicationsService publicationsService;


    @RequestMapping(value = "/addPub", method = RequestMethod.POST)
    @ResponseBody
    public void addPub(
            @RequestBody PublicationsDto p
    ) throws IOException {
        publicationsService.addPub(p);

    }
    @RequestMapping(value = "/addPubI", method = RequestMethod.POST,consumes = "multipart/form-data")
    @ResponseBody
    public void addPubI(
            @RequestPart(value ="publicationsDto") final PublicationsDto publicationsDto,
            @RequestPart(value="file") MultipartFile file
    ) throws IOException {
        publicationsService.addPubI( publicationsDto,file);

    }
    @RequestMapping(value = "/addPubV", method = RequestMethod.POST,consumes = "multipart/form-data")
    @ResponseBody
    public void addPubV(
            @RequestPart("u") PublicationsDto p,
            @RequestPart(value="file") MultipartFile file
    ) throws IOException {
        publicationsService.addPubV( p,file);

    }
    @RequestMapping(value = "/getAllPubb", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Publications> getAllPub() {
        return publicationsService.getAllPub();
    }
    @GetMapping("/getAllPub")
    public ResponseEntity<List<PublicationsDto>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "2") Integer pageSize

          )
    {
        List<PublicationsDto> list = publicationsService.getAllWord(pageNo, pageSize);

        return new ResponseEntity<List<PublicationsDto>>(list, new HttpHeaders(), HttpStatus.OK);}
    @GetMapping("/getMesPub")
    public ResponseEntity<List<Publications>> getMesPub(
            @RequestParam("id") long id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "2") Integer pageSize

    )
    {
        List<Publications> list = publicationsService.getMesPub(id,pageNo, pageSize);

        return new ResponseEntity<List<Publications>>(list, new HttpHeaders(), HttpStatus.OK);}
    @RequestMapping(value = "/signaler", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void Activer
            (@RequestParam("id") long id)
    {
        publicationsService.signaler(id);
    }
}
