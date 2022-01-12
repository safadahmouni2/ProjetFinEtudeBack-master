package RexProf.Controller;

import RexProf.Entity.Postule;
import RexProf.Entity.Publications;
import RexProf.Entity.ServiceRequest;
import RexProf.Entity.matchingOffre;
import RexProf.Service.ServiceRequestService.IServiceRequestService;
import RexProf.modelDto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/Demande")
@RestController
public class ServiceRequestController {
    @Autowired
    IServiceRequestService requestService;



    @RequestMapping(value = "/affectation", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void addGroup(@RequestBody inputPostuleDto g) { requestService.affectation(g); }
    @RequestMapping(value = "/addSer", method = RequestMethod.POST)
    @ResponseBody
    public long addSer(
            @RequestBody ServiceRequestDto s
    ){
        return requestService.addSer(s);

    }
    @GetMapping("/getMesDem")
    public ResponseEntity<List<ServiceRequest>> getAlldem(
            @RequestParam("id") long id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "2") Integer pageSize

    )
    {
        List<ServiceRequest> list = requestService.getMesDem(id,pageNo, pageSize);

        return new ResponseEntity<List<ServiceRequest>>(list, new HttpHeaders(), HttpStatus.OK);}
    @GetMapping("/getMesDemMatche")
    public ResponseEntity<List<matchingOffre>> getAlldemMatche(
            @RequestParam("id") long id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "4") Integer pageSize

    )
    {
        List<matchingOffre> list = requestService.getMesDemMatche(id,pageNo, pageSize);

        return new ResponseEntity<List<matchingOffre>>(list, new HttpHeaders(), HttpStatus.OK);}

    @GetMapping("/getMesPostule")
    public ResponseEntity<List<Postule>> getMesPostule(
            @RequestParam("id") long id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "2") Integer pageSize

    )
    {
        List<Postule> list = requestService.getMesPostule(id,pageNo, pageSize);

        return new ResponseEntity<List<Postule>>(list, new HttpHeaders(), HttpStatus.OK);}
    @GetMapping("/getAlldem")
    public ResponseEntity<List<ServiceRequest>> getAlldem(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "2") Integer pageSize

    )
    {
        List<ServiceRequest> list = requestService.getAlldem(pageNo, pageSize);

        return new ResponseEntity<List<ServiceRequest>>(list, new HttpHeaders(), HttpStatus.OK);}
    @RequestMapping(value = "/getSer", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ServiceRequestDto getSer(@RequestParam("id") long id) {
        return requestService.getSer(id);
    }
    @GetMapping("/getdemMatching")
    public ResponseEntity<List<matchingOffre>> getdemMatching(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "2") Integer pageSize

    )
    {
        List<matchingOffre> list = requestService.getdemMatching(pageNo, pageSize);

        return new ResponseEntity<List<matchingOffre>>(list, new HttpHeaders(), HttpStatus.OK);}

}
