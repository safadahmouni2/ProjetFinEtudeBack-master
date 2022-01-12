package RexProf.Service.CommentaireService;

import RexProf.Entity.Commentaire;
import RexProf.Entity.Publications;
import RexProf.modelDto.aimeDto;
import RexProf.modelDto.commentaireDto;

import java.util.List;

public interface ICommentService {
    void comment(commentaireDto g);
    List<Commentaire> getCommentaires(long id, Integer pageNo, Integer pageSize);



}
