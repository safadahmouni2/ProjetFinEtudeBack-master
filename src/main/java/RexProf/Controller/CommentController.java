package RexProf.Controller;

import RexProf.Entity.Commentaire;
import RexProf.Entity.Publications;
import RexProf.Service.CommentaireService.ICommentService;
import RexProf.Service.aimeService.IAimeService;
import RexProf.modelDto.aimeDto;
import RexProf.modelDto.commentaireDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/Comment")
@RestController
public class CommentController {
    @Autowired
    ICommentService commentService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void aime(@RequestBody commentaireDto g) { commentService.comment(g); }
    @GetMapping("/getCommentaires")
    public ResponseEntity<List<Commentaire>> getCommentaires(
            @RequestParam("id") long id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "2") Integer pageSize

    )
    {
        List<Commentaire> list = commentService.getCommentaires(id,pageNo, pageSize);

        return new ResponseEntity<List<Commentaire>>(list, new HttpHeaders(), HttpStatus.OK);}
}

